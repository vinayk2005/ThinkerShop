package com.thinker.workshop.entity;

import com.thinker.workshop.entity.Patient.PatientBuilder;
import java.util.List;

public class Patient {

  private String id;
  private String gender;
  private String birthdate;
  private String active;
  private List<PatientAddress> patientAddresses;
  private List<PatientContact> patientContacts;
  private List<PatientName> patientNames;
  private String createdAt;
  private String updatedAt;

  public Patient(String id, String gender, String birthdate, String active,
      List<PatientAddress> patientAddresses,
      List<PatientContact> patientContacts,
      List<PatientName> patientNames, String createdAt, String updatedAt) {
    this.id = id;
    this.gender = gender;
    this.birthdate = birthdate;
    this.active = active;
    this.patientAddresses = patientAddresses;
    this.patientContacts = patientContacts;
    this.patientNames = patientNames;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public static Patient.PatientBuilder builder() {
    return new Patient.PatientBuilder();
  }

  public static class PatientBuilder {
    private String id;
    private String gender;
    private String birthdate;
    private String active;
    private List<PatientAddress> patientAddresses;
    private List<PatientContact> patientContacts;
    private List<PatientName> patientNames;
    private String createdAt;
    private String updatedAt;

    PatientBuilder() {
    }

    public Patient.PatientBuilder id(final String id) {
      this.id = id;
      return this;
    }

    public Patient.PatientBuilder gender(final String gender) {
      this.gender = gender;
      return this;
    }

    public Patient.PatientBuilder birthdate(final String birthdate) {
      this.birthdate = birthdate;
      return this;
    }

    public Patient.PatientBuilder active(final String active) {
      this.active = active;
      return this;
    }

    public Patient.PatientBuilder patientAddresses(final List<PatientAddress> patientAddresses) {
      this.patientAddresses = patientAddresses;
      return this;
    }

    public Patient.PatientBuilder patientContacts(final List<PatientContact> patientContacts) {
      this.patientContacts = patientContacts;
      return this;
    }
    public Patient.PatientBuilder patientNames(final List<PatientName> patientNames) {
      this.patientNames = patientNames;
      return this;
    }

    public Patient.PatientBuilder createdAt(final String createdAt) {
      this.createdAt = createdAt;
      return this;
    }
    public Patient.PatientBuilder updatedAt(final String updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    public Patient build() {
      return new Patient(id, gender, birthdate, active, patientAddresses,patientContacts, patientNames,createdAt,updatedAt);
    }
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
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

  public List<PatientAddress> getPatientAddresses() {
    return patientAddresses;
  }

  public void setPatientAddresses(
      List<PatientAddress> patientAddresses) {
    this.patientAddresses = patientAddresses;
  }

  public List<PatientContact> getPatientContacts() {
    return patientContacts;
  }

  public void setPatientContacts(
      List<PatientContact> patientContacts) {
    this.patientContacts = patientContacts;
  }

  public List<PatientName> getPatientNames() {
    return patientNames;
  }

  public void setPatientNames(List<PatientName> patientNames) {
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

  @Override
  public String toString() {
    return "Patient{" +
        "id='" + id + '\'' +
        ", gender='" + gender + '\'' +
        ", birthdate='" + birthdate + '\'' +
        ", active='" + active + '\'' +
        ", addresses='" +  + '\'' +
        '}';
  }
}
