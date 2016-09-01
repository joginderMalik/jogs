package com.labs.users.services.viewmodels;

import java.util.ArrayList;
import java.util.List;

import com.labs.users.model.Country;

public class CountryModel extends BaseModel {

	private List<Country> countryList = new ArrayList<Country>();

	public List<Country> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}

		
}
