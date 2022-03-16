package com.thinker.workshop.adapters.repository.database;


import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;

public class DatabaseConnection {

  private static DatabaseConnection instance;

  public ConnectionSource getConnectionSource() {
    return connectionSource;
  }

  private static ConnectionSource connectionSource;

  public static DatabaseConnection getDatabaseConnection() throws SQLException {

    if(instance == null){
      synchronized (DatabaseConnection.class) {
        if(instance == null){

          String databaseUrl = "jdbc:mysql://127.0.0.1:3306/internal";
          ConnectionSource connSource = new JdbcConnectionSource(databaseUrl);
          ((JdbcConnectionSource)connSource).setUsername("root");
          ((JdbcConnectionSource)connSource).setPassword("virani");
          connectionSource = connSource;
          instance = new DatabaseConnection();
        }
      }
    }
    return instance;
  }

}
