const controller = require('./appController.js');
const apptController = require('./patientAppointmentController.js');
const log  = controller.caboodle.log;
const database = controller.caboodle.database;
const helper = controller.caboodle.helper;


exports.home = (req,res) => {
    try{

            var response = apptController.getPatientAppointmentSummary(req,res);
            res.render("response", { response: response});
        
      }catch(err){
        log.warn(err);
      }
}