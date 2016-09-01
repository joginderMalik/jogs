package com.labs.users.services;

import java.util.List;

import com.labs.users.model.Country;
import com.labs.users.model.District;
import com.labs.users.model.PatientDetails;
import com.labs.users.model.Role;
import com.labs.users.model.State;
import com.labs.users.model.User;
import com.labs.users.services.viewmodels.PatientDetailsViewModel;

public interface DbService {

	public User getUserByName(String name);

	public Object getDetailsById(int id);
	
	public String saveAndUpdateData(Object object);

	public PatientDetails getPatientByPatientId(int patientId);

	public List<User> getAllUsers();
	
	public List<Country> getCountryList();

	public List<State> getStateByCountryId(int countryId);

	public List<District> getDistrictByStateId(int stateId);

	public Role getRoleByName(String roles);

	List<PatientDetails> getPatientByNameAndMobileNo(PatientDetailsViewModel patientDetailsViewModel);

	public List<PatientDetails> getTodaysPatients();

}
