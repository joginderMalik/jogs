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
@Table(name = "secondary_category_tests", catalog = "naseeb_db")
public class SecondaryCategoryTests {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="secondaryCategoryTestsId")
	private int secondaryCategoryTestsId;
	
	@Column(name = "secondaryCategoryName", unique = true, nullable = false, length = 100)
	private String secondaryCategoryName;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "secondaryCategoryTestCode" , unique = true, nullable = false, length = 10)
	private String secondaryCategoryTestCode;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "primaryCategoryTestsId")
	private PrimaryCategoryTests primaryCategoryTests;
	
	@OneToMany(mappedBy = "secondaryCategoryTests")
	private Set<LabTests> labTests;

	@Column(name = "secondaryCategoryDescription", nullable = false, length = 200)
	private String secondaryCategoryDescription;
	
	@Column(name = "secondaryCategoryTat", nullable = false, length = 20)
	private String secondaryCategoryTat;
	
	@Column(name = "secondaryCategoryPrice", nullable = false, length = 5)
	private int secondaryCategoryPrice;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;

	
	public int getSecondaryCategoryTestsId() {
		return secondaryCategoryTestsId;
	}

	public void setSecondaryCategoryTestsId(int secondaryCategoryTestsId) {
		this.secondaryCategoryTestsId = secondaryCategoryTestsId;
	}

	public String getSecondaryCategoryName() {
		return secondaryCategoryName;
	}

	public void setSecondaryCategoryName(String secondaryCategoryName) {
		this.secondaryCategoryName = secondaryCategoryName;
	}

	public PrimaryCategoryTests getPrimaryCategoryTests() {
		return primaryCategoryTests;
	}

	public void setPrimaryCategoryTests(PrimaryCategoryTests primaryCategoryTests) {
		this.primaryCategoryTests = primaryCategoryTests;
	}

	public String getSecondaryCategoryDescription() {
		return secondaryCategoryDescription;
	}

	public void setSecondaryCategoryDescription(String secondaryCategoryDescription) {
		this.secondaryCategoryDescription = secondaryCategoryDescription;
	}

	public String getSecondaryCategoryTat() {
		return secondaryCategoryTat;
	}

	public void setSecondaryCategoryTat(String secondaryCategoryTat) {
		this.secondaryCategoryTat = secondaryCategoryTat;
	}

	public int getSecondaryCategoryPrice() {
		return secondaryCategoryPrice;
	}

	public void setSecondaryCategoryPrice(int secondaryCategoryPrice) {
		this.secondaryCategoryPrice = secondaryCategoryPrice;
	}

	public Set<LabTests> getLabTests() {
		return labTests;
	}

	public void setLabTests(Set<LabTests> labTests) {
		this.labTests = labTests;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getSecondaryCategoryTestCode() {
		return secondaryCategoryTestCode;
	}

	public void setSecondaryCategoryTestCode(String secondaryCategoryTestCode) {
		this.secondaryCategoryTestCode = secondaryCategoryTestCode;
	}
	
}
