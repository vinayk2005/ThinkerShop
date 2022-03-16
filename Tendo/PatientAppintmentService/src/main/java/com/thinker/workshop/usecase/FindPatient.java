package com.thinker.workshop.usecase;

import com.thinker.workshop.entity.PatientAppointmentSummary;
import com.thinker.workshop.entity.User;
import com.thinker.workshop.usecase.bridge.PatientAppointmentSummaryRepository;
import java.sql.SQLException;
import java.util.Optional;

public class FindPatient {
  private final PatientAppointmentSummaryRepository patientRepository;

  public FindPatient(PatientAppointmentSummaryRepository patientRepository) {
    this.patientRepository = patientRepository;
  }

  public PatientAppointmentSummary findById(final String id) throws SQLException {
    return patientRepository.findById(id);
  }

}
