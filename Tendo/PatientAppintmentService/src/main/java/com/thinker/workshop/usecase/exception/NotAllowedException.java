package com.thinker.workshop.usecase.exception;

public class NotAllowedException extends RuntimeException {
  public NotAllowedException(final String message) {
    super(message);
  }
}