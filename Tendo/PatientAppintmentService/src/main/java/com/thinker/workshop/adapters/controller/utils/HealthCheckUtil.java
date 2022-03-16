package com.thinker.workshop.adapters.controller.utils;

import com.thinker.workshop.adapters.controller.model.HealthCheck;
import com.thinker.workshop.adapters.repository.database.ServiceTable;
import java.sql.SQLException;
import spark.Request;

public class HealthCheckUtil {

  public static HealthCheck doHealthCheck(Request req){
    HealthCheck healthCheck = new HealthCheck();
    try {
      ServiceTable.createUserTableIfNotExist();
      healthCheck.setDatabaseUpAndRunning("Running!!");
    } catch (SQLException e) {
      healthCheck.setDatabaseUpAndRunning("Not Running!!");
    }

    if(req.requestMethod() == "GET" ){
      healthCheck.setServiceUpAndRunning("Running!!");
    }else{
      healthCheck.setServiceUpAndRunning("Not Running!!");
    }

    return healthCheck;

  }


}
