package com.androidcommand.app.business.services;

import java.util.UUID;

public class  CompServletData {
	private String company;
	private String compcat;
	private String compaddr1;
	private String compaddr2;
	private String compstate;
	private String compcity;
	private String compzip;
	private String comppr;
	private Double complat;
	private Double complng; 
	private String comptext;
	private UUID   compUUID;

	public CompServletData() { System.out.println("CompServletData.java"); }

	public void   setCompany(String value) 			{ this.company = value; } 
	public void   setCompcat(String value) 			{ this.compcat = value; }  
	public void   setCompcity(String value) 		{ this.compcity = value; }  
	public void   setCompstate(String value) 		{ this.compstate = value; }  
	public void   setCompzip(String value) 			{ this.compzip = value; } 
	public void   setComppr(String value) 			{ this.comppr = value; }
	public void   setCompaddr1(String value) 		{ this.compaddr1 = value; }
	public void   setCompaddr2(String value) 		{ this.compaddr2 = value; }
	public void   setComplat(Double value) 			{ this.complat = value; }
	public void   setComplng(Double value) 			{ this.complng = value; }
	public void   setComptext(String value) 		{ this.comptext = value; } 
	public void   setCompUUID(UUID value) 			{ this.compUUID = value; } 

	public String getCompany()     					{ return company; }  
	public String getCompcat()     					{ return compcat; }  
	public String getCompaddr1()     				{ return compaddr1; }
	public String getCompaddr2()     				{ return compaddr2; }
	public String getCompstate()     				{ return compstate; }
	public String getCompcity()     				{ return compcity; }
	public String getCompzip()     					{ return compzip; }
	public String getComppr()     					{ return comppr; }
	public Double getComplat()     					{ return complat; }
	public Double getComplng()     					{ return complng; }
	public String getComptext()     				{ return comptext; }
	public UUID   getCompUUID()     				{ return compUUID; }
}


