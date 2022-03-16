package com.thinker.workshop.entity;

public class ProviderName {

  private String id;
  private String familyName;
  private String givenName;

  public ProviderName(String id, String familyName, String givenName) {
    this.id = id;
    this.familyName = familyName;
    this.givenName = givenName;
  }
  public static ProviderName.ProviderNameBuilder builder() {
    return new ProviderName.ProviderNameBuilder();
  }

  public static class ProviderNameBuilder {
    private String id;
    private String familyName;
    private String givenName;

    ProviderNameBuilder() {
    }

    public ProviderName.ProviderNameBuilder id(final String id) {
      this.id = id;
      return this;
    }



    public ProviderName.ProviderNameBuilder familyName(final String familyName) {
      this.familyName = familyName;
      return this;
    }

    public ProviderName.ProviderNameBuilder givenName(final String givenName) {
      this.givenName = givenName;
      return this;
    }




    public ProviderName build() {
      return new ProviderName(id, familyName, givenName);
    }
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
