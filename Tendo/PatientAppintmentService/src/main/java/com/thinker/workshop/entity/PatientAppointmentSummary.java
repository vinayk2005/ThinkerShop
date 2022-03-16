package com.thinker.workshop.entity;

import java.util.List;

public class PatientAppointmentSummary {
  private Patient patient;
  private PatientAppointment patientAppointment;
  private PatientDiagnosis patientDiagnoses;
  private Provider provider;

  public PatientAppointmentSummary(Patient patient,
      PatientAppointment patientAppointment,
      PatientDiagnosis patientDiagnoses, Provider provider) {
    this.patient = patient;
    this.patientAppointment = patientAppointment;
    this.patientDiagnoses = patientDiagnoses;
    this.provider = provider;
  }

  public Provider getProvider() {
    return provider;
  }

  public void setProvider(Provider provider) {
    this.provider = provider;
  }

  public Patient getPatient() {
    return patient;
  }

  public void setPatient(Patient patient) {
    this.patient = patient;
  }

  public PatientAppointment getPatientAppointment() {
    return patientAppointment;
  }

  public void setPatientAppointment(PatientAppointment patientAppointment) {
    this.patientAppointment = patientAppointment;
  }

  public PatientDiagnosis getPatientDiagnoses() {
    return patientDiagnoses;
  }

  public void setPatientDiagnoses(
     PatientDiagnosis patientDiagnoses) {
    this.patientDiagnoses = patientDiagnoses;
  }
}
