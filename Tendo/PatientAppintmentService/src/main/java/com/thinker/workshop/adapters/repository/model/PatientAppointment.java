package com.thinker.workshop.adapters.repository.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;
import javax.swing.text.TabableView;

@DatabaseTable(tableName = "patient_appointment")
public class PatientAppointment {
  @DatabaseField(generatedId = true)
  private int id;
  @DatabaseField
  private String status;
  @DatabaseField
  private String type;
  @DatabaseField
  private String startAt;
  @DatabaseField
  private String endAt;
  @DatabaseField
  private String createdAt;
  @DatabaseField
  private String updatedAt;
  @DatabaseField(canBeNull = false, foreign = true)
  private Patient patient;
  @DatabaseField(canBeNull = false, foreign = true)
  private Provider provider;

  @ForeignCollectionField(eager = false)
  private ForeignCollection<PatientAppointmentFeedback> patientAppointmentFeedbacks;

  public PatientAppointment() {
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

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getStartAt() {
    return startAt;
  }

  public void setStartAt(String startAt) {
    this.startAt = startAt;
  }

  public String getEndAt() {
    return endAt;
  }

  public void setEndAt(String endAt) {
    this.endAt = endAt;
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

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public Provider getProvider() {
    return provider;
  }

  public void setProvider(Provider provider) {
    this.provider = provider;
  }
}

