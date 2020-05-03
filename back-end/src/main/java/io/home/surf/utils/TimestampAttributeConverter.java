package io.home.surf.utils;

import java.sql.Timestamp;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Dimitris Anastasopoulos
 *
 */
@Converter
public class TimestampAttributeConverter implements AttributeConverter<Double, Timestamp> {

  @Override
  public Timestamp convertToDatabaseColumn(Double attribute) {
    if (Double.isNaN(attribute))
      return null;
    return TimeUtils.epochSecondsToTimestamp(attribute);
  }

  @Override
  public Double convertToEntityAttribute(Timestamp dbData) {
    if (dbData == null)
      return Double.NaN;
    return TimeUtils.timestampToEpochSeconds(dbData);
  }

}
