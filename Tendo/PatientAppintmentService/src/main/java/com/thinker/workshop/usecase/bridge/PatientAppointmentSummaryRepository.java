package com.thinker.workshop.usecase.bridge;

import com.thinker.workshop.entity.Patient;
import com.thinker.workshop.entity.PatientAppointmentSummary;
import com.thinker.workshop.entity.User;
import java.sql.SQLException;
import java.util.Optional;

public interface PatientAppointmentSummaryRepository {
  PatientAppointmentSummary findById(String id) throws SQLException;
}
