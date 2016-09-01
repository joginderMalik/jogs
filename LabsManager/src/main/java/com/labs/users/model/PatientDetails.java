package com.labs.users.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "patient_details", catalog = "naseeb_db")
public class PatientDetails {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="patientId")
	private int patientId;
	
	@Column(name = "firstName", nullable = false, length = 45)
	private String firstName;
	
	@Column(name = "lastName", nullable = false, length = 45)
	private String lastName;
	
	@Column(name = "patientLoginId", unique = true, nullable = false, length = 45)
	private String patientLoginId;
	
	@Column(name = "password", nullable = false, length = 60)
	private String password;
	
	@Column(name = "emailId", unique = true, length = 60)
	private String emailId;
	
	@Column(name = "mobileNo", length = 10)
	private Integer mobileNo;
	
	@Column(name = "dob")
	private String dob;
	
	@Column(name = "age")
	private int age;
	
	@Column(name= "address" , nullable = false, length=100)
	private String address;
	
	@Column(name ="gender" , length =5)
	private String gender;

	@OneToMany(mappedBy="patientDetails", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<PatientTests> patientTests;

	@Column(name = "visitNo" , nullable = false, length=5)
	private int visitNo;
	
	@Column(name = "mailReport")
	private boolean mailReport;
	
	@Column(name = "dateOfVisit")
	private String dateOfVisit;
	
	@Column(name = "status", nullable = false, length=5)
	private String status;
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
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

	public int getVisitNo() {
		return visitNo;
	}

	public void setVisitNo(int visitNo) {
		this.visitNo = visitNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<PatientTests> getPatientTests() {
		return patientTests;
	}

	public void setPatientTests(Set<PatientTests> patientTests) {
		this.patientTests = patientTests;
	}

	
	public String getDateOfVisit() {
		return dateOfVisit;
	}

	public void setDateOfVisit(String dateOfVisit) {
		this.dateOfVisit = dateOfVisit;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientLoginId() {
		return patientLoginId;
	}

	public void setPatientLoginId(String patientLoginId) {
		this.patientLoginId = patientLoginId;
	}

	public boolean isMailReport() {
		return mailReport;
	}

	public void setMailReport(boolean mailReport) {
		this.mailReport = mailReport;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Integer mobileNo) {
		this.mobileNo = mobileNo;
	}
	
	
}
