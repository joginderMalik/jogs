package com.labs.users.services;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.labs.users.model.Country;
import com.labs.users.model.District;
import com.labs.users.model.PatientDetails;
import com.labs.users.model.Role;
import com.labs.users.model.State;
import com.labs.users.model.User;
import com.labs.users.services.viewmodels.PatientDetailsViewModel;

@Service
@Transactional
public class DbServiceImpl implements DbService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User getUserByName(String name) {
		Session session = sessionFactory.openSession();
		try
		{
			String hql = "FROM User WHERE username = :username";
			Query query = session.createQuery(hql);
			
			query.setParameter("username",name);
			
			List<User> results = query.list();
			
			if(results.size()==1){
				Hibernate.initialize(results.get(0).getRole());	
				return results.get(0);
			}else{
				return null;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally {
			session.clear();
			session.close();
		}	
	}

	@Override
	public String saveAndUpdateData(Object object){
		Session session = sessionFactory.openSession();
		try{
			session.beginTransaction();
	        
	        if(object != null){
	        	
	        	System.out.println("data inserted into table");
		        
		        session.saveOrUpdate(object);
	        }
	        //Commit the transaction
	        session.getTransaction().commit();
	        
	        return "SUCCESS";
	        
		}catch(Exception ex){
			ex.printStackTrace();
		}finally {
			session.clear();
			session.close();
		}
		
		return null;
	}

	@Override
	public List<PatientDetails> getPatientByNameAndMobileNo(PatientDetailsViewModel patientDetailsViewModel) {
		Session session = sessionFactory.openSession();
		try{
			String hql = "FROM PatientDetails WHERE firstName LIKE:firstName OR mobileNo =:mobileNo OR emailId= :emailId OR dob= :dob OR age= :age";
			Query query = session.createQuery(hql);
			
			if(patientDetailsViewModel.getFirstName().equals("")){
				query.setParameter("firstName","qwerty");
			}else{
				query.setParameter("firstName","%"+ patientDetailsViewModel.getFirstName().toLowerCase() +"%");
			}
			
			if(patientDetailsViewModel.getMobileNo() == -123){
				query.setParameter("mobileNo", -123);
			}else{
				query.setParameter("mobileNo", Double.valueOf(patientDetailsViewModel.getMobileNo()));
			}
			if(patientDetailsViewModel.getEmailId().equals("xxx.xxx@xxx.com"))
			{
				query.setParameter("emailId", "xxx.xxx@xxx.com");
			}else{
				query.setParameter("emailId", patientDetailsViewModel.getEmailId());
			}
			
			if(patientDetailsViewModel.getDob().equals(""))
			{
				query.setParameter("dob", "-123");
			}else{
				query.setParameter("dob", patientDetailsViewModel.getDob());
			}
			
			if(patientDetailsViewModel.getAge() == -123){
				query.setParameter("age", -123);
			}else{
				query.setParameter("age", patientDetailsViewModel.getAge());
			}
			return query.list();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}finally {
			session.clear();
			session.close();
		}
	}

	@Override
	public List<Country> getCountryList() {
		Session session = sessionFactory.openSession();
		try{
			String hql = "FROM Country";
			Query query = session.createQuery(hql);
			System.out.println("county list size:"+ query.list().size());
			
			return  query.list();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}finally {
			session.clear();
			session.close();
		}
	}

	@Override
	public List<State> getStateByCountryId(int countryId) {
		Session session = sessionFactory.openSession();
		try{
			String hql = "FROM State WHERE countryId = :countryId";
			Query query = session.createQuery(hql);
			query.setParameter("countryId",countryId);
			return query.list();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}finally {
			session.clear();
			session.close();
		}
	}
	@Override
	public List<District> getDistrictByStateId(int stateId) {
		Session session = sessionFactory.openSession();
		try{
			String hql = "FROM District WHERE stateId = :stateId";
			Query query = session.createQuery(hql);
			query.setParameter("stateId",stateId);
			return query.list();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}finally {
			session.clear();
			session.close();
		}
	}

	@Override
	public List<User> getAllUsers() {
		Session session = sessionFactory.openSession();
		try{
			String hql = "FROM User";
			Query query = session.createQuery(hql);
			List<User> list = query.list();
			for(User user : list){
				Hibernate.initialize(user.getRole());	
			}
			
			return query.list();
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}finally {
			session.clear();
			session.close();
		}
	}
	
	@Override
	public Role getRoleByName(String role) {
		Session session = sessionFactory.openSession();
		try
		{
			String hql = "FROM Role WHERE role = :role";
			Query query = session.createQuery(hql);
			
			query.setParameter("role",role);
			
			List<Role> results = query.list();
			
			if(results.size()==1){
				return results.get(0);
			}else{
				return null;
			}
		}catch(Exception ex){
			ex.printStackTrace();
			return null;
		}finally {
		session.clear();
		session.close();
		}
	}

	@Override
	public Object getDetailsById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Getter and Setter for session factory
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public PatientDetails getPatientByPatientId(int patientId) {
		Session session = sessionFactory.openSession();
		try{
			String hql = "FROM PatientDetails WHERE patientId = :patientId";
			Query query = session.createQuery(hql);
			query.setParameter("patientId",patientId);
			
			return (PatientDetails) query.list().get(0);
			
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}finally {
			session.clear();
			session.close();
		}
	}

	@Override
	public List<PatientDetails> getTodaysPatients() {
		Session session = sessionFactory.openSession();
		try{
			String hql = "FROM PatientDetails where dateOfVisit = :dateOfVisit";
			
			Query query = session.createQuery(hql);
			
			SimpleDateFormat parseFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
            Date date = parseFormat.parse(new Date().toString());
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            String formatedDate = format.format(date);
            
			query.setParameter("dateOfVisit", formatedDate);
			System.out.println("Patients list size:"+ query.list().size());
			
			return  query.list();
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}finally {
			session.clear();
			session.close();
		}
	}
	
	
}