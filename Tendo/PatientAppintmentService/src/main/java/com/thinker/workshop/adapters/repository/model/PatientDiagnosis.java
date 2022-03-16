package com.thinker.workshop.adapters.repository.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

@DatabaseTable(tableName = "patient_diagnosis")
public class PatientDiagnosis {

  @DatabaseField(generatedId = true)
  private int id;
  @DatabaseField
  private String status;
  @DatabaseField
  private String lastUpdatedAt;
  @DatabaseField
  private String createdAt;
  @DatabaseField
  private String updatedAt;
  @DatabaseField(canBeNull = false, foreign = true)
  private PatientAppointment patientAppointment;
  @ForeignCollectionField(eager = false)
  private ForeignCollection<PatientDiagnosisCoding> patientDiagnosisCodings;

  public PatientDiagnosis() {

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
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

  public PatientAppointment getPatientAppointment() {
    return patientAppointment;
  }

  public void setPatientAppointment(
      PatientAppointment patientAppointment) {
    this.patientAppointment = patientAppointment;
  }

  public ForeignCollection<PatientDiagnosisCoding> getPatientDiagnosisCodings() {
    return patientDiagnosisCodings;
  }

  public void setPatientDiagnosisCodings(
      ForeignCollection<PatientDiagnosisCoding> patientDiagnosisCodings) {
    this.patientDiagnosisCodings = patientDiagnosisCodings;
  }
}
