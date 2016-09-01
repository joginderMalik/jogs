package com.labs.users.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user", catalog = "naseeb_db")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="userId")
	private int userId;
	
	@Column(name = "username", unique = true, nullable = false, length = 55)
	private String username;
	
	@Column(name = "password", nullable = false, length = 15)
	private String password;
	
	@Column(name = "enabled", nullable = false)
	private boolean enabled;
	
	@ManyToMany
	@JoinTable(name="user_role", joinColumns=@JoinColumn(name="userId"),inverseJoinColumns=@JoinColumn(name="roleId"))
	private Set<Role> role = new HashSet<Role>(0);

	@Column(name = "fullName", nullable = false, length = 45)
	private String fullName;
	
	@Column(name = "fatherName", nullable = false, length = 45)
	private String fatherName;
	
	@Column(name = "mobileNo", unique = true, nullable = false, length = 10)
	private String mobileNo;
	
	@Column(name = "countryName", nullable = false, length = 25)
	private String countryName;
	
	@Column(name = "state", nullable = false, length = 25)
	private String state;
	
	@Column(name = "district", nullable = false, length = 25)
	private String distt;
	
	@Column(name = "dob", nullable = false, length = 15)
	private String dob;
	
	@Column(name = "address", nullable = false, length = 140)
	private String 	address;
	
	@Column(name = "gender", nullable = false, length = 6)
	private String 	gender;
	
	
	public User() {
	}

	public User(String username, String password, boolean enabled) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String username, String password, 
		boolean enabled, Set<Role> userRole) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return this.enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRole() {
		return this.role;
	}

	public void setRole(Set<Role> role) {
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

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

	
}