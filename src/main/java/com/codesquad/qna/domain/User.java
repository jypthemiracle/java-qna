package com.codessquad.qna.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
  @Id //primary key that differentiates it from one another.
  @GeneratedValue(strategy = GenerationType.IDENTITY) //데이터베이스를 추가할 때 자동으로 1씩 증가함
  private long id;

  @Column(nullable = false, length = 20) //default는 true이다. 20개의 열 길이를 갖는다.
  private String userId;
  private String password;
  private String name;
  private String email;

  public long getId() { return id; }

  public void setId(long id) { this.id = id; }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUserId() {
    return userId;
  }

  public String getPassword() {
    return password;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return "userId" + userId + " id " + id + " password" + password + " name" + name + " email" + email;
  }

  public void updateUser(User updateUser) {
    this.name = updateUser.name;
    this.email = updateUser.email;
  }
}