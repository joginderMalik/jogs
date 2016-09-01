package com.labs.users.services.viewmodels;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.labs.users.model.LabTests;
import com.labs.users.model.PatientDetails;

public class PatientDetailsViewModel extends BaseModel {

	private String firstName;
	
	private String lastName;
	
	private int patientId;
	
	private String emailId;
	
	private double mobileNo;
	
	private String dob;
	
	private int age;
	
	private String address;
	
	private String gender;

	private List<PatientDetails> patientsList = new ArrayList<PatientDetails>(0);
	
	private Set<LabTests> labTests = new HashSet<LabTests>(0);
	
	private String param;
	
	private String dateOfVisit;

	private boolean mailReport;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Set<LabTests> getLabTests() {
		return labTests;
	}

	public void setLabTests(Set<LabTests> labTests) {
		this.labTests = labTests;
	}

	public List<PatientDetails> getPatientsList() {
		return patientsList;
	}

	public void setPatientsList(List<PatientDetails> patientsList) {
		this.patientsList = patientsList;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public double getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(double mobileNo) {
		this.mobileNo = mobileNo;
	}

	public boolean isMailReport() {
		return mailReport;
	}

	public void setMailReport(boolean mailReport) {
		this.mailReport = mailReport;
	}

	
}
