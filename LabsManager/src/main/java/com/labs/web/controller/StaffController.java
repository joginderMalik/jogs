package com.labs.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.labs.users.model.PatientDetails;
import com.labs.users.model.Role;
import com.labs.users.model.User;
import com.labs.users.services.DbService;
import com.labs.users.services.viewmodels.PatientDetailsViewModel;
import com.labs.users.services.viewmodels.RegisteredUserViewModel;

@Controller
@RequestMapping(value = { "staff" })
public class StaffController{
	
private static final Logger logger = Logger.getLogger(StaffController.class);
	
	@Autowired
	private DbService dbService;
	
	@RequestMapping(value = {"/patientDetails" }, method=RequestMethod.POST,produces={"application/json"})
	@ResponseBody
	public String updatePatientDetails(@RequestBody String jsonString) {
		try{
			System.out.println("patientDetailsViewModel update JSON: " + jsonString);
			Gson gson = new Gson();
			PatientDetailsViewModel patientDetailsViewModel = gson.fromJson(jsonString, PatientDetailsViewModel.class);
			List<PatientDetails> patientsList = new ArrayList<PatientDetails>();
			System.out.println("mb"+ Double.valueOf(patientDetailsViewModel.getMobileNo()));
			if(!patientDetailsViewModel.getParam().equals("")){
				patientsList = dbService.getPatientByNameAndMobileNo(patientDetailsViewModel);
				System.out.println("no of patient found: "+ patientsList);
				if(patientsList.size() >0){
					patientDetailsViewModel.setStatus("Record Found");
					patientDetailsViewModel.setReason("Patient Already Registered");
					patientDetailsViewModel.setPatientsList(patientsList);
				}else{
					patientDetailsViewModel.setStatus("NoRecord");
					patientDetailsViewModel.setReason("Patient Not Registered");
				}
		        return gson.toJson(patientDetailsViewModel);	
			}else{
				PatientDetails patientDetails = new PatientDetails();
				patientDetails.setFirstName(patientDetailsViewModel.getFirstName().toLowerCase());
				patientDetails.setLastName(patientDetailsViewModel.getLastName().toLowerCase());
				
				patientDetails.setMobileNo((int) patientDetailsViewModel.getMobileNo());
	        	
				patientDetails.setAddress(patientDetailsViewModel.getAddress());
	        	
	        	patientDetails.setPassword(String.valueOf(patientDetailsViewModel.getMobileNo()));
				patientDetails.setPatientLoginId(patientDetailsViewModel.getFirstName().toLowerCase()+ patientDetailsViewModel.getMobileNo());
				
				if(patientDetailsViewModel.getDateOfVisit().equals("today")){
					SimpleDateFormat parseFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
	                Date date = parseFormat.parse(new Date().toString());
	                SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	                String formatedDate = format.format(date);
	                System.out.println("formatedDate: "+ formatedDate);
	                patientDetails.setDateOfVisit(formatedDate);
				}

				
				if(patientDetailsViewModel.getAge() >0){
					patientDetails.setAge(patientDetailsViewModel.getAge());
				}else{
					patientDetails.setDob(patientDetailsViewModel.getDob());
				}
				patientDetails.setGender(patientDetailsViewModel.getGender());
				patientDetails.setEmailId(patientDetailsViewModel.getEmailId());
				
				patientDetails.setStatus("new");
				patientDetails.setMailReport(patientDetailsViewModel.isMailReport());
				
				patientDetails.setVisitNo(1000);
				
	        	patientDetailsViewModel.setStatus("SUCCESS");
	        	patientDetailsViewModel.setReason("Patient Record Updated Successfully");
		        System.out.println("data is updated");
		        
				dbService.saveAndUpdateData(patientDetails);
				return gson.toJson(patientDetailsViewModel);
			}
	        
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	
	@RequestMapping(value = {"/patientDetails" }, method=RequestMethod.GET,produces={"application/json"})
	@ResponseBody
	public String fetchPatientDetails() {
		try{
			Gson gson = new Gson();
			
			PatientDetailsViewModel patientDetailsViewModel= new PatientDetailsViewModel();
			List<PatientDetails> patientsList = dbService.getTodaysPatients();
			if(patientsList.size() >0){
				patientDetailsViewModel.setStatus("SUCCESS");
				patientDetailsViewModel.setPatientsList(patientsList);
			}
	        
			return gson.toJson(patientDetailsViewModel);	
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}		

	@RequestMapping(value = {"/fillPatientRecord" }, method=RequestMethod.POST,produces={"application/json"})
	@ResponseBody
	public String fillPatientRecord(@RequestBody String jsonString) {
		try{
			System.out.println("patientDetailsViewModel fillPatientRecord JSON: " + jsonString);
			
			Gson gson = new Gson();
			PatientDetailsViewModel patientDetailsViewModel = gson.fromJson(jsonString, PatientDetailsViewModel.class);

			System.out.println("Patient id to be search : "+patientDetailsViewModel.getPatientId());
			
			PatientDetails patientDetails = dbService.getPatientByPatientId(patientDetailsViewModel.getPatientId());
			
			if (patientDetails != null) {
				System.out.println("Patientid found in db:"+ patientDetailsViewModel.getPatientId());
				patientDetailsViewModel.setStatus("SUCCESS");
	        	patientDetailsViewModel.setReason("Patient Found");
	        	List<PatientDetails> list = new ArrayList<PatientDetails>();	
	        	list.add(patientDetails);
		        patientDetailsViewModel.setPatientsList(list);
		        return gson.toJson(patientDetailsViewModel);	
			}
	        
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	
	@RequestMapping(value = {"/registerStaff" }, method=RequestMethod.POST,produces={"application/json"})
	@ResponseBody
	public String registerUser(@RequestBody String jsonString , HttpServletRequest httpServletRequest) {
		Gson gson = new Gson();
		RegisteredUserViewModel registeredUserViewModel = gson.fromJson(jsonString, RegisteredUserViewModel.class);
		try{
			logger.info("registerUser JSON: " + jsonString);
			User user = new User();
			
			user.setUsername(registeredUserViewModel.getEmailId());
			user.setEnabled(false);
			user.setPassword(registeredUserViewModel.getInputPassword());
			user.setCountryName(registeredUserViewModel.getCountryName());
			user.setState(registeredUserViewModel.getState());
			user.setDistt(registeredUserViewModel.getDistt());
			user.setDob(registeredUserViewModel.getDob());
			
			Set<Role> set = new HashSet<Role>();
			
			String roles = "";
			if(registeredUserViewModel.getRole().equals("")){
				roles="ROLE_NM";
			}
			if(registeredUserViewModel.getRole().equals("State")){
				roles="ROLE_SM";
			}
			if(registeredUserViewModel.getRole().equals("District")){
				roles="ROLE_DM";
			}
			if(registeredUserViewModel.getRole().equals("Team")){
				roles="ROLE_TM";
			}
			Role role = dbService.getRoleByName(roles);
			if(role !=null){
				set.add(role);
				user.setRole(set);	
			}
			
			user.setAddress(registeredUserViewModel.getAddress());
			user.setGender(registeredUserViewModel.getGender());
			
			String result = dbService.saveAndUpdateData(user);
			if(result.equals("SUCCESS")){
				registeredUserViewModel.setReason("SUCCESSFULLY REGISTERED, PLEASE WAIT TILL WE APPROVE YOUR REQUEST AND INFORM YOU");	
			}else{
				registeredUserViewModel.setReason(result);
			}
			registeredUserViewModel.setStatus(result);
			logger.info("successfully update single entry with email id: "+ registeredUserViewModel.getEmailId());
			return gson.toJson(registeredUserViewModel);
		}catch(Exception ex){
			ex.printStackTrace();
			registeredUserViewModel.setReason("Exception : "+ ex.getMessage());
			registeredUserViewModel.setStatus("Excption :"+ ex.getMessage());
			return gson.toJson(registeredUserViewModel);
		}
	}
	
	
	@RequestMapping(value = {"/registerStaff" }, method=RequestMethod.GET,produces={"application/json"})
	@ResponseBody
	public String loadUsers() {
		Gson gson = new Gson();
		RegisteredUserViewModel registeredUserViewModel = new RegisteredUserViewModel();
		try{
			List<User> set= dbService.getAllUsers();
			System.out.println("size: "+ set.size());
			if (set.size() ==0 || set == null) {
				registeredUserViewModel.setStatus("No User Found");
				return gson.toJson(registeredUserViewModel);	
			}else{
				registeredUserViewModel.setStatus("SUCCESS");
				registeredUserViewModel.setList(set);
				
		        return gson.toJson(registeredUserViewModel);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			registeredUserViewModel.setReason("Exception : "+ ex.getMessage());
			registeredUserViewModel.setStatus("Excption :"+ ex.getMessage());
			logger.error("exception in saveSingleEntry:- "+ ex.getMessage());
			return gson.toJson(registeredUserViewModel);
		}
	}

	@RequestMapping(value = {"/approveStaff" }, method=RequestMethod.POST,produces={"application/json"})
	@ResponseBody
	public String approveUser(@RequestBody String jsonString , HttpServletRequest httpServletRequest) {
		Gson gson = new Gson();
		RegisteredUserViewModel registeredUserViewModel = gson.fromJson(jsonString, RegisteredUserViewModel.class);
		try{
			logger.info("registerUser JSON: " + jsonString);
			User user = dbService.getUserByName(registeredUserViewModel.getEmailId());
			if(user!=null && !user.isEnabled()){
				user.setEnabled(true);
			}
			String result = dbService.saveAndUpdateData(user);
			if(result.equals("SUCCESS")){
				registeredUserViewModel.setReason("SUCCESSFULLY APPROVED");	
			}else{
				registeredUserViewModel.setReason("Unable to Approve");
			}
			registeredUserViewModel.setStatus(result);
			logger.info("successfully update single entry with email id: "+ registeredUserViewModel.getEmailId());
			
		}catch(Exception ex){
			ex.printStackTrace();
			registeredUserViewModel.setReason("Oops! User not approved");
			registeredUserViewModel.setStatus("Exception");
		}
		return gson.toJson(registeredUserViewModel);
	}
	
	@RequestMapping(value = {"/deactivateStaff" }, method=RequestMethod.POST,produces={"application/json"})
	@ResponseBody
	public String deactivateUser(@RequestBody String jsonString , HttpServletRequest httpServletRequest) {
		Gson gson = new Gson();
		RegisteredUserViewModel registeredUserViewModel = gson.fromJson(jsonString, RegisteredUserViewModel.class);
		try{
			logger.info("registerUser JSON: " + jsonString);
			User user = dbService.getUserByName(registeredUserViewModel.getEmailId());
			
			if(user!=null && user.isEnabled()){
				System.out.println("user is enabled trying to disable it");
				user.setEnabled(false);
			}
			
			String result = dbService.saveAndUpdateData(user);
			if(result.equals("SUCCESS")){
				registeredUserViewModel.setReason("SUCCESSFULLY DEACTIVATED");
				registeredUserViewModel.setStatus(result);
			}else{
				registeredUserViewModel.setReason("Unable to Deactivate");
				registeredUserViewModel.setStatus(result);
			}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
			registeredUserViewModel.setReason("Oops! User not deactivated");
			registeredUserViewModel.setStatus("Exception");
		}
		return gson.toJson(registeredUserViewModel);
	}
}