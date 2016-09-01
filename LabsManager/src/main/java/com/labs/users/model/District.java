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
@Table(name = "district", catalog = "naseeb_db")
public class District {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name ="districtId")
	private int districtId;
	
	@Column(name = "districtName", unique = true, nullable = false, length = 100)
	private String districtName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "stateId")
	private State state;
	
	/*@OneToMany(mappedBy="district")
    private Set<Block> block ;
*/
	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	/*public Set<Block> getBlock() {
		return block;
	}

	public void setBlock(Set<Block> block) {
		this.block = block;
	}
	*/
	
	
	
}
