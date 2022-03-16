package com.thinker.workshop.entity;

public class PatientAddress {

  private String id;
  private String use;
  private String line1;
  private String line2;
  private String line3;

  public PatientAddress(String id, String use, String line1, String line2, String line3) {
    this.id = id;
    this.use = use;
    this.line1 = line1;
    this.line2 = line2;
    this.line3 = line3;
  }

  public static PatientAddress.PatientAddressBuilder builder() {
    return new PatientAddress.PatientAddressBuilder();
  }

  public static class PatientAddressBuilder {
    private String id;
    private String use;
    private String line1;
    private String line2;
    private String line3;

    PatientAddressBuilder() {
    }

    public PatientAddress.PatientAddressBuilder id(final String id) {
      this.id = id;
      return this;
    }

    public PatientAddress.PatientAddressBuilder use(final String use) {
      this.use = use;
      return this;
    }

    public PatientAddress.PatientAddressBuilder line1(final String line1) {
      this.line1 = line1;
      return this;
    }

    public PatientAddress.PatientAddressBuilder line2(final String line2) {
      this.line2 = line2;
      return this;
    }

    public PatientAddress.PatientAddressBuilder line3(final String line3) {
      this.line3 = line3;
      return this;
    }


    public PatientAddress build() {
      return new PatientAddress(id, use, line1, line2, line3);
    }
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getUse() {
    return use;
  }

  public void setUse(String use) {
    this.use = use;
  }

  public String getLine1() {
    return line1;
  }

  public void setLine1(String line1) {
    this.line1 = line1;
  }

  public String getLine2() {
    return line2;
  }

  public void setLine2(String line2) {
    this.line2 = line2;
  }

  public String getLine3() {
    return line3;
  }

  public void setLine3(String line3) {
    this.line3 = line3;
  }
}
