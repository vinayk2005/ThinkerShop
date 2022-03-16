package com.thinker.workshop.adapters.repository.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "patient_contact")
public class PatientContact {

  @DatabaseField(generatedId = true)
  private int id;
  @DatabaseField
  private String system;
  @DatabaseField
  private String value;
  @DatabaseField
  private String use;

  @DatabaseField (foreign = true, foreignAutoRefresh = true)
  private Patient patient;


  public PatientContact() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getSystem() {
    return system;
  }

  public void setSystem(String system) {
    this.system = system;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getUse() {
    return use;
  }

  public void setUse(String use) {
    this.use = use;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }
}
