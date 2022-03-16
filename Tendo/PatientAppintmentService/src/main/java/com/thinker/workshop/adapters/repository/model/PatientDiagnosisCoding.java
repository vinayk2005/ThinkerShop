package com.thinker.workshop.adapters.repository.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "patient_diagnosis_coding")
public class PatientDiagnosisCoding {

  @DatabaseField(generatedId = true)
  private int id;
  @DatabaseField
  private String system;
  @DatabaseField
  private String value;
  @DatabaseField
  private String name;

  @DatabaseField (foreign = true, foreignAutoRefresh = true)
  private PatientDiagnosis patientDiagnosis;

  public PatientDiagnosisCoding() {
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PatientDiagnosis getPatientDiagnosis() {
    return patientDiagnosis;
  }

  public void setPatientDiagnosis(
      PatientDiagnosis patientDiagnosis) {
    this.patientDiagnosis = patientDiagnosis;
  }
}
