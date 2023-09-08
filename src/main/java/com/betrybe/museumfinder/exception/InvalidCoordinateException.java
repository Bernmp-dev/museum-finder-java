package com.betrybe.museumfinder.exception;

import java.io.UncheckedIOException;

/**
 * InvalidCoordinateException.
 */
public class InvalidCoordinateException extends RuntimeException {

  public InvalidCoordinateException() {
    super("Invalid coordinate.");
  }
}
