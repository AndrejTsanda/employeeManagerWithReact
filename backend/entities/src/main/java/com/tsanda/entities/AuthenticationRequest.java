package com.tsanda.entities;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {

  private static final long serialVersionUID = 5926468583005150707L;

  private String username;
  private String password;

  public String getUsername() {
    return this.username;
  }

  public String getPassword() {
    return this.password;
  }
}
