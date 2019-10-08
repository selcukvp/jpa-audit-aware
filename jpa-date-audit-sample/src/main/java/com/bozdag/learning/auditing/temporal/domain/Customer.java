package com.bozdag.learning.auditing.temporal.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String firstName;
  private String lastName;
  private String country;

  @CreatedDate private LocalDateTime createdAt;

  @LastModifiedDate private LocalDateTime updatedAt;

  protected Customer() {}

  public Customer(String firstName, String lastName, String country) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.country = country;
  }

  @Override
  public String toString() {
    return String.format(
        "Customer[id=%d, "
            + "firstName='%s', "
            + "lastName='%s', "
            + "country='%s', "
            + "created at='%s', "
            + "updated at='%s']",
        id, firstName, lastName, country, createdAt, updatedAt);
  }

  public Long getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}
