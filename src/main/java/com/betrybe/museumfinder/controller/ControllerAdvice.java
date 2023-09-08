package com.betrybe.museumfinder.controller;

import com.betrybe.museumfinder.exception.InvalidCoordinateException;
import com.betrybe.museumfinder.exception.MuseumNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/** ControllerAdvice. */
@RestControllerAdvice

public class ControllerAdvice {

  @ExceptionHandler(InvalidCoordinateException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public String handleInvalidCoordinateException(RuntimeException exception) {
    return exception.getMessage();
  }

  @ExceptionHandler(MuseumNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public String handleMuseumNotFoundException(RuntimeException exception) {
    return exception.getMessage();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public String handleException(RuntimeException exception) {
    return "Erro interno!";
  }
}
