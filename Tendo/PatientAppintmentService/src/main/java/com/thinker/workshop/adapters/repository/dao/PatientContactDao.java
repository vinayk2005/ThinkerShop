package com.thinker.workshop.adapters.repository.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.thinker.workshop.adapters.repository.database.DatabaseConnection;
import com.thinker.workshop.adapters.repository.model.PatientContact;
import java.sql.SQLException;

public class PatientContactDao {

  public static Dao<PatientContact, String> getPatientContactDao() throws SQLException {
    Dao<PatientContact,String> contactDao = DaoManager
        .createDao(DatabaseConnection.getDatabaseConnection().getConnectionSource(), PatientContact.class);
    return contactDao;
  }
}
