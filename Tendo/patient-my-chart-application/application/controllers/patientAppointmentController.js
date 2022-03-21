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

exports.getPatientAppointmentSummary =  async (req,res) => {
    var patientId = req.query.patientId.trim();
    let path = "/mychart/patientAppointmentSummary/"+patientId;
    var apptServiceResponse = await apiResponseFor(req,res,path)
    var resp = JSON.parse(apptServiceResponse);
    log.info("patientAppointmentSummary JSON :: " + JSON.stringify(resp, null, 3));
    var apptId= resp.patientAppointment.id;
    
     path = "/mychart/patientAppointmentFeedback/"+apptId;
    var apptFeedbackServiceResponse = await apiResponseFor(req,res,path)
    log.info("patientAppointmentSummary JSON :: " + JSON.stringify(resp, null, 3));
    res.render("index", { response: JSON.parse(apptServiceResponse), feedbacks : JSON.parse(apptFeedbackServiceResponse) });
}

async function apiResponseFor(req,res,path,doAgreggation){
    try{
        let finalResponse =[];
        let options = await getRequestOptions(path);
        let response = await makeSynchronousRequest(options);
         response = JSON.parse(response);
         return (JSON.stringify(response, null, 3));
    
    }catch(err){
        log.warn(err);
        console.log(err.message);
      }
}

async function  getRequestOptions(path) {
    
    return  {
        hostname : "localhost",
        port: 8089,
        method: "GET",
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