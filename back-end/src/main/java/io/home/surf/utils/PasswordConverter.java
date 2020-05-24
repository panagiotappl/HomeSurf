package io.home.surf.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author Dimitris Anastasopoulos
 *
 */
@Converter
public class PasswordConverter implements AttributeConverter<String, String> {

  @Override
  public String convertToDatabaseColumn(String attribute) {
    try {
      MessageDigest digest = MessageDigest.getInstance("SHA-256");
      byte[] hash = digest.digest(attribute.getBytes(StandardCharsets.UTF_8));
      return Base64.getEncoder().encodeToString(hash);
    } catch (NoSuchAlgorithmException e) {
      return null;
    }
  }

  @Override
  public String convertToEntityAttribute(String dbData) {
    return dbData;
  }

}
