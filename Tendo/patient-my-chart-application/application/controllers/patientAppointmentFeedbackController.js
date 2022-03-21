const controller = require('./appController.js');
var https = require('https');
var http = require('http');
const { getOauthToken } = require('../../utils/oauth.js');
const { response } = require('express');
const log  = controller.caboodle.log;
const database = controller.caboodle.database;
const helper = controller.caboodle.helper;
const oauther = controller.caboodle.oauth;
const fs = controller.caboodle.filesystem;


exports.createPatientApptFeedback =  async (req,res) => {
    var patientAppointmentId = req.query.patientAppointmentId.trim();
    var questionnairId = req.query.questionnairId.trim();
    var value = req.query.value.trim();
    value = value.replace(/\ /g, '~');
    let path = "/mychart/patientAppointmentFeedback?patientAppointmentId="+patientAppointmentId +"&questionnairId="+ questionnairId + "&value="+ value;
    await apiResponseFor(req,res,path, "POST");
    var jsonText =  "{ \"status\" : \"SUCCESS\" , \"message\" : \"The feedback has been successfully added !!!\" }";
    return res.writeHead(200).end(jsonText);
    
}
exports.updatePatientApptFeedback =  async (req,res) => {
    var patientAppointmentId = req.query.patientAppointmentId.trim();
    var questionnairId = req.query.questionnairId.trim();
    var value = req.query.value.trim();
    var questionnairId = req.query.id.trim();
    let path = "/mychart/patientAppointmentFeedback?patientAppointmentId="+patientAppointmentId +"&questionnairId="+ questionnairId + "&value="+ value + "&questionnairId=" + questionnairId;
    await apiResponseFor(req,res,path, "PUT");
    var jsonText =  "{ \"status\" : \"SUCCESS\" , \"message\" : \"The feedback has been successfully updated !!!\" }";
    return res.writeHead(200).end(jsonText);
    
}



async function apiResponseFor(req,res,path,method){
    try{
        let finalResponse =[];
        let options = await getRequestOptions(path,method);
        let response = await makeSynchronousRequest(options);
        return response;
        
    }catch(err){
        log.warn(err);
        console.log(err.message);
      }
}

async function  getRequestOptions(path,method) {
    return  {
        hostname : "localhost",
        port: 8089,
        method: method,
        path:path
    }
}

function getPromise(options) {
	return new Promise((resolve, reject) => {
		http.get(options, (response) => {
			let chunks_of_data = [];

			response.on('data', (fragments) => {
				chunks_of_data.push(fragments);
			});

			response.on('end', () => {
				let response_body = Buffer.concat(chunks_of_data);
				resolve(response_body.toString());
			});

			response.on('error', (error) => {
				reject(error);
			});
		});
	});
}

async function makeSynchronousRequest(request) {
	try {
		let http_promise = getPromise(request);
		let response_body = await http_promise;

		// holds response from server that is passed when Promise is resolved
        // console.log(response_body);
        return response_body;
	}
	catch(error) {
		// Promise rejected
		console.log(error);
	}
}