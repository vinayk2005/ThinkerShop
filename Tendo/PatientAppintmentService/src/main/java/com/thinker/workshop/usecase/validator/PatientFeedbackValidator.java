package com.thinker.workshop.usecase.validator;

import static org.apache.commons.lang3.StringUtils.isBlank;

import com.thinker.workshop.entity.PatientAppointmentFeedback;
import com.thinker.workshop.entity.User;
import com.thinker.workshop.usecase.exception.FeedbackValidationException;

public class PatientFeedbackValidator {

  public static void validatePatientFeedback(final PatientAppointmentFeedback feedback) {
    if (feedback == null) throw new FeedbackValidationException("Patient feedback should not be null");
    if (isBlank(feedback.getPatientAppointmentId())) throw new FeedbackValidationException("Appointment should not be null");
    if (isBlank(feedback.getValue())) throw new FeedbackValidationException("Feedback value should not be null");
    // additional checks could be added here!!!
  }

  private PatientFeedbackValidator() {

  }
}
