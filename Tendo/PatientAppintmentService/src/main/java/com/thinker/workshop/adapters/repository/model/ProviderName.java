package com.thinker.workshop.adapters.repository.model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "provider_name")
public class ProviderName {
  @DatabaseField(generatedId = true)
  private int id;
  @DatabaseField
  private String familyName;
  @DatabaseField
  private String givenName;

  @DatabaseField (foreign = true, foreignAutoRefresh = true)
  private Provider provider;

  public ProviderName() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
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

  public Provider getProvider() {
    return provider;
  }

  public void setProvider(Provider provider) {
    this.provider = provider;
  }
}
