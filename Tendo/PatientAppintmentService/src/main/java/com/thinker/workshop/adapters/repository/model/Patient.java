package com.thinker.workshop.adapters.repository.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.List;

@DatabaseTable(tableName = "patient")
public class Patient {

  @DatabaseField(generatedId = true)
  private int id;
  @DatabaseField
  private String gender;
  @DatabaseField
  private String birthdate;
  @DatabaseField
  private String active;
  @ForeignCollectionField(eager = false)
  private ForeignCollection<PatientAddress> patientAddresses;
  @ForeignCollectionField(eager = false)
  private ForeignCollection<PatientContact> patientContacts;
  @ForeignCollectionField(eager = false)
  private ForeignCollection<PatientName> patientNames;
  @DatabaseField
  private String createdAt;
  @DatabaseField
  private String updatedAt;

  public Patient(){
    // ORMLite needs a no-arg constructor
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(String birthdate) {
    this.birthdate = birthdate;
  }

  public String getActive() {
    return active;
  }

  public void setActive(String active) {
    this.active = active;
  }

  public ForeignCollection<PatientAddress> getPatientAddresses() {
    return patientAddresses;
  }

  public void setPatientAddresses(
      ForeignCollection<PatientAddress> patientAddresses) {
    this.patientAddresses = patientAddresses;
  }

  public ForeignCollection<PatientContact> getPatientContacts() {
    return patientContacts;
  }

  public void setPatientContacts(
      ForeignCollection<PatientContact> patientContacts) {
    this.patientContacts = patientContacts;
  }

  public ForeignCollection<PatientName> getPatientNames() {
    return patientNames;
  }

  public void setPatientNames(ForeignCollection<PatientName> patientNames) {
    this.patientNames = patientNames;
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
