package com.thinker.workshop.adapters.repository.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.thinker.workshop.adapters.repository.database.DatabaseConnection;
import com.thinker.workshop.adapters.repository.model.PatientAddress;
import com.thinker.workshop.adapters.repository.model.PatientName;
import java.sql.SQLException;

public class PatientNameDao {
  public static Dao<PatientName, String> getPatientNameDao() throws SQLException {
    Dao<PatientName,String> patientNameDao = DaoManager
        .createDao(DatabaseConnection.getDatabaseConnection().getConnectionSource(), PatientName.class);
    return patientNameDao;
  }
}
