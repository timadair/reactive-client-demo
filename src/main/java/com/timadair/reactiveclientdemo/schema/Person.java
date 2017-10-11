package com.timadair.reactiveclientdemo.schema;

/**
 * A Bean for serializing and de-serializing
 *
 * @author timadair
 * Created 10/10/17.
 */
public class Person {
  private String id;
  private String givenName;
  private String surname;
  private String fullName;

  public Person() {
  }

  public Person(String id, String givenName, String surname, String fullName) {
    this.id = id;
    this.givenName = givenName;
    this.surname = surname;
    this.fullName = fullName;
  }

  public String getId() {
    return id;
  }

  public String getGivenName() {
    return givenName;
  }

  public String getSurname() {
    return surname;
  }

  public String getFullName() {
    return fullName;
  }
}
