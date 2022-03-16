package com.thinker.workshop.adapters.repository;

import com.j256.ormlite.dao.Dao;
import com.thinker.workshop.adapters.repository.dao.PatientAppointmentDao;
import com.thinker.workshop.adapters.repository.dao.PatientAppointmentFeedbackDao;
import com.thinker.workshop.adapters.repository.model.PatientAddress;
import com.thinker.workshop.adapters.repository.model.PatientAppointment;
import com.thinker.workshop.entity.PatientAppointmentFeedback;
import com.thinker.workshop.usecase.bridge.PatientFeedbackRespository;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class DBPatientFeedbakRepository implements PatientFeedbackRespository {


  @Override
  public List<PatientAppointmentFeedback> getListByAppointmentId(String id) throws SQLException {

    PatientAppointmentFeedbackDao pafDao = new PatientAppointmentFeedbackDao();
    Dao<com.thinker.workshop.adapters.repository.model.PatientAppointmentFeedback, String> ptApptFeedbackDao = pafDao.getPatientAppointmentFeedbackDao();

    List<com.thinker.workshop.adapters.repository.model.PatientAppointmentFeedback> feedbacks =
        ptApptFeedbackDao.queryBuilder().where().
            eq("patientAppointment_id", id).query();


    return getEntityPatientApptFeedback(feedbacks);
  }

  @Override
  public void createFeedbackForAppointment(PatientAppointmentFeedback feedback)
      throws SQLException {

      PatientAppointmentDao aDao = new PatientAppointmentDao();
      Dao<com.thinker.workshop.adapters.repository.model.PatientAppointment, String> patientAppointmentDao = aDao
          .getPatientAppointmentDao();
      PatientAppointment appt = patientAppointmentDao
          .queryForId(feedback.getPatientAppointmentId());

      PatientAppointmentFeedbackDao paDao = new PatientAppointmentFeedbackDao();
      Dao<com.thinker.workshop.adapters.repository.model.PatientAppointmentFeedback, String> patientAppointmentFeedbackDao = paDao
          .getPatientAppointmentFeedbackDao();

      com.thinker.workshop.adapters.repository.model.PatientAppointmentFeedback ptfeedback = new com.thinker.workshop.adapters.repository.model.PatientAppointmentFeedback();
      ptfeedback.setPatientAppointment(appt);
      ptfeedback.setQuestionnaireId(feedback.getQuestionnaireId());
      ptfeedback.setValue(feedback.getValue());
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
      Date date = new Date(System.currentTimeMillis());
      System.out.println(formatter.format(date));

      ptfeedback.setCreatedAt(formatter.format(date));
      ptfeedback.setUpdatedAt(formatter.format(date));
      patientAppointmentFeedbackDao.create(ptfeedback);
    }

    @Override
    public void modifyFeedbackForAppointment(PatientAppointmentFeedback feedback)
        throws SQLException { PatientAppointmentDao aDao = new PatientAppointmentDao();
      Dao<com.thinker.workshop.adapters.repository.model.PatientAppointment, String> patientAppointmentDao = aDao
          .getPatientAppointmentDao();
      PatientAppointment appt = patientAppointmentDao
          .queryForId(feedback.getPatientAppointmentId());

      PatientAppointmentFeedbackDao paDao = new PatientAppointmentFeedbackDao();
      Dao<com.thinker.workshop.adapters.repository.model.PatientAppointmentFeedback, String> patientAppointmentFeedbackDao = paDao
          .getPatientAppointmentFeedbackDao();

      com.thinker.workshop.adapters.repository.model.PatientAppointmentFeedback ptfeedback = patientAppointmentFeedbackDao.queryForId(feedback.getId());
      ptfeedback.setPatientAppointment(appt);
      ptfeedback.setQuestionnaireId(feedback.getQuestionnaireId());
      ptfeedback.setValue(feedback.getValue());
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
      Date date = new Date(System.currentTimeMillis());

      //ptfeedback.setCreatedAt(formatter.format(date));
      ptfeedback.setUpdatedAt(formatter.format(date));
      patientAppointmentFeedbackDao.update(ptfeedback);
    }

  private List<com.thinker.workshop.entity.PatientAppointmentFeedback> getEntityPatientApptFeedback(
      Collection<com.thinker.workshop.adapters.repository.model.PatientAppointmentFeedback> feedbacks){
    List<com.thinker.workshop.entity.PatientAppointmentFeedback> entityFeedbacks = new ArrayList<
        com.thinker.workshop.entity.PatientAppointmentFeedback>();
    for (com.thinker.workshop.adapters.repository.model.PatientAppointmentFeedback feedback : feedbacks) {
      entityFeedbacks.add(new PatientAppointmentFeedback(Integer.toString(feedback.getId()),feedback.getValue(),feedback.getQuestionnaireId(),Integer.toString(feedback.getPatientAppointment().getId()),feedback.getCreatedAt(),feedback.getUpdatedAt()));
    }
    return entityFeedbacks;
  }
  }

