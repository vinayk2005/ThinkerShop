package com.thinker.workshop.adapters.repository.dao;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.thinker.workshop.adapters.repository.database.DatabaseConnection;
import com.thinker.workshop.adapters.repository.model.PatientName;
import com.thinker.workshop.adapters.repository.model.Provider;
import java.sql.SQLException;

public class ProviderDao {
  public  Dao<Provider, String> getProviderDao() throws SQLException {
    Dao<Provider,String> providerDao = DaoManager
        .createDao(DatabaseConnection.getDatabaseConnection().getConnectionSource(), Provider.class);
    return providerDao;
  }
}
