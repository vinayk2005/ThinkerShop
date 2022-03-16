package com.thinker.workshop.adapters.repository.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.thinker.workshop.adapters.repository.database.DatabaseConnection;
import com.thinker.workshop.adapters.repository.model.PatientAppointment;
import com.thinker.workshop.adapters.repository.model.ProviderName;
import java.sql.SQLException;

public class PatientAppointmentDao {
  public  Dao<PatientAppointment, String> getPatientAppointmentDao() throws SQLException {
    Dao<PatientAppointment,String> patientAppointmentDao = DaoManager
        .createDao(DatabaseConnection.getDatabaseConnection().getConnectionSource(), PatientAppointment.class);
    return patientAppointmentDao;
  }
}
