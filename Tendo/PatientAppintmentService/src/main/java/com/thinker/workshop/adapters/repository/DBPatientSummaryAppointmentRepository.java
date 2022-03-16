package com.thinker.workshop.adapters.repository;

import com.j256.ormlite.dao.Dao;
import com.sun.codemodel.internal.JForEach;
import com.thinker.workshop.adapters.repository.dao.PatientAppointmentDao;
import com.thinker.workshop.adapters.repository.dao.PatientDao;
import com.thinker.workshop.adapters.repository.dao.PatientDiagnosisDao;
import com.thinker.workshop.adapters.repository.dao.ProviderDao;
import com.thinker.workshop.adapters.repository.model.Patient;
import com.thinker.workshop.adapters.repository.model.PatientAddress;
import com.thinker.workshop.adapters.repository.model.PatientAppointment;
import com.thinker.workshop.adapters.repository.model.PatientContact;
import com.thinker.workshop.adapters.repository.model.PatientDiagnosis;
import com.thinker.workshop.adapters.repository.model.PatientName;
import com.thinker.workshop.adapters.repository.model.Provider;
import com.thinker.workshop.adapters.repository.model.ProviderName;
import com.thinker.workshop.entity.PatientAppointmentSummary;
import com.thinker.workshop.entity.PatientDiagnosisCoding;
import com.thinker.workshop.usecase.bridge.PatientAppointmentSummaryRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class DBPatientSummaryAppointmentRepository implements PatientAppointmentSummaryRepository {

  @Override
  public PatientAppointmentSummary findById(String id) throws SQLException {


    PatientDao pDao = new PatientDao();
    Dao<Patient, String> patientDao = pDao.getPatientDao();
    Patient patient = patientDao.queryForId(id);

    Collection <PatientAddress> patientAddresses = patient.getPatientAddresses();
    Collection <PatientContact> patientContacts = patient.getPatientContacts();
    Collection <PatientName> patientNames = patient.getPatientNames();

    PatientAppointmentDao paDao = new PatientAppointmentDao();
    Dao<PatientAppointment, String> patientAppointmentDao = paDao.getPatientAppointmentDao();
    List<PatientAppointment> appointments =
        patientAppointmentDao.queryBuilder().where().
            eq("patient_id", id).query();




    PatientDiagnosisDao pdDao = new PatientDiagnosisDao();
    Dao<PatientDiagnosis, String> patientDiagonsisDao = pdDao.getPatientDaignosisDao();
//    List<PatientDiagnosis> diagnosises =
//        patientDiagonsisDao.queryBuilder().where().
//            eq("patient_appointment_id", appointments.get(0).getId()).query();

    PatientDiagnosis diagnosis = patientDiagonsisDao.queryForId(Integer.toString(appointments.get(0).getId()));

    ProviderDao prDao = new ProviderDao();
    Dao<Provider, String> providerDao = prDao.getProviderDao();

    Provider provider = providerDao.queryForId(Integer.toString(appointments.get(0).getId()));


    PatientAppointmentSummary summary = new PatientAppointmentSummary(getEntityPatient(patient),getEntityPatientAppointment(appointments.get(0)),getEntityPatientDiagnosis(diagnosis),getEntityProvider(provider));

    return summary;
  }

  private com.thinker.workshop.entity.Patient getEntityPatient(Patient patient){

    return  new com.thinker.workshop.entity.Patient(
        Integer.toString(patient.getId()),
        patient.getGender(),
        patient.getBirthdate(),
        patient.getActive(),
        getEntityPatientAddress(patient.getPatientAddresses()),
        getEntityPatientContact(patient.getPatientContacts()),
        getEntityPatientName(patient.getPatientNames()),
        patient.getCreatedAt(),
        patient.getUpdatedAt());
  }

  private List<com.thinker.workshop.entity.PatientAddress> getEntityPatientAddress(Collection<PatientAddress> addresses){
    List<com.thinker.workshop.entity.PatientAddress> entityAddresses = new ArrayList<
        com.thinker.workshop.entity.PatientAddress>();
    for (PatientAddress address : addresses) {
      entityAddresses.add(new com.thinker.workshop.entity.PatientAddress(Integer.toString(address.getId()),address.getUse(),address.getLine1(),address.getLine2(),address.getLine3()));
    }
    return entityAddresses;
  }

  private List<com.thinker.workshop.entity.PatientContact> getEntityPatientContact(Collection<PatientContact> contacts){
    List<com.thinker.workshop.entity.PatientContact> entityContacts = new ArrayList<
        com.thinker.workshop.entity.PatientContact>();
    for (PatientContact contact : contacts) {
      entityContacts.add(new com.thinker.workshop.entity.PatientContact(Integer.toString(contact.getId()),contact.getSystem(),contact.getValue(),contact.getUse()));
    }
    return entityContacts;
  }

  private List<com.thinker.workshop.entity.PatientName> getEntityPatientName(Collection<PatientName> names){
    List<com.thinker.workshop.entity.PatientName> entityNames = new ArrayList<
        com.thinker.workshop.entity.PatientName>();
    for (PatientName name : names) {
      entityNames.add(new com.thinker.workshop.entity.PatientName(Integer.toString(name.getId()),name.getText(),name.getFamilyName(),name.getGivenName()));
    }
    return entityNames;
  }

  private com.thinker.workshop.entity.PatientAppointment getEntityPatientAppointment(PatientAppointment appt){
  return  new com.thinker.workshop.entity.PatientAppointment(Integer.toString(appt.getId()),appt.getStatus(),appt.getType(),appt.getStartAt(),appt.getEndAt(),appt.getCreatedAt(),
      appt.getCreatedAt(),Integer.toString(appt.getPatient().getId()),Integer.toString(appt.getProvider().getId()));
  }

  private com.thinker.workshop.entity.PatientDiagnosis getEntityPatientDiagnosis(PatientDiagnosis diagnosis){
    //com.thinker.workshop.entity.PatientDiagnosis entityDiagnosis = new com.thinker.workshop.entity.PatientDiagnosis();
    Collection<com.thinker.workshop.adapters.repository.model.PatientDiagnosisCoding> codings = diagnosis.getPatientDiagnosisCodings();
    List<com.thinker.workshop.entity.PatientDiagnosisCoding> entityCondings = new ArrayList<>() ;
    for (com.thinker.workshop.adapters.repository.model.PatientDiagnosisCoding coding : codings) {
      entityCondings.add(new com.thinker.workshop.entity.PatientDiagnosisCoding(Integer.toString(coding.getId()),coding.getSystem(),coding.getValue(), coding.getName()));
    }

    return new com.thinker.workshop.entity.PatientDiagnosis(Integer.toString(diagnosis.getId()),diagnosis.getStatus(),diagnosis.getLastUpdatedAt(),diagnosis.getCreatedAt(),diagnosis.getUpdatedAt(),Integer.toString(diagnosis.getPatientAppointment().getId()),entityCondings);

  }


  private com.thinker.workshop.entity.Provider getEntityProvider(Provider provider){

    return  new com.thinker.workshop.entity.Provider(
        Integer.toString(provider.getId()),
        provider.getType(),
        provider.getCreatedAt(),
        provider.getUpdatedAt(),
        getEntityProviderName(provider.getProviderNames()));
  }

  private List<com.thinker.workshop.entity.ProviderName> getEntityProviderName(Collection<ProviderName> names){
    List<com.thinker.workshop.entity.ProviderName> entityNames = new ArrayList<
        com.thinker.workshop.entity.ProviderName>();
    for (ProviderName name : names) {
      entityNames.add(new com.thinker.workshop.entity.ProviderName(Integer.toString(name.getId()),name.getFamilyName(),name.getGivenName()));
    }
    return entityNames;
  }
}

