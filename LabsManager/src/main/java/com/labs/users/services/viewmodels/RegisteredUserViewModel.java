package com.labs.users.services.viewmodels;

import java.util.List;

import com.labs.users.model.User;

public class RegisteredUserViewModel extends BaseModel {

	private String fullName;
	private String fatherName;
	private String mobileNo;
	private String locateNo;
	private String twitterId;
	private String emailId;
	private String inputPassword;
	private String confirmPassword;
	private String countryName;
	private String state;
	private String distt;
	private String block;
	private String dob;
	private String role;
	private String 	address;
	private String 	gender;
	
	private List<User> list;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getLocateNo() {
		return locateNo;
	}
	public void setLocateNo(String locateNo) {
		this.locateNo = locateNo;
	}
	public String getTwitterId() {
		return twitterId;
	}
	public void setTwitterId(String twitterId) {
		this.twitterId = twitterId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getInputPassword() {
		return inputPassword;
	}
	public void setInputPassword(String inputPassword) {
		this.inputPassword = inputPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistt() {
		return distt;
	}
	public void setDistt(String distt) {
		this.distt = distt;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
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
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	
	
}
