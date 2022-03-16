package com.thinker.workshop.adapters.controller.model;

public class HealthCheck {

  private String serviceUpAndRunning;
  private String databaseUpAndRunning;

  public HealthCheck() {
  }

  public HealthCheck(String serviceUpAndRunning, String databaseUpAndRunning) {
    this.serviceUpAndRunning = serviceUpAndRunning;
    this.databaseUpAndRunning = databaseUpAndRunning;
  }

  public String getServiceUpAndRunning() {
    return serviceUpAndRunning;
  }

  public void setServiceUpAndRunning(String serviceUpAndRunning) {
    this.serviceUpAndRunning = serviceUpAndRunning;
  }

  public String getDatabaseUpAndRunning() {
    return databaseUpAndRunning;
  }

  public void setDatabaseUpAndRunning(String databaseUpAndRunning) {
    this.databaseUpAndRunning = databaseUpAndRunning;
  }
}
