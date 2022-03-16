package com.thinker.workshop.entity.questionnaire;

import com.thinker.workshop.entity.Patient;

public class PatientFeedbackQuestionnaireTemplate {
  private String id;
  private String name;
  private String title;
  private String createdAt;
  private String updatedAt;

  public PatientFeedbackQuestionnaireTemplate(String id, String name, String title,
      String createdAt, String updatedAt) {
    this.id = id;
    this.name = name;
    this.title = title;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }
  public static PatientFeedbackQuestionnaireTemplate.PatientFeedbackQuestionnaireTemplateBuilder builder() {
    return new PatientFeedbackQuestionnaireTemplate.PatientFeedbackQuestionnaireTemplateBuilder();
  }

  public static class PatientFeedbackQuestionnaireTemplateBuilder {
    private String id;
    private String name;
    private String title;
    private String createdAt;
    private String updatedAt;

    PatientFeedbackQuestionnaireTemplateBuilder() {
    }

    public PatientFeedbackQuestionnaireTemplate.PatientFeedbackQuestionnaireTemplateBuilder id(final String id) {
      this.id = id;
      return this;
    }

    public PatientFeedbackQuestionnaireTemplate.PatientFeedbackQuestionnaireTemplateBuilder name(final String name) {
      this.name = name;
      return this;
    }

    public PatientFeedbackQuestionnaireTemplate.PatientFeedbackQuestionnaireTemplateBuilder title(final String title) {
      this.title = title;
      return this;
    }


    public PatientFeedbackQuestionnaireTemplate.PatientFeedbackQuestionnaireTemplateBuilder createdAt(final String createdAt) {
      this.createdAt = createdAt;
      return this;
    }
    public PatientFeedbackQuestionnaireTemplate.PatientFeedbackQuestionnaireTemplateBuilder updatedAt(final String updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    public PatientFeedbackQuestionnaireTemplate build() {
      return new PatientFeedbackQuestionnaireTemplate(id, name, title, createdAt,updatedAt);
    }
  }
}
