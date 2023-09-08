package com.betrybe.museumfinder.exception;

/** MuseumNotFoundException. */
public class MuseumNotFoundException extends RuntimeException {
  public MuseumNotFoundException() {
    super("Museu não encontrado!");
  }
}
