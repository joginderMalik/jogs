package com.labs.users.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "state", catalog = "naseeb_db")
public class State {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="stateId")
	private int stateId;
	
	@Column(name = "stateName", unique = true, nullable = false, length = 100)
	private String stateName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "countryId")
	private Country country;
	
	/*@OneToMany(mappedBy="state")
    private Set<District> district ;*/

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	/*public Set<District> getDistrict() {
		return district;
	}

	public void setDistrict(Set<District> district) {
		this.district = district;
	}
*/	
	
	
}
