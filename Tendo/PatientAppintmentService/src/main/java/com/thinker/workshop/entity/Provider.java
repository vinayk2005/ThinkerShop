package com.thinker.workshop.entity;

import java.util.List;

public class Provider {
  private String id;
  private String type;
  private String createdAt;
  private String updatedAt;
  private List<ProviderName> providerNames;

  public Provider(String id, String type, String createdAt, String updatedAt,
      List<ProviderName> providerNames) {
    this.id = id;
    this.type = type;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.providerNames = providerNames;
  }

  public static Provider.ProviderBuilder builder() {
    return new Provider.ProviderBuilder();
  }

  public static class ProviderBuilder {
    private String id;
    private String type;
    private String createdAt;
    private String updatedAt;
    private List<ProviderName> providerNames;

    ProviderBuilder() {
    }

    public Provider.ProviderBuilder id(final String id) {
      this.id = id;
      return this;
    }

    public Provider.ProviderBuilder type(final String type) {
      this.type = type;
      return this;
    }


    public Provider.ProviderBuilder createdAt(final String createdAt) {
      this.createdAt = createdAt;
      return this;
    }
    public Provider.ProviderBuilder updatedAt(final String updatedAt) {
      this.updatedAt = updatedAt;
      return this;
    }

    public List<ProviderName> getProviderNames() {
      return providerNames;
    }

    public void setProviderNames(List<ProviderName> providerNames) {
      this.providerNames = providerNames;
    }

    public Provider build() {
      return new Provider(id, type,createdAt,updatedAt,providerNames);
    }
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
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

  public List<ProviderName> getProviderNames() {
    return providerNames;
  }

  public void setProviderNames(List<ProviderName> providerNames) {
    this.providerNames = providerNames;
  }
}
