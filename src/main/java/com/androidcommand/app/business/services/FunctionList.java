package com.androidcommand.app.business.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.androidcommand.app.model.CompaniesDAO;

public class FunctionList implements Serializable {

	private static final long serialVersionUID = 1L;
	public ArrayList<String> company_functions;
	 
	private FunctionList() {
		System.out.println("Entry0010 FunctionList.java private constructor " );
	}
	 
	private static class FunctionListHolder {
	    public static final ArrayList<String> INSTANCE = new ArrayList<String>();
	}
	 
	public static ArrayList<String> getInstance(CompaniesDAO company) {
//		System.out.println("Entry0020 FunctionList.java getInstance() ");
//		System.out.println("Entry0030 FunctionList.java setFunctions() " );
		List<String> company_functionlist = Arrays.asList("Add", "Update", "Delete", "Find");
	    ArrayList<String> company_functions = new ArrayList<String>();
	    for(int i = 0; i < company_functionlist.size(); i++) {
//		   System.out.println("Entry0040 FunctionList.java setFunctions() " + company_functionlist.get(i).toString() );
	       company_functions.add(company_functionlist.get(i) );
	    }
//		System.out.println("Entry0045 FunctionList.java setFunctions() " + company_functions.toString());
	    company.setFunctions(company_functions);
	    return FunctionListHolder.INSTANCE;
	}
	
	protected Object readResolve() {
	    return getInstance(null);
	}
	
	public void setCompayfunctions(ArrayList<String> company_functions) {
//		System.out.println("Entry0050 FunctionList.java setCompanyfunctions() ");
		if (getCompayfunctions().isEmpty()) {  return; }
		this.company_functions = company_functions;
	}
	
	public ArrayList<String> getCompayfunctions() {
//		System.out.println("Entry0060 FunctionList.java getCompanyfunctions() ");
		return this.company_functions;
	}
}
