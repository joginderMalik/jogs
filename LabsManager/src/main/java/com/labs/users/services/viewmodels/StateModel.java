package com.labs.users.services.viewmodels;

import java.util.ArrayList;
import java.util.List;

import com.labs.users.model.State;

public class StateModel extends BaseModel {

	private List<State> stateList = new ArrayList<State>(0);
	
	private int countryId;

	public List<State> getStateList() {
		return stateList;
	}

	public void setStateList(List<State> stateList) {
		this.stateList = stateList;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	
	
	
}
