package io.home.surf.utils;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author Dimitris Anastasopoulos
 *
 */
public class TimeUtils {

  private TimeUtils() {
  }

  public static Timestamp epochSecondsToTimestamp(double seconds) {
    return epochMilliToTimestamp(Math.round((seconds * 1000)));
  }

  private static Timestamp epochMilliToTimestamp(long milli) {
    Instant instant = Instant.EPOCH;
    LocalDateTime ldt = LocalDateTime.ofInstant(instant.plus(Duration.ofMillis(milli)),
        ZoneOffset.UTC);

    return Timestamp.valueOf(ldt);
  }

  public static double timestampToEpochSeconds(Timestamp timestamp) {
    LocalDateTime ldt = timestamp.toLocalDateTime();
    return ldt.toInstant(ZoneOffset.UTC).toEpochMilli() / 1000.0;
  }

}
