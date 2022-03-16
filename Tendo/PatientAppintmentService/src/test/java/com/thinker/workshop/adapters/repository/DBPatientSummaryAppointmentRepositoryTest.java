package com.thinker.workshop.adapters.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.j256.ormlite.dao.Dao;
import com.thinker.workshop.adapters.controller.ServiceController;
import com.thinker.workshop.adapters.repository.dao.PatientDao;
import com.thinker.workshop.adapters.repository.model.Patient;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

class DBPatientSummaryAppointmentRepositoryTest {

  private static final String PTAPPTSUMMARY_RESOURCE = "http://127.0.0.1:8088/mychart/patientAppointmentSummary/1";

  void setup() throws SQLException {
    PatientDao pDao = new PatientDao();
    Dao<Patient, String> patientDao = pDao.getPatientDao();

    String query = "INSERT INTO `internal`.`patient`\n"
        + "(`id`,\n"
        + "`gender`,\n"
        + "`birthdate`,\n"
        + "`active`,\n"
        + "`createdAt`,\n"
        + "`updatedAt`)\n"
        + "VALUES(\n"
        + "2,\n"
        + "'female',\n"
        + "'1965-01-06',\n"
        + "'false',\n"
        + "'2022-03-12 19:00:08',\n"
        + "'2022-03-12 19:00:08')";

    patientDao.updateRaw(query);



  }
  @Test
  void findById() throws SQLException, IOException {
    String args[] = null;
    ServiceController.main(args);
    //setup();
    CloseableHttpClient httpClient = HttpClients.createDefault();
    try {
      HttpGet request = new HttpGet(PTAPPTSUMMARY_RESOURCE);
      CloseableHttpResponse response = httpClient.execute(request);
      try {
        // Get HttpResponse Status
        System.out.println(response.getProtocolVersion());              // HTTP/1.1
        HttpEntity entity = response.getEntity();
        if (entity != null) {
          // return it as a String
          String result = EntityUtils.toString(entity);
          System.out.println(result);
          // Assert should go here!!!
        }
      } finally {
        response.close();
      }
    } finally {
      httpClient.close();
    }
    teardown();
  }

  private void teardown() {
    // All teardown data should go here!!!
  }
}