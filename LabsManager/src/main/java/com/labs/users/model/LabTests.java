package com.labs.users.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lab_Tests", catalog = "naseeb_db")
public class LabTests {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="labTestId")
	private int labTestId;
	
	@Column(name = "labTestName", unique = true, nullable = false, length = 200)
	private String labTestName;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "labTestCode" , unique = true, nullable = false, length = 10)
	private String labTestCode;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="secondaryCategoryTestsId")
	private SecondaryCategoryTests secondaryCategoryTests;

	@Column(name = "testDescription", nullable = false, length = 200)
	private String testDescription;
	
	@Column(name = "testTat", nullable = false, length = 20)
	private String testTat;
	
	@Column(name = "testPrice", nullable = false, length = 5)
	private int testPrice;
	
	@Column(name = "enabled", nullable = false)
	private boolean enabled;
	
	@OneToMany(mappedBy = "labTests")
	private Set<PatientTests> patientTests;
	

	public int getLabTestId() {
		return labTestId;
	}

	public void setLabTestId(int labTestId) {
		this.labTestId = labTestId;
	}

	public String getLabTestName() {
		return labTestName;
	}

	public void setLabTestName(String labTestName) {
		this.labTestName = labTestName;
	}

	public SecondaryCategoryTests getSecondaryCategoryTests() {
		return secondaryCategoryTests;
	}

	public void setSecondaryCategoryTests(SecondaryCategoryTests secondaryCategoryTests) {
		this.secondaryCategoryTests = secondaryCategoryTests;
	}

	public String getTestDescription() {
		return testDescription;
	}

	public void setTestDescription(String testDescription) {
		this.testDescription = testDescription;
	}

	public String getTestTat() {
		return testTat;
	}

	public void setTestTat(String testTat) {
		this.testTat = testTat;
	}

	public int getTestPrice() {
		return testPrice;
	}

	public void setTestPrice(int testPrice) {
		this.testPrice = testPrice;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getLabTestCode() {
		return labTestCode;
	}

	public void setLabTestCode(String labTestCode) {
		this.labTestCode = labTestCode;
	}
}
