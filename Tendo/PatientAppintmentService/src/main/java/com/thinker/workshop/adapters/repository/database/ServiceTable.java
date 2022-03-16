package com.thinker.workshop.adapters.repository.database;

import com.j256.ormlite.table.TableUtils;

import com.thinker.workshop.adapters.repository.model.Patient;
import com.thinker.workshop.adapters.repository.model.PatientAddress;
import com.thinker.workshop.adapters.repository.model.PatientAppointment;
import com.thinker.workshop.adapters.repository.model.PatientAppointmentFeedback;
import com.thinker.workshop.adapters.repository.model.PatientContact;
import com.thinker.workshop.adapters.repository.model.PatientDiagnosis;
import com.thinker.workshop.adapters.repository.model.PatientDiagnosisCoding;
import com.thinker.workshop.adapters.repository.model.PatientName;
import com.thinker.workshop.adapters.repository.model.Provider;
import com.thinker.workshop.adapters.repository.model.ProviderName;
import java.sql.SQLException;

public class ServiceTable {

  public static  void createUserTableIfNotExist() throws SQLException {
    TableUtils.createTableIfNotExists(DatabaseConnection.getDatabaseConnection().getConnectionSource(), Patient.class);
    TableUtils.createTableIfNotExists(DatabaseConnection.getDatabaseConnection().getConnectionSource(), PatientAddress.class);
    TableUtils.createTableIfNotExists(DatabaseConnection.getDatabaseConnection().getConnectionSource(), PatientContact.class);
    TableUtils.createTableIfNotExists(DatabaseConnection.getDatabaseConnection().getConnectionSource(), PatientName.class);
    TableUtils.createTableIfNotExists(DatabaseConnection.getDatabaseConnection().getConnectionSource(), ProviderName.class);
    TableUtils.createTableIfNotExists(DatabaseConnection.getDatabaseConnection().getConnectionSource(), PatientAppointment.class);
    TableUtils.createTableIfNotExists(DatabaseConnection.getDatabaseConnection().getConnectionSource(), PatientAppointmentFeedback.class);
    TableUtils.createTableIfNotExists(DatabaseConnection.getDatabaseConnection().getConnectionSource(), Provider.class);
    TableUtils.createTableIfNotExists(DatabaseConnection.getDatabaseConnection().getConnectionSource(), ProviderName.class);
    TableUtils.createTableIfNotExists(DatabaseConnection.getDatabaseConnection().getConnectionSource(), PatientDiagnosis.class);
    TableUtils.createTableIfNotExists(DatabaseConnection.getDatabaseConnection().getConnectionSource(), PatientDiagnosisCoding.class);

  }

}
