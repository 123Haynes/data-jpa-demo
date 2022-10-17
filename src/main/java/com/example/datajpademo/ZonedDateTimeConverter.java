package com.example.datajpademo;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Converter(autoApply = true)
public class ZonedDateTimeConverter implements AttributeConverter<ZonedDateTime, String> {

  public static final ZoneId BERLIN = ZoneId.of("Europe/Berlin");

  @Override
  public String convertToDatabaseColumn(ZonedDateTime localDateTime) {

    if (localDateTime == null) {

      return null;
    }

    return localDateTime.withZoneSameInstant(ZonedDateTimeConverter.BERLIN)
        .format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
  }

  @Override
  public ZonedDateTime convertToEntityAttribute(String databaseString) {

    if (databaseString == null) {

      return null;
    }

    return ZonedDateTime.parse(databaseString, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
        .withZoneSameInstant(ZonedDateTimeConverter.BERLIN);
  }
}
