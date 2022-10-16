package com.example.datajpademo;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@DynamicInsert
public class DemoEntity {

  @Id
  private String identificationString;

  private ZonedDateTime updated;

  public String getIdentificationString() {
    return identificationString;
  }

  public void setIdentificationString(String identificationString) {
    this.identificationString = identificationString;
  }

  public ZonedDateTime getUpdated() {
    return updated;
  }

  public void setUpdated(ZonedDateTime updated) {
    this.updated = updated;
  }
}