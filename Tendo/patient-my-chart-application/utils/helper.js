const database = require('./../database/database.js');
const logger = require('./logger.js');
const exec = require('child_process').exec;
const fs = require('fs');
var Validator = require('jsonschema').Validator;
var schemaValidator = new Validator();

const log = logger.log;

let helper = {
      ADMIN_SECRET :"57ACFA98-D829-3BF7-C4D9-B27E7C12C6BF",
      hasadminaccess: function adminaccess(secret){
        if(secret === helper.ADMIN_SECRET){
            return true;
          }else{
            return false;
          }
  
      },
      hasuseraccess: function useraccess(associateId, secret){
        var whereClause = "@userId == '" + associateId + "' " ;
        var associate = JSON.parse(JSON.stringify( database.tables.users.where(whereClause)));

        if (Object.keys(associate.items).length > 0){
          var token = associate.items[0].securitytoken;
          if (token === null || typeof token === 'undefined') return true;
          if(secret.trim() == associate.items[0].securitytoken){
            return true;
          } else{
            return false;
          }  
        }else{
          return false;
        }
      },
      sendaccessdenied: function accessdenied(req,res){
        var jsonText = "{ \"status\" : \"FAILURE\" , \"message\" :  \"Sorry! you do not have admin access to perform this operation.\" }";
        obj = JSON.parse(jsonText);
        var associateId = req.query.associateId;
        if(typeof req.query.associateId === 'undefined'? req.body.associateId: req.query.associateId) {
            log.info('Sorry ' + associateId + '!! you do not have admin access to perform this operation');
        }
        return res.writeHead(200).end(JSON.stringify(obj, null, 3));
      },
      isValidProduct: function doProductValidation(name,abbreviation){
        var size = Object.keys(database.tables.products.items).length;
        for (let index = 0; index < size; index++) {
          if ((database.tables.products.items[index].productName === name || 
            database.tables.products.items[index].productAbbreviation === abbreviation)){
             return false;
            }
        }
        return true;
      },
      getlocks : function doGetLocks(req){
        try{

            var tenantMnemonic= typeof req.query.tenantMnemonic === 'undefined'? req.body.tenantMnemonic: req.query.tenantMnemonic;
            var environment = typeof req.query.environment === 'undefined'? req.body.environment: req.query.environment;
            var productId = typeof req.query.productId  === 'undefined'? req.body.productId: req.query.productId;
            var whereClause = ""
            if( typeof req.query.productId !== "undefined"  || typeof req.body.productId !== "undefined" ){
                whereClause = "@productId == '" + productId + "'" ;
            }
            if(typeof req.query.tenantMnemonic !== "undefined" || typeof req.body.tenantMnemonic !== "undefined" ){
                if (whereClause !==""){
                    whereClause = whereClause + " && " + "@tenantMnemonic == '" + tenantMnemonic + "'" ;
                }
            }
            if(typeof req.query.environment !== "undefined" || typeof req.body.environment !== "undefined" ){
                if (whereClause !==""){
                    whereClause = whereClause + " && " + "@environment == '" + environment + "'" ;
                }
            }
            if( whereClause === ""){
                return database.tables.locks;
            }else{
                return database.tables.locks.where(whereClause);
            }
           
        }catch(err){
            log.warn(err);
          }
      },
      getTenants: function doGetTenantsForEnvironment(request){
        var env = typeof request.query.environment !== 'undefined'? request.query.environment:request.body.environment;
        if (env === "PROD"){
          return database.tables.tenants.prod;
        }else if (env === "STAGING"){
          return database.tables.tenants.staging;
        }else if (env === "DEV"){
          return database.tables.tenants.dev;
        }
      },
      //TBD  May need this to be a configurable attribute in the tool.
      getProductFolderName: function doGetProductFolderName(productId){
        if(productId.toUpperCase() === "CID") 
          return "conditionidentification";
        if(productId.toUpperCase() === "HCC") 
          return "hcc";
        if(productId.toUpperCase() === "PHN") 
          return "providernetworks";
      },
      getTerraformModuleFolderLocation: function doGetModuleFolderLocation(productId,properties){
        try {
          var module_path = "hi.terraform.provider." + productId.toLowerCase() + ".module.path"; 
          var root = properties.get("hi.terraform.provider.github.path");
          module_path = properties.get(module_path);
          module_folder_name = module_path.split('modules/').pop();
          var module_folder_location = root + "/modules/" + module_folder_name
          return module_folder_location;
        }
        catch (err) { 
            log.warn(err);
        }
      },
      getTerraformConfigFolderLocation: function doCreateConfigFolderIfNotExist(productId, tenantMnemonic,environment,properties){
        try {
          var root = properties.get('hi.terraform.provider.github.path');
          var tenantFolder, productFolder, envFolder;
          tenantFolder= root + "/configs/" + tenantMnemonic;
          
          // check tenant folder exists?
          if (fs.existsSync(tenantFolder) ){
              envFolder = tenantFolder + "/" +  environment.toLowerCase();
          
            // check environment folder exists?
            if(fs.existsSync(envFolder)){
              
              productFolder = envFolder + "/" +  helper.getProductFolderName(productId);
              // check product folder exists?
              if(fs.existsSync(productFolder)){
                  return productFolder;
              }else{
                //create product folder
                fs.mkdirSync(productFolder);
                return productFolder;
              }
            }else{
              //create environment folder
              fs.mkdirSync(envFolder);
              //create product folder
              productFolder = envFolder + "/" +  helper.getProductFolderName(productId);
              fs.mkdirSync(productFolder);
            }
          }else{
            // create tenant folder
            fs.mkdirSync(tenantFolder);
            //create environment folder
            envFolder = tenantFolder + "/" +  environment.toLowerCase();
            fs.mkdirSync(envFolder);
            //create environment folder
            productFolder = envFolder + "/" +  helper.getProductFolderName(productId);
            fs.mkdirSync(productFolder);
            return productFolder;
          }
        }
        catch (err) { console.error( err ) }
      },
      getContentForMainTerra: function getMainTerra(tenantMnemonic,env,productId,properties){
        var envZone,systemAccountUrl;
        console.log("ENVIRONEMENT : " + env);
        if(env.toUpperCase() === "DEV"){
          envZone ="Dev";
          systemAccountUrl="https://api.devcernercare.com/oauth/access"
        }
        else if(env.toUpperCase() === "STAGING"){
          envZone ="SphereStageZone0";
          systemAccountUrl="https://api.sandboxcernercare.com/oauth/access"
        }
        else if(env.toUpperCase() === "PROD"){
          envZone ="SphereZone1"; // If you are using public API it automatically resolves to the specific zones.
          systemAccountUrl="https://api.cernercare.com/oauth/access"
        }
  
        var content = `
            variable "system_account_key" {
                type        = string
                description = "The HealtheIntent system account key"
            }
            variable "system_account_secret" {
                type        = string
                description = "The HealtheIntent system account secret"
            }
            provider "hi" {
                tenant_mnemonic       = "{{tenant_mnemonic}}"
                environment_and_zone  = "{{environment_and_zone}}"
                system_account_key    = var.system_account_key
                system_account_secret = var.system_account_secret
                system_account_url    = "{{system_account_url}}"
            }
            module "{{productId}}" {
                source                        = "{{module_source}}"  
                cid_configuration_data        = "{{configuration_data}}"
            }` ;
        productId = productId.toLowerCase();
        var module_path = "hi.terraform.provider." + productId + ".module.path";
        var configuration_file = productId + "_" + tenantMnemonic + "_configuration.json";
        content = content.replace("{{productId}}", productId);
        content = content.replace("{{tenant_mnemonic}}", tenantMnemonic);
        content = content.replace("{{environment_and_zone}}", envZone);
        content = content.replace("{{system_account_url}}", systemAccountUrl);
        content = content.replace("{{module_source}}", properties.get(module_path));
        content = content.replace("{{configuration_data}}", "${file(\"./"+ configuration_file +"\")}" );
  
        return content;
  
      },
      createMainTerraFormFileIfNotExist: function doCreateTerraFormMainFile(path,tenantMnemonic,env,productId,properties){
        try {
          path = path + "/main.tf";
          if (!fs.existsSync(path)){
            fs.writeFileSync(path, helper.getContentForMainTerra(tenantMnemonic,env,productId,properties));
          }
        }
        catch (err) { 
            log.warn( err ) 
        }
      },
      validatejsonschema: function jsonschemavalidator(json,productId,properties){
        try {
          var schemaPath = helper.getTerraformModuleFolderLocation(productId,properties) + '/' + productId + "_configuration_schema.json"
          const data = fs.readFileSync(schemaPath);
          let jsonSchema = JSON.parse(data);
          var result = schemaValidator.validate(JSON.parse(json), jsonSchema, {nestedErrors: true});
          return result.toString();
        }
        catch (err) { 
            log.warn( err ) 
        }
      },
      generatereport: async function doGenerateReport(filename){
        var input = __dirname + "/public/reports/" + filename + ".html";
        var output = __dirname +  "/public/reports/" + filename + ".pdf";
        input = input.replace("/utils","");
        output = output.replace("/utils","");
        var command = "wkhtmltopdf --disable-external-links --margin-top 20 " + input  + " " + output;
        var generator = new helper.getcommandexecutor();
        try{
          var result = await generator.execCommand(command);
        }catch (err){
          log.warn("The above error is identified while creating the pdf report, however the report has been successfully created. ");
          return "";
        }
        return "/reports/" + filename + ".pdf";
      },
      getcommandexecutor:  function doExecuteCommand(command){
        this.execCommand = function (command) {
                return new Promise((resolve, reject)=> {
                   exec(command, (error, stdout, stderr) => {
                     if (error) {
                        reject(error);
                         log.warn(error);
                        return;
                    }
                    resolve(stdout)
                   });
               })
           }
      },

      generategraph: async function doGenerateGraph(request, properties, filename){
        var output = __dirname +  "/public/reports/" + filename ;
        output = output.replace("/utils","");
        var command = helper.getTerraformGraphCommand(request,properties,output);

        var grapher = new helper.getcommandexecutor();
        try{
          var result = await grapher.execCommand(command);
        }catch (err){
          log.warn("The above error is identified while creating the terraform graph." + err);
          return "";
        }
        return "/reports/" + filename;
      },
      
      getFilenameForTerraformOutput: function doGetFilenameForTerraformOutput(request){
        var action = request.query.action;
        var tenantMnemonic = request.query.tenantMnemonic;
        var environment = request.query.environment;
        var productId = request.query.productId;
        return "./public/reports/"  + tenantMnemonic + "_" + productId + "_" + environment + "_" + action + ".html";
      },
      getProductName: function doGetProductName(productId){
        var size = Object.keys(database.tables.products.items).length;
        for (let index = 0; index < size; index++) {
          if ((database.tables.products.items[index].productAbbreviation === productId )){
            return database.tables.products.items[index].productName;
            }
        }
      },
      saveAuditRecord: function doSaveAuditRecord(request,result,properties){
        try {
            var tenant = helper.getTenants(request).get(parseInt(request.query.tenantcid));
            var tenantMnemonic = tenant.tenantMnemonic;
            var tenantName = tenant.tenantName;
            var environment = request.query.environment;
            var userId = request.query.userId;
            var productName = helper.getProductName (request.query.productId);
            var action = request.query.action;
            var jiraNumber = request.query.jiraNumber;
            var auditMaxCount = parseInt(properties.get("hi.onboarding.tool.audit.save.count.max"));
            const current = new Date();
            if( database.tables.audits.items.length >= auditMaxCount+1){
              database.tables.audits.items.splice(0, (database.tables.audits.items.length - auditMaxCount+1 ))
            }
            database.tables.audits.insert(
                { tenantName: tenantName, tenantMnemonic: tenantMnemonic, environment: environment, productName: productName, user: userId, executionDtTime: current.toLocaleString(), action:action, result:result,jiraNumber:jiraNumber  }
            );
            database.tables.audits.save();
        } catch (err) {
            log.warn(err);
        }
      },
      getTerraformCommand: function returnTerrFormCommand(request,properties){
        try {
          var tenantMnemonic = request.query.tenantMnemonic;
          var environment = request.query.environment;
          var productId = request.query.productId;
          var folderpath = helper.getTerraformConfigFolderLocation(productId,tenantMnemonic,environment.toLowerCase(),properties);
          var command = "cd " + folderpath + " && " + "TF_VAR_system_account_key=" + request.query.systemId + " TF_VAR_system_account_secret=" + request.query.systemPassword + " terraform " + request.query.action + " -no-color" + (request.query.action === "apply"?" -auto-approve":"") + (request.query.action === "init"? "":" -parallelism=10") ;
          return command;
        }
        catch (err) { console.error( err ) }
      },
      getTerraformGraphCommand: function returnTerrFormGraphCommand(request,properties,filename){
        try {
          var tenantMnemonic = request.query.tenantMnemonic;
          var environment = request.query.environment;
          var productId = request.query.productId;
          var folderpath = helper.getTerraformConfigFolderLocation(productId,tenantMnemonic,environment.toLowerCase(),properties);
          var command = "cd " + folderpath + " && " + "TF_VAR_system_account_key=" + request.query.systemId + " TF_VAR_system_account_secret=" + request.query.systemPassword + " terraform graph -type=" + request.query.action + " | dot -Tsvg > " + filename;
          return command;
        }
        catch (err) { console.error( err ) }
      },
      updateuserjiradetails: function updatejiradetails(request){
        try {
            var jiraNumber =request.query.jiraNumber
            var jiraDescription =request.query.jiraDescription
            var userId = request.query.userId
    
            if( jiraNumber !== ""){
                var current = new Date();
                var whereClause = "@userId == '" + userId + "' " ;
                var associate = JSON.parse(JSON.stringify( database.tables.userJiras.where(whereClause)));
                var isJiraExist = false;
                if (Object.keys(associate.items).length <= 0){
                    database.tables.userJiras.insert(
                    {userId: userId , jiraDetails: [{jiraNumber: jiraNumber , jiraDescription:jiraDescription , jiraSubmittedDtTm: current.toLocaleString()}]}
                    );
                    database.tables.userJiras.save();
        
                }else{
                    // update the jira details
                    var jiraDetails = associate.items[0].jiraDetails;
                    for(let i = 0; i < jiraDetails.length; i++){
                        if (jiraDetails[i].jiraNumber === jiraNumber){
                            isJiraExist = true;
                            jiraDetails[i].jiraDescription = jiraDescription;
                            jiraDetails[i].jiraSubmittedDtTm = current.toLocaleString();
                        }
                    }
                    if(isJiraExist === false){
                        jiraDetails.push({jiraNumber: jiraNumber , jiraDescription:jiraDescription , jiraSubmittedDtTm: current.toLocaleString()});
                    }
                    database.tables.userJiras.update(parseInt(associate.items[0].cid), {userId: userId, jiraDetails: jiraDetails});
                }
            }
        } catch (error) {
            
        }
      },
      getmultilenghtarraycount: function getmultilengtharraysize(items){

        var total = 0;
        for (var count = 0; count < items.length; count++) {
            total = total + items[count].jiraDetails.length;
        }
        return total;

    },
    sendErrorNotification: function doSendErrorNotificaiton(req,error){
        current = new Date();
        var mailOptions = {
          from: 'startservice191@gmail.com',
          to: 'vinayak.kulkarni@cerner.com',
          subject: '[S.T.A.R.T Alert - Exception Occurred @ ' + current.toLocaleString() +']',
          html: '<hr> <b> REQUESTED URL: </b> <br>' + req.originalUrl +
                '<hr> <b> ERROR: </b> <br>' + error +
                '<hr> <b> STACK TRACE: </b> <br>' + error.stack +
                '<hr> <b> REQUESTD BODY: </b> <br>' + JSON.stringify(error, null, 1)
        };
  
        transporter.sendMail(mailOptions, function(error, info){
          if (error) {
            log.warn(error);
          } else {
            log.warn('Email sent: ' + info.response);
          }
        });
    },
    createUserSearchQuery: function doCreateUserSearchQuery(req,properties){
      try{
        var associateId = req.query.associateId
        var searchQuery = req.query.searchQuery;

        var whereClause = "@userId == '" + associateId + "' " ;
        var associate = JSON.parse(JSON.stringify( database.tables.userQueries.where(whereClause)));

        var queryString = JSON.stringify(searchQuery);
        let doInsert=true;
        
        const queryHash = hash(queryString);
        const querySize = Object.keys(associate.items).length;
        
        for (let index = 0; index < querySize; index++) {
          const query = associate.items[index];
          if(query.queryHash === queryHash){
            doInsert = false;
            break;
          }
        }
        if (!doInsert)
          return;
        let maxSizeLimit = parseInt(properties.get("hi.provider.search.query.size.limit"));
        if(querySize >= maxSizeLimit){
          for (let index = maxSizeLimit; index < querySize; index++) {
            //const cid = associate.items[index];
            
          }
        }

        // if (Object.keys(associate.items).length <= 0){
            database.tables.userQueries.insert(
                {userId: associateId,
                query: searchQuery,
                queryHash: queryHash
              }
            );
            database.tables.userQueries.save();
        // }
      }catch(err){
          log.warn(err);
      }
    },
    getUserSearchQueryById: function doGetUserSearchQueryById(id){
      return database.tables.userQueries.get(parseInt(id));
    }

}

 const hash = function(str, seed = 0) {
  let h1 = 0xdeadbeef ^ seed, h2 = 0x41c6ce57 ^ seed;
  for (let i = 0, ch; i < str.length; i++) {
      ch = str.charCodeAt(i);
      h1 = Math.imul(h1 ^ ch, 2654435761);
      h2 = Math.imul(h2 ^ ch, 1597334677);
  }
  h1 = Math.imul(h1 ^ (h1>>>16), 2246822507) ^ Math.imul(h2 ^ (h2>>>13), 3266489909);
  h2 = Math.imul(h2 ^ (h2>>>16), 2246822507) ^ Math.imul(h1 ^ (h1>>>13), 3266489909);
  return 4294967296 * (2097151 & h2) + (h1>>>0);
};

exports.help= helper;