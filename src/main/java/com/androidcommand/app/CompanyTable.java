package com.androidcommand.app;

import java.io.Serializable;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Table("companyTable")
@Getter @Setter
@Configuration
@Data
public class CompanyTable implements Serializable {
	
	/*
	 * form-backing object 
	 */

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String companyTable_donothing; 
    public double companyTable_doublenothing;
    public int    companyTable_intnothing;
    public String companyTable_function;
    public String companyTable_name;
    public String companyTable_userid;
    private String companyTable_category;
    private String companyTable_first;
    private String companyTable_last;
    public String companyTable_city;
    public String companyTable_state;
    private String companyTable_zipcode;
    private String companyTable_phone;
    private String companyTable_email;
    private String companyTable_addr1c;
    private String companyTable_addr2c;
    private String companyTable_cityc;
    private String companyTable_statec; 
    private String companyTable_postalcode;
    private String companyTable_postaliso;
    private String companyTable_country;
    private String companyTable_phonec;
    private String companyTable_emailc;
    private String companyTable_websitec;
    private Double companyTable_latitudec;
    private Double companyTable_longitudec;
    private int companyTable_rantsc;
    private int companyTable_ravesc;
    private String companyTable_pr;
    private int companyTable_uuid;
    private String companyTable_text;   

	  public CompanyTable(		  
		  final String companyTable_name,	  
          final String companyTable_userid,
		  final String companyTable_category,
		  final String companyTable_first, 
		  final String companyTable_last,
	      final String companyTable_city,
	      final String companyTable_state,
	      final String companyTable_zipcode, 
	      final String companyTable_country,
	      final String companyTable_phone,
	      final String companyTable_email,
	      final String companyTable_addr1c,
	      final String companyTable_addr2c,
	      final String companyTable_cityc,
	      final String companyTable_statec, 
	      final String companyTable_postalcode,
	      final String companyTable_postalciso,
	      final String companyTable_phonec,
	      final String companyTable_emailc,
	      final String companyTable_websitec,
	      final double companyTable_latitudec,
	      final double companyTable_longitudec,
	      final int companyTable_rantsc,
	      final int companyTable_ravesc,
	      final String companyTable_pr,
	      final int companyTable_uuid,
	      final String companyTable_text) {  
	    this.companyTable_name = companyTable_name;
	    this.companyTable_userid = companyTable_userid;
	    this.companyTable_category = companyTable_category;
	    this.companyTable_first = companyTable_first;
	    this.companyTable_last = companyTable_last;
	    this.companyTable_city = companyTable_city;
	    this.companyTable_state = companyTable_state;
	    this.companyTable_zipcode = companyTable_zipcode;
	    this.companyTable_phone = companyTable_phone;
	    this.companyTable_email = companyTable_email;
	    this.companyTable_addr1c = companyTable_addr1c;
	    this.companyTable_addr2c = companyTable_addr2c;
	    this.companyTable_cityc = companyTable_cityc;
	    this.companyTable_statec = companyTable_statec;
	    this.companyTable_postalcode = companyTable_postalcode;
	    this.companyTable_postalcode = companyTable_postaliso;
	    this.companyTable_country = companyTable_country;
	    this.companyTable_phonec = companyTable_phonec;
	    this.companyTable_emailc = companyTable_emailc;
 	    this.companyTable_websitec = companyTable_websitec;
	    this.companyTable_latitudec = companyTable_latitudec;
	    this.companyTable_longitudec = companyTable_longitudec;
	    this.companyTable_rantsc = companyTable_rantsc;
	    this.companyTable_ravesc = companyTable_ravesc;
	    this.companyTable_pr = companyTable_pr;
	    this.companyTable_uuid = companyTable_uuid;
	    this.companyTable_text = companyTable_text;

	  }

	  public CompanyTable() { }
	  
	  public void DoNothing() {
		  this.companyTable_donothing = companyTable_category;
		  this.companyTable_donothing = companyTable_first;
		  this.companyTable_donothing = companyTable_last;
		  this.companyTable_donothing = companyTable_addr1c;
		  this.companyTable_donothing = companyTable_addr2c;
		  this.companyTable_donothing = companyTable_city;
		  this.companyTable_donothing = companyTable_state;
		  this.companyTable_donothing = companyTable_zipcode;
		  this.companyTable_donothing = companyTable_phone;
		  this.companyTable_donothing = companyTable_email;
		  this.companyTable_donothing = companyTable_cityc;
		  this.companyTable_donothing = companyTable_statec;
		  this.companyTable_donothing = companyTable_postalcode;
		  this.companyTable_donothing = companyTable_postaliso;
		  this.companyTable_donothing = companyTable_country;
		  this.companyTable_donothing = companyTable_phonec;
		  this.companyTable_donothing = companyTable_emailc;
		  this.companyTable_donothing = companyTable_websitec;
		  this.companyTable_doublenothing = companyTable_latitudec;
		  this.companyTable_doublenothing = companyTable_longitudec;
		  this.companyTable_intnothing = companyTable_rantsc;
		  this.companyTable_intnothing = companyTable_ravesc;
		  this.companyTable_donothing  = companyTable_pr;
		  this.companyTable_donothing  = companyTable_text;
		  this.companyTable_intnothing = companyTable_uuid;
		  
	  }
 
		public String getCompanytable_name() {
			System.out.println("Entry0100 CompanyTable.java companyTable_name() " + this.companyTable_name);
			return this.companyTable_name;
		}
	 
		public void setCompanytable_name(String companyTable_name) {
			System.out.println("Entry0110 CompanyTable.java companyTable_name() " + companyTable_name);
			this.companyTable_name = companyTable_name;
		}

		public String getCompanytable_city() {
			return this.companyTable_city;
		}
	 
		public void setCompanytable_city(String companyTable_city) {
			this.companyTable_city = companyTable_city;
		}

		public String getCompanytable_state() {
			return this.companyTable_state;
		}
	 
		public void setCompanytable_state(String string) {
			this.companyTable_state = string;
		}

}