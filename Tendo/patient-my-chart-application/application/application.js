const express = require('express');
const bodyParser = require('body-parser')
const app = express();
const routes = require('./routes/routes');
const controller = require('./controllers/appController');
const log = controller.caboodle.log;
const mailer = controller.caboodle.mailer;
const path = require('path');
const hbs = require("express-handlebars");
const hbshelpers = require('handlebars-helpers');
const multihelpers = hbshelpers();

app.use(bodyParser.json({limit: '50mb', extended: true}))
app.use(bodyParser.urlencoded({limit: '50mb', extended: true}))
app.use(express.static(__dirname + './../public'));
app.use(express.static(__dirname + './../public/javascripts'));
app.use("/",routes);
app.set('views',path.join(__dirname, './../views'));
app.use('/logs', express.static(__dirname + './../logs'));

// For handling errors for email notifications
app.use(function (error, req, res, next) {
    if(error){ //Handle SyntaxError here. if(error instanceof SyntaxError)
        log.warn( 'request: ', req , ' response: ' , res , ' error: ', error);
        mailer.sendErrorNotification(req, error);
        var jsonText = "{ \"status\" : \"ERROR\" , \"message\" : \""+ error +"\"}";
        return res.writeHead(400).end(jsonText);
    } else {
        next();
    }
    });

// For registering handlebar
app.engine(
    "hbs",
    hbs({
      helpers: multihelpers,
      partialsDir: ["views/partials"],
      extname: ".hbs",
      layoutsDir: "views",
      defaultLayout: "index"
    })
);
app.set('view engine','hbs');

// Handlebars.registerHelper('json',function(obj) {
//     return new Handlebars.SafeString(JSON.stringify(obj))
//  })

exports.app = app;





