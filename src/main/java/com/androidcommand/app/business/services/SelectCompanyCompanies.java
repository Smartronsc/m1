package com.androidcommand.app.business.services;
import com.androidcommand.app.model.CassandraData;
import com.datastax.driver.core.PreparedStatement;
/**
 * Copyright 2020 RichardBradleySmith.com
 */
public class SelectCompanyCompanies extends CassandraData {
	private static PreparedStatement preparedCompanyCompanies = null;
	protected SelectCompanyCompanies() {}
	/**
	 * TABLE rant.companies 
	 * @param selectCompanyCompanines 
	 * @return preparedCompanyCompanies this is done once
	 */ 
	public static PreparedStatement preparedCompanyCompanies(String selectCompanyCompanies) {
		if (preparedCompanyCompanies == null) { 
			preparedCompanyCompanies = getSession().prepare(selectCompanyCompanies); }
		return preparedCompanyCompanies;	
	}
}

