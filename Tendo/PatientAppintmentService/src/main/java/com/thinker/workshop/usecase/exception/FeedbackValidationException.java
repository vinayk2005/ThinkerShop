package com.thinker.workshop.usecase.exception;

public class FeedbackValidationException extends RuntimeException {
  public FeedbackValidationException(final String message) {
    super(message);
  }
}
