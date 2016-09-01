package com.labs.users.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "patient_tests", catalog = "naseeb_db")
public class PatientTests {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="id")
	private int id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patientId")
	private PatientDetails patientDetails;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "labTestId")
	private LabTests labTests;
	
	 @Column(name = "registeredDate")
	 @Temporal(TemporalType.DATE)
	 private Date registeredDate;
}
