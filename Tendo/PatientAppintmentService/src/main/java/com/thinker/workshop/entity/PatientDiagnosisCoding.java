package com.thinker.workshop.entity;

public class PatientDiagnosisCoding {
  
  private String id;
  private String system;
  private String value;
  private String name;

  public PatientDiagnosisCoding(String id, String system, String value, String name) {
    this.id = id;
    this.system = system;
    this.value = value;
    this.name = name;
  }

  public static PatientDiagnosisCoding.PatientDiagnosisBuilder builder() {
    return new PatientDiagnosisCoding.PatientDiagnosisBuilder();
  }

  public static class PatientDiagnosisBuilder {
    private String id;
    private String system;
    private String value;
    private String name;

    PatientDiagnosisBuilder() {
    }

    public PatientDiagnosisCoding.PatientDiagnosisBuilder id(final String id) {
      this.id = id;
      return this;
    }

    public PatientDiagnosisCoding.PatientDiagnosisBuilder name(final String name) {
      this.name = name;
      return this;
    }

    public PatientDiagnosisCoding.PatientDiagnosisBuilder system(final String system) {
      this.system = system;
      return this;
    }

    public PatientDiagnosisCoding.PatientDiagnosisBuilder value(final String value) {
      this.value = value;
      return this;
    }




    public PatientDiagnosisCoding build() {
      return new PatientDiagnosisCoding(id, system, value,name);
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
