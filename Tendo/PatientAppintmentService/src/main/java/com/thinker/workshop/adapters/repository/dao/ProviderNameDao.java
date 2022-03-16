package com.thinker.workshop.adapters.repository.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.thinker.workshop.adapters.repository.database.DatabaseConnection;
import com.thinker.workshop.adapters.repository.model.PatientName;
import com.thinker.workshop.adapters.repository.model.ProviderName;
import java.sql.SQLException;

public class ProviderNameDao {
  public static Dao<ProviderName, String> getProviderNameDao() throws SQLException {
    Dao<ProviderName,String> providerNameDao = DaoManager
        .createDao(DatabaseConnection.getDatabaseConnection().getConnectionSource(), ProviderName.class);
    return providerNameDao;
  }
}
