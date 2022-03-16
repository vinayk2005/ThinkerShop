package com.thinker.workshop.adapters.repository.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.thinker.workshop.adapters.repository.database.DatabaseConnection;
import com.thinker.workshop.adapters.repository.model.Patient;
import java.sql.SQLException;

public class PatientDao {

  public  Dao<Patient, String> getPatientDao() throws SQLException {
    Dao<Patient,String> patientDao = DaoManager
        .createDao(DatabaseConnection.getDatabaseConnection().getConnectionSource(), Patient.class);
    return patientDao;
  }
}
