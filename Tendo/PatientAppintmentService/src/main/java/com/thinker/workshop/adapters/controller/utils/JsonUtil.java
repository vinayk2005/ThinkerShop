package com.thinker.workshop.adapters.controller.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thinker.workshop.adapters.controller.model.HealthCheck;
import com.thinker.workshop.entity.PatientAppointmentFeedback;
import com.thinker.workshop.entity.PatientAppointmentSummary;
import java.io.IOException;
import java.util.List;

public class JsonUtil {

  public static String convertToJson(Object o){

    String jsonStr = "";
    ObjectMapper Obj = new ObjectMapper();
    PatientAppointmentSummary summary;
    HealthCheck check;
    if (o instanceof PatientAppointmentSummary){
      summary = (PatientAppointmentSummary)o;
      try {
        jsonStr = Obj.writeValueAsString(summary);
        System.out.println(jsonStr);
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }

    if (o instanceof HealthCheck){
      check = (HealthCheck)o;
      try {
        jsonStr = Obj.writeValueAsString(check);
        System.out.println(jsonStr);
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    }


    return jsonStr;

  }

  public static String convertArrayToJson(List<PatientAppointmentFeedback> list){

    String jsonStr = "";
    ObjectMapper Obj = new ObjectMapper();
    PatientAppointmentSummary summary;

      try {
        jsonStr = Obj.writeValueAsString(list);
        System.out.println(jsonStr);
      }
      catch (IOException e) {
        e.printStackTrace();
      }
    return jsonStr;

  }

}
