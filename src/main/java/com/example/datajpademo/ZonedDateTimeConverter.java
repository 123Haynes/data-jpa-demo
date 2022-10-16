package com.example.datajpademo;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Converter(autoApply = true)
public class ZonedDateTimeConverter implements AttributeConverter<ZonedDateTime, String> {

  public static final ZoneId BERLIN = ZoneId.of("Europe/Berlin");

  @Override
  public String convertToDatabaseColumn(ZonedDateTime localDateTime) {

    return ZonedDateTimeParser.print(localDateTime);
  }

  @Override
  public ZonedDateTime convertToEntityAttribute(String databaseString) {

    return ZonedDateTimeParser.parse(databaseString);
  }
}
