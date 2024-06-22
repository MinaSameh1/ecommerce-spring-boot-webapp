package com.ecommerce.webapp.modules.role;

public enum Role {
  admin("admin"), user("user");

  private String role;

  Role(String role) {
    this.role = role;
  }

  public String getRole() {
    return role;
  }

  @Override
  public String toString() { return role; }
};
