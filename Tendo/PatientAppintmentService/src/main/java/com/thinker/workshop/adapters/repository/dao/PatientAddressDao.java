package com.thinker.workshop.adapters.repository.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.thinker.workshop.adapters.repository.database.DatabaseConnection;
import com.thinker.workshop.adapters.repository.model.PatientAddress;
import java.sql.SQLException;

public class PatientAddressDao {

  public static Dao<PatientAddress, String> getPatientAddressDao() throws SQLException {
    Dao<PatientAddress,String> addDao = DaoManager
        .createDao(DatabaseConnection.getDatabaseConnection().getConnectionSource(), PatientAddress.class);
    return addDao;
  }
}
