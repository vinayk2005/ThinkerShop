package com.thinker.workshop.adapters.repository.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.thinker.workshop.adapters.repository.database.DatabaseConnection;
import com.thinker.workshop.adapters.repository.model.PatientDiagnosis;
import com.thinker.workshop.adapters.repository.model.PatientDiagnosisCoding;
import java.sql.SQLException;

public class PatientDiagnosisCodingDao {
  public static Dao<PatientDiagnosisCoding, String> getPatientDiagonsisCodingDao() throws SQLException {
    Dao<PatientDiagnosisCoding,String> patientDiagnosisCodingDao = DaoManager
        .createDao(DatabaseConnection.getDatabaseConnection().getConnectionSource(), PatientDiagnosisCoding.class);
    return patientDiagnosisCodingDao;
  }
}
