package com.thinker.workshop.entity.questionnaire;

import com.thinker.workshop.entity.Patient;

public class PatientFeedbackQuestionnaire {
  private String id;
  private String dataType;
  private int rangeMin;
  private int rangeMax;
  private String displayText;
  private String createdAt;
  private String updatedAt;

  public PatientFeedbackQuestionnaire(String id, String dataType, int rangeMin, int rangeMax,
      String displayText, String createdAt, String updatedAt) {
    this.id = id;
    this.dataType = dataType;
    this.rangeMin = rangeMin;
    this.rangeMax = rangeMax;
    this.displayText = displayText;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public static PatientFeedbackQuestionnaire.PatientFeedbackQuestionnaireBuilder builder() {
    return new PatientFeedbackQuestionnaire.PatientFeedbackQuestionnaireBuilder();
  }

  public static class PatientFeedbackQuestionnaireBuilder {
    private String id;
    private String datatype;
    private int rangeMin;
    private int rangeMax;
    private String displayText;
    private String createdAt;
    private String updatedAt;

    PatientFeedbackQuestionnaireBuilder() {
    }

    public PatientFeedbackQuestionnaire.PatientFeedbackQuestionnaireBuilder id(final String id) {
      this.id = id;
      return this;
    }

    public PatientFeedbackQuestionnaire.PatientFeedbackQuestionnaireBuilder datatype(final String datatype) {
      this.datatype = datatype;
      return this;
    }

    public PatientFeedbackQuestionnaire.PatientFeedbackQuestionnaireBuilder rangeMin(final int rangeMin) {
      this.rangeMin = rangeMin;
      return this;
    }

    public PatientFeedbackQuestionnaire.PatientFeedbackQuestionnaireBuilder rangeMax(final int rangeMax) {
      this.rangeMax = rangeMax;
      return this;
    }

    public PatientFeedbackQuestionnaire.PatientFeedbackQuestionnaireBuilder rangeMax(final String displayText) {
      this.displayText = displayText;
      return this;
    }

    public PatientFeedbackQuestionnaire.PatientFeedbackQuestionnaireBuilder createdAt(final String createdAt) {
      this.createdAt = createdAt;
      return this;
    }
    public PatientFeedbackQuestionnaire.PatientFeedbackQuestionnaireBuilder updatedAt(final String updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    public PatientFeedbackQuestionnaire build() {
      return new PatientFeedbackQuestionnaire(id, datatype, rangeMin, rangeMax, displayText, createdAt,updatedAt);
    }
  }
}
