package com.thinker.workshop.entity;

import java.util.List;

public class PatientDiagnosis {
  private String id;
  private String status;
  private String lastUpdatedAt;
  private String createdAt;
  private String updatedAt;
  private String patientAppointmentId;
  private List<PatientDiagnosisCoding> patientDiagnosisCodings;

  public PatientDiagnosis(String id, String status, String lastUpdatedAt, String createdAt,
      String updatedAt, String patientAppointmentId,
      List<PatientDiagnosisCoding> patientDiagnosisCodings) {
    this.id = id;
    this.status = status;
    this.lastUpdatedAt = lastUpdatedAt;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.patientAppointmentId = patientAppointmentId;
    this.patientDiagnosisCodings = patientDiagnosisCodings;
  }

  public static PatientDiagnosis.PatientDiagnosisBuilder builder() {
    return new PatientDiagnosis.PatientDiagnosisBuilder();
  }

  public static class PatientDiagnosisBuilder {
    private String id;
    private String status;
    private String lastUpdatedAt;
    private String createdAt;
    private String updatedAt;
    private String patientAppointmentId;
    private List<PatientDiagnosisCoding> patientDiagnosisCodings;

    PatientDiagnosisBuilder() {
    }

    public PatientDiagnosis.PatientDiagnosisBuilder id(final String id) {
      this.id = id;
      return this;
    }

    public PatientDiagnosis.PatientDiagnosisBuilder status(final String status) {
      this.status = status;
      return this;
    }

    public PatientDiagnosis.PatientDiagnosisBuilder lastUpdatedAt(final String lastUpdatedAt) {
      this.lastUpdatedAt = lastUpdatedAt;
      return this;
    }



    public PatientDiagnosis.PatientDiagnosisBuilder createdAt(final String createdAt) {
      this.createdAt = createdAt;
      return this;
    }
    public PatientDiagnosis.PatientDiagnosisBuilder updatedAt(final String updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }
    public PatientDiagnosis.PatientDiagnosisBuilder patientAppointmentId(final String patientAppointmentId) {
      this.patientAppointmentId = patientAppointmentId;
      return this;
    }

    public PatientDiagnosis.PatientDiagnosisBuilder patientDiagnosisCodings(final List<PatientDiagnosisCoding> patientDiagnosisCodings) {
      this.patientDiagnosisCodings = patientDiagnosisCodings;
      return this;
    }


    public PatientDiagnosis build() {
      return new PatientDiagnosis(id, status, lastUpdatedAt,createdAt,updatedAt,patientAppointmentId,patientDiagnosisCodings);
    }
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getLastUpdatedAt() {
    return lastUpdatedAt;
  }

  public void setLastUpdatedAt(String lastUpdatedAt) {
    this.lastUpdatedAt = lastUpdatedAt;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getPatientAppointmentId() {
    return patientAppointmentId;
  }

  public void setPatientAppointmentId(String patientAppointmentId) {
    this.patientAppointmentId = patientAppointmentId;
  }

  public List<PatientDiagnosisCoding> getPatientDiagnosisCodings() {
    return patientDiagnosisCodings;
  }

  public void setPatientDiagnosisCodings(
      List<PatientDiagnosisCoding> patientDiagnosisCodings) {
    this.patientDiagnosisCodings = patientDiagnosisCodings;
  }
}
