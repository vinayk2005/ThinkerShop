package com.thinker.workshop.adapters.repository.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.thinker.workshop.adapters.repository.database.DatabaseConnection;
import com.thinker.workshop.adapters.repository.model.PatientAppointmentFeedback;
import com.thinker.workshop.adapters.repository.model.PatientContact;
import java.sql.SQLException;

public class PatientAppointmentFeedbackDao {
  public  Dao<PatientAppointmentFeedback, String> getPatientAppointmentFeedbackDao() throws SQLException {
    Dao<PatientAppointmentFeedback,String> feedbackDao = DaoManager
        .createDao(DatabaseConnection.getDatabaseConnection().getConnectionSource(), PatientAppointmentFeedback.class);
    return feedbackDao;
  }
}
