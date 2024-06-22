package com.ecommerce.webapp.modules.user;

import com.ecommerce.webapp.modules.role.Role;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
  @Id
  private String id;
  private String name;
  private String email;
  private String phone;
  private String password;
  private Role role;

  public void setId(String id) {
    this.id = id;
  }

}
