package com.thinker.workshop.adapters.repository.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.thinker.workshop.adapters.repository.database.DatabaseConnection;
import com.thinker.workshop.adapters.repository.model.PatientDiagnosis;
import java.sql.SQLException;

public class PatientDiagnosisDao {
  public  Dao<PatientDiagnosis, String> getPatientDaignosisDao() throws SQLException {
    Dao<PatientDiagnosis,String> patientDiagnosisDao = DaoManager
        .createDao(DatabaseConnection.getDatabaseConnection().getConnectionSource(), PatientDiagnosis.class);
    return patientDiagnosisDao;
  }
}
