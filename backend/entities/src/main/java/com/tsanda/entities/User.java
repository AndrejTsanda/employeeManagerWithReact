package com.tsanda.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Entity
@Table(name = "users")
@ApiModel(description = "Model user for database.", value = "User Table")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  @ApiModelProperty(
      value = "The unique Id of the user more than zero.",
      required = true,
      position = 1,
      example = "1",
      hidden = true)
  private Integer id;

  @Column(name = "user_name")
  @ApiModelProperty(
      value = "Unique user name. Not empty value",
      required = true,
      position = 2,
      example = "sidorov",
      allowableValues = "range[1, 45]")
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
