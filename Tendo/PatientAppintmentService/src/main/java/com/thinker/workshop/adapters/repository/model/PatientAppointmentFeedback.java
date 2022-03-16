package com.thinker.workshop.adapters.repository.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "patient_appointment_feedback")
public class PatientAppointmentFeedback {

  @DatabaseField(generatedId = true)
  private int id;
  @DatabaseField
  private String value;
  @DatabaseField
  private String questionnaireId;
  @DatabaseField (foreign = true, foreignAutoRefresh = true)
  private PatientAppointment patientAppointment;
  @DatabaseField
  private String createdAt;
  @DatabaseField
  private String updatedAt;

  public PatientAppointmentFeedback() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getQuestionnaireId() {
    return questionnaireId;
  }

  public void setQuestionnaireId(String questionnaireId) {
    this.questionnaireId = questionnaireId;
  }

  public PatientAppointment getPatientAppointment() {
    return patientAppointment;
  }

  public void setPatientAppointment(
      PatientAppointment patientAppointment) {
    this.patientAppointment = patientAppointment;
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
}
