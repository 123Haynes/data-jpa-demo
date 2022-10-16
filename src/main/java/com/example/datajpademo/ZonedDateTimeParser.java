package com.example.datajpademo;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public final class ZonedDateTimeParser {

  private ZonedDateTimeParser() {

    throw new UnsupportedOperationException("no instances");
  }

  /**
   * Liest einen ISO-8601 String als ZonedDateTime.
   */
  public static ZonedDateTime parse(String string) {

    if (string == null) {

      return null;
    }

    return ZonedDateTime.parse(string, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
        .withZoneSameInstant(ZonedDateTimeConverter.BERLIN);
  }

  /**
   * Verwandelt die ZonedDateTime in einen ISO-8601 String.
   */
  public static String print(ZonedDateTime localDateTime) {

    if (localDateTime == null) {

      return null;
    }

    return localDateTime.withZoneSameInstant(ZonedDateTimeConverter.BERLIN)
        .format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
  }
}
