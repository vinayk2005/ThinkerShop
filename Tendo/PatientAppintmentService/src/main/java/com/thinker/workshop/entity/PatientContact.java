package com.thinker.workshop.entity;

public class PatientContact {
  private String id;
  private String system;
  private String value;
  private String use;

  public PatientContact(String id, String system, String value, String use) {
    this.id = id;
    this.system = system;
    this.value = value;
    this.use = use;
  }

  public static PatientContact.PatientContactBuilder builder() {
    return new PatientContact.PatientContactBuilder();
  }

  public static class PatientContactBuilder {
    private String id;
    private String use;
    private String system;
    private String value;

    PatientContactBuilder() {
    }

    public PatientContact.PatientContactBuilder id(final String id) {
      this.id = id;
      return this;
    }

    public PatientContact.PatientContactBuilder use(final String use) {
      this.use = use;
      return this;
    }

    public PatientContact.PatientContactBuilder system(final String system) {
      this.system = system;
      return this;
    }

    public PatientContact.PatientContactBuilder value(final String value) {
      this.value = value;
      return this;
    }




    public PatientContact build() {
      return new PatientContact(id, use, system, value);
    }
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
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
}
