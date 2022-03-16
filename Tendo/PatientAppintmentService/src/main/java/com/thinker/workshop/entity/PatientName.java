package com.thinker.workshop.entity;

public class PatientName {
  
  private String id;
  private String text;
  private String familyName;
  private String givenName;

  public PatientName(String id, String text, String familyName, String givenName) {
    this.id = id;
    this.text = text;
    this.familyName = familyName;
    this.givenName = givenName;
  }
  public static PatientName.PatientNameBuilder builder() {
    return new PatientName.PatientNameBuilder();
  }

  public static class PatientNameBuilder {
    private String id;
    private String text;
    private String familyName;
    private String givenName;

    PatientNameBuilder() {
    }

    public PatientName.PatientNameBuilder id(final String id) {
      this.id = id;
      return this;
    }

    public PatientName.PatientNameBuilder text(final String text) {
      this.text = text;
      return this;
    }

    public PatientName.PatientNameBuilder familyName(final String familyName) {
      this.familyName = familyName;
      return this;
    }

    public PatientName.PatientNameBuilder givenName(final String givenName) {
      this.givenName = givenName;
      return this;
    }




    public PatientName build() {
      return new PatientName(id, text, familyName, givenName);
    }
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
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
}
