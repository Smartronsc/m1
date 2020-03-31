package com.androidcommand.app.model;

import com.datastax.driver.core.PreparedStatement;

import com.androidcommand.app.model.CassandraData;
/**
 * Rant Copyright 2015, 2020 RichardBradleySmith.com
 */
public class SelectCompanyInformation extends CassandraData {
	private static PreparedStatement preparedCompanyInformation = null;
	protected SelectCompanyInformation() {}
	/**
	 * TABLE rant.companies
	 * @param selectCompanyInformation 
	 * @return preparedCompanyInformation this is done once
	 */ 
	public static PreparedStatement preparedCompanyInformation(String selectCompanyInformation) {
		System.out.println("selectCompanyInformation " + selectCompanyInformation);
		if (preparedCompanyInformation == null) { 
			preparedCompanyInformation = getSession().prepare(selectCompanyInformation); }
		return preparedCompanyInformation;	
	}
}