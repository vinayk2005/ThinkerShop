package com.thinker.workshop.entity;

public class PatientAppointmentFeedback {
  private String id;
  private String value;
  private String questionnaireId;
  private String patientAppointmentId;
  private String createdAt;
  private String updatedAt;

  public PatientAppointmentFeedback(String id, String value, String questionnaireId,
      String patientAppointmentId, String createdAt, String updatedAt) {
    this.id = id;
    this.value = value;
    this.questionnaireId = questionnaireId;
    this.patientAppointmentId = patientAppointmentId;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public String getId() {
    return id;
  }

  public String getValue() {
    return value;
  }

  public String getQuestionnaireId() {
    return questionnaireId;
  }

  public String getPatientAppointmentId() {
    return patientAppointmentId;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public static PatientAppointmentFeedback.PatientAppointmentFeedbackBuilder builder() {
    return new PatientAppointmentFeedback.PatientAppointmentFeedbackBuilder();
  }

  public static class PatientAppointmentFeedbackBuilder {
    private String id;
    private String value;
    private String questionnaireId;
    private String patientAppointmentId;
    private String createdAt;
    private String updatedAt;

    PatientAppointmentFeedbackBuilder() {
    }

    public PatientAppointmentFeedback.PatientAppointmentFeedbackBuilder id(final String id) {
      this.id = id;
      return this;
    }

    public PatientAppointmentFeedback.PatientAppointmentFeedbackBuilder value(final String value) {
      this.value = value;
      return this;
    }

    public PatientAppointmentFeedback.PatientAppointmentFeedbackBuilder questionnaireId(final String questionnaireId) {
      this.questionnaireId = questionnaireId;
      return this;
    }

    public PatientAppointmentFeedback.PatientAppointmentFeedbackBuilder patientAppointmentId(final String patientAppointmentId) {
      this.patientAppointmentId = patientAppointmentId;
      return this;
    }

    public PatientAppointmentFeedback.PatientAppointmentFeedbackBuilder createdAt(final String createdAt) {
      this.createdAt = createdAt;
      return this;
    }
    public PatientAppointmentFeedback.PatientAppointmentFeedbackBuilder updatedAt(final String updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    public PatientAppointmentFeedback build() {
      return new PatientAppointmentFeedback(id, value, questionnaireId, patientAppointmentId, createdAt,updatedAt);
    }
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public void setQuestionnaireId(String questionnaireId) {
    this.questionnaireId = questionnaireId;
  }

  public void setPatientAppointmentId(String patientAppointmentId) {
    this.patientAppointmentId = patientAppointmentId;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }
}
