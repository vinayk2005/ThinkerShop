const express = require('express')
const router = express.Router()
const homeController = require('./../controllers/homeController.js');
const logController = require('./../controllers/logsController.js');
const patientApptController = require('./../controllers/patientAppointmentController.js');
const patientApptFeedbackController = require('./../controllers/patientAppointmentFeedbackController.js');

router.get('/patient-page',patientApptController.getPatientAppointmentSummary);
router.post('/patient-appt-feedback',patientApptFeedbackController.createPatientApptFeedback);
router.put('/patient-appt-feedback',patientApptFeedbackController.updatePatientApptFeedback);
router.get('/patientAppointmentSummary/',patientApptController.getPatientAppointmentSummary);

module.exports = router;