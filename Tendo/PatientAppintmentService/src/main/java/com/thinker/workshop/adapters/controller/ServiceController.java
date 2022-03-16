package com.thinker.workshop.adapters.controller;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.put;
import static spark.route.HttpMethod.put;

import com.thinker.workshop.adapters.controller.model.HealthCheck;
import com.thinker.workshop.adapters.controller.utils.HealthCheckUtil;
import com.thinker.workshop.adapters.controller.utils.JsonUtil;
import com.thinker.workshop.adapters.repository.DBPatientFeedbakRepository;
import com.thinker.workshop.adapters.repository.DBPatientSummaryAppointmentRepository;
import com.thinker.workshop.adapters.repository.database.ServiceTable;
import com.thinker.workshop.entity.PatientAppointmentFeedback;
import java.sql.SQLException;

public class ServiceController {

  public static void  main(String [] args){
    port(8088);
    try {
      ServiceTable.createUserTableIfNotExist();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    get(
        "/mychart/healthDiagnosis",
        (req, res) -> {
          return JsonUtil.convertToJson(HealthCheckUtil.doHealthCheck(req));
        });


    get(
        "mychart/patientAppointmentSummary/:id",
        (req, res) -> {
          System.out.println(req.params(":id"));
          DBPatientSummaryAppointmentRepository repository = new DBPatientSummaryAppointmentRepository();

          return JsonUtil.convertToJson(repository.findById(req.params(":id")));
        });

    get(
        "mychart/patientAppointmentFeedback/:id",
        (req, res) -> {
          System.out.println(req.params(":id"));
          DBPatientFeedbakRepository repository = new DBPatientFeedbakRepository();

          return JsonUtil.convertArrayToJson(repository.getListByAppointmentId(req.params(":id")));
        });

    post(
        "mychart/patientAppointmentFeedback",
        (req, res) -> {

          String apptId = req.queryParams("patientAppointmentId");
          String questionnaireId = req.queryParams("questionnairId");
          String value = req.queryParams("value");
          value = value.replace("~" , " ");

          PatientAppointmentFeedback feedback = new PatientAppointmentFeedback (null,value,questionnaireId,apptId,null,null);

          DBPatientFeedbakRepository repository = new DBPatientFeedbakRepository();

          repository.createFeedbackForAppointment(feedback);
          res.status(201); // 201 Created
          return res;
        });

    put(
        "mychart/patientAppointmentFeedback",
        (req, res) -> {

          String feedbackId = req.queryParams("patientAppointmentFeedbackId");
          String apptId = req.queryParams("patientAppointmentId");
          String questionnaireId = req.queryParams("questionnairId");
          String value = req.queryParams("value");

          PatientAppointmentFeedback feedback = new PatientAppointmentFeedback (feedbackId,value,questionnaireId,apptId,null,null);

          DBPatientFeedbakRepository repository = new DBPatientFeedbakRepository();

          repository.modifyFeedbackForAppointment(feedback);
          res.status(200); // 201 Created
          return res;
        });

    System.out.println("Service 'PatientAppointmentService' is started and listening on port 8088");
  }
}
