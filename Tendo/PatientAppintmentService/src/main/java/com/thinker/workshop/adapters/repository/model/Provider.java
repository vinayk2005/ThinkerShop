package com.thinker.workshop.adapters.repository.model;

import com.j256.ormlite.dao.ForeignCollection;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "provider")
public class Provider {

  @DatabaseField(generatedId = true)
  private int id;
  @DatabaseField
  private String type;
  @DatabaseField
  private String createdAt;
  @DatabaseField
  private String updatedAt;

  @ForeignCollectionField(eager = false)
  private ForeignCollection<ProviderName> providerNames;

  public Provider() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
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

  public ForeignCollection<ProviderName> getProviderNames() {
    return providerNames;
  }

  public void setProviderNames(
      ForeignCollection<ProviderName> providerNames) {
    this.providerNames = providerNames;
  }
}
