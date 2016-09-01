package com.labs.users.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "primary_category_tests", catalog = "naseeb_db")
public class PrimaryCategoryTests {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="primaryCategoryTestsId")
	private int primaryCategoryTestsId;
	
	@Column(name = "primaryCategoryName", unique = true, nullable = false, length = 100)
	private String primaryCategoryName;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "primaryCategoryTestCode" , unique = true, nullable = false, length = 10)
	private String primaryCategoryTestCode;
	
	@OneToMany(mappedBy="primaryCategoryTests")
    private Set<SecondaryCategoryTests> secondaryCategoryTests;

	@Column(name = "primaryCategoryDescription", nullable = false, length = 200)
	private String primaryCategoryDescription;
	
	@Column(name = "primaryCategoryTat", nullable = false, length = 20)
	private String primaryCategoryTat;
	
	@Column(name = "primaryCategoryPrice", nullable = false, length = 5)
	private int primaryCategoryPrice;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;
	
	public int getPrimaryCategoryTestsId() {
		return primaryCategoryTestsId;
	}

	public void setPrimaryCategoryTestsId(int primaryCategoryTestsId) {
		this.primaryCategoryTestsId = primaryCategoryTestsId;
	}

	public String getPrimaryCategoryName() {
		return primaryCategoryName;
	}

	public void setPrimaryCategoryName(String primaryCategoryName) {
		this.primaryCategoryName = primaryCategoryName;
	}

	public String getPrimaryCategoryDescription() {
		return primaryCategoryDescription;
	}

	public void setPrimaryCategoryDescription(String primaryCategoryDescription) {
		this.primaryCategoryDescription = primaryCategoryDescription;
	}

	public String getPrimaryCategoryTat() {
		return primaryCategoryTat;
	}

	public void setPrimaryCategoryTat(String primaryCategoryTat) {
		this.primaryCategoryTat = primaryCategoryTat;
	}

	public int getPrimaryCategoryPrice() {
		return primaryCategoryPrice;
	}

	public void setPrimaryCategoryPrice(int primaryCategoryPrice) {
		this.primaryCategoryPrice = primaryCategoryPrice;
	}

	public Set<SecondaryCategoryTests> getSecondaryCategoryTests() {
		return secondaryCategoryTests;
	}

	public void setSecondaryCategoryTests(Set<SecondaryCategoryTests> secondaryCategoryTests) {
		this.secondaryCategoryTests = secondaryCategoryTests;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getPrimaryCategoryTestCode() {
		return primaryCategoryTestCode;
	}

	public void setPrimaryCategoryTestCode(String primaryCategoryTestCode) {
		this.primaryCategoryTestCode = primaryCategoryTestCode;
	}
	
}
