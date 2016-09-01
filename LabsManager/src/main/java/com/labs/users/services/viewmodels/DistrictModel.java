package com.labs.users.services.viewmodels;

import java.util.ArrayList;
import java.util.List;

import com.labs.users.model.District;

public class DistrictModel extends BaseModel {
	
	private List<District> districtList = new ArrayList<District>(0);
	
	private int stateId;

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public List<District> getDistrictList() {
		return districtList;
	}

	public void setDistrictList(List<District> districtList) {
		this.districtList = districtList;
	}
	
	
}
