package io.home.surf.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Dimitris Anastasopoulos
 *
 */
public class HomeSurfApiException extends Exception {

  private static final long serialVersionUID = 7471826102209068936L;

  private HttpStatus httpStatus;

  public static HomeSurfApiException conflict(String message) {
    return new HomeSurfApiException(message, HttpStatus.CONFLICT);
  }

  private HomeSurfApiException(String message, HttpStatus httpStatus) {
    super(message);
    this.httpStatus = httpStatus;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

}
