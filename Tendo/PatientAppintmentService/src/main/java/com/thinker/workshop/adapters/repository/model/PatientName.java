package com.thinker.workshop.adapters.repository.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "patient_name")
public class PatientName {

  @DatabaseField(generatedId = true)
  private int id;
  @DatabaseField
  private String text;
  @DatabaseField
  private String familyName;
  @DatabaseField
  private String givenName;

  @DatabaseField (foreign = true, foreignAutoRefresh = true)
  private Patient patient;

  public PatientName() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getFamilyName() {
    return familyName;
  }

  public void setFamilyName(String familyName) {
    this.familyName = familyName;
  }

  public String getGivenName() {
    return givenName;
  }

  public void setGivenName(String givenName) {
    this.givenName = givenName;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }
}
