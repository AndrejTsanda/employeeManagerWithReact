package com.tsanda.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Integer id;

  @Column(name = "user_name")
  private String userName;

  @Column(name = "user_password")
  private String userPassword;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }

  @Override
  public String toString() {
    return "User{"
        + "id="
        + id
        + ", userName='"
        + userName
        + '\''
        + ", userPassword='"
        + userPassword
        + '\''
        + '}';
  }
}
