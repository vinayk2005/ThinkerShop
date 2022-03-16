package com.thinker.workshop.entity;

public class PatientAppointment {
  
  private String id;
  private String status;
  private String type;
  private String startAt;
  private String endAt;
  private String createdAt;
  private String updatedAt;
  private String patientId;
  private String providerId;

  public PatientAppointment(String id, String status, String type, String startAt,
      String endAt, String createdAt, String updatedAt, String patientId, String providerId) {
    this.id = id;
    this.status = status;
    this.type = type;
    this.startAt = startAt;
    this.endAt = endAt;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.patientId = patientId;
    this.providerId = providerId;
  }

  public static PatientAppointment.PatientAppointmentBuilder builder() {
    return new PatientAppointment.PatientAppointmentBuilder();
  }

  public static class PatientAppointmentBuilder {
    private String id;
    private String status;
    private String type;
    private String startAt;
    private String endAt;
    private String createdAt;
    private String updatedAt;
    private String patientId;
    private String providerId;

    PatientAppointmentBuilder() {
    }

    public PatientAppointment.PatientAppointmentBuilder id(final String id) {
      this.id = id;
      return this;
    }

    public PatientAppointment.PatientAppointmentBuilder status(final String status) {
      this.status = status;
      return this;
    }

    public PatientAppointment.PatientAppointmentBuilder type(final String type) {
      this.type = type;
      return this;
    }

    public PatientAppointment.PatientAppointmentBuilder startAt(final String startAt) {
      this.startAt = startAt;
      return this;
    }
    public PatientAppointment.PatientAppointmentBuilder endAt(final String endAt) {
      this.endAt = endAt;
      return this;
    }

    public PatientAppointment.PatientAppointmentBuilder createdAt(final String createdAt) {
      this.createdAt = createdAt;
      return this;
    }
    public PatientAppointment.PatientAppointmentBuilder updatedAt(final String updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }
    public PatientAppointment.PatientAppointmentBuilder patientId(final String patientId) {
      this.patientId = patientId;
      return this;
    }
    public PatientAppointment.PatientAppointmentBuilder providerId(final String providerId) {
      this.providerId = providerId;
      return this;
    }

    public PatientAppointment build() {
      return new PatientAppointment(id, status, type, startAt,endAt, createdAt,updatedAt,patientId,providerId);
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

  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

  public String getProviderId() {
    return providerId;
  }

  public void setProviderId(String providerId) {
    this.providerId = providerId;
  }
}
