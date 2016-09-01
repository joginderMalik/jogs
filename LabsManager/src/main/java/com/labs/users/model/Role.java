package com.labs.users.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "role", catalog = "naseeb_db")
public class Role{

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="roleId")
	private Integer roleId;
	
	@Column(name = "role", nullable = false, length = 45)
	private String role;
	
	public Role() {
	}

	public Role(User user, String role) {
		this.role = role;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}