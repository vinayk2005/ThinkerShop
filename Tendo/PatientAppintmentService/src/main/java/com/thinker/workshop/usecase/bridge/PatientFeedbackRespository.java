package com.thinker.workshop.usecase.bridge;

import com.thinker.workshop.entity.PatientAppointmentFeedback;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface PatientFeedbackRespository {
  List<PatientAppointmentFeedback> getListByAppointmentId(String id) throws SQLException;
  void createFeedbackForAppointment(PatientAppointmentFeedback feedback)
      throws SQLException;
  void modifyFeedbackForAppointment(PatientAppointmentFeedback feedback) throws SQLException;
}
