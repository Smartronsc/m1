package com.androidcommand.app;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.data.annotation.Transient;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table("companies")
@Getter @Setter
public class Companies {

  @PrimaryKeyColumn(name = "company_company", type = PrimaryKeyType.PARTITIONED)
  private String company_company;
  private String company_userid;
  private String company_category;
  private String company_first;
  private String company_last;
  private String company_city;
  private String company_state;
  private String company_zipcode;
  private String company_phone;
  private String company_email;
  private String company_addr1c;
  private String company_addr2c;
  private String company_cityc;
  private String company_statec; 
  private String company_zipcodec;
  private String company_phonec;
  private String company_emailc;
  private String company_websitec;
  private Double company_latitudec;
  private Double company_longitudec;
  private int company_rantsc;
  private int company_ravesc;
  private String company_pr;
  private int company_uuid;
  private String company_text;   

	  public Companies(
		  final String company_company,	  
          final String company_userid,
		  final String company_category,
		  final String company_first, 
		  final String company_last,
	      final String company_city,
	      final String company_state,
	      final String company_zipcode, 
	      final String company_phone,
	      final String company_email,
	      final String company_addr1c,
	      final String company_addr2c,
	      final String company_cityc,
	      final String company_statec, 
	      final String company_zipcodec,
	      final String company_phonec,
	      final String company_emailc,
	      final String company_websitec,
	      final double company_latitudec,
	      final double company_longitudec,
	      final int rantsc,
	      final int ravesc,
	      final String company_pr,
	      final int company_uuid,
	      final String company_text) {  
	    this.company_company = company_company;
	    this.company_userid = company_userid;
	    this.company_category = company_category;
	    this.company_first = company_first;
	    this.company_last = company_last;
	    this.company_city = company_city;
	    this.company_state = company_state;
	    this.company_zipcode = company_zipcode;
	    this.company_phone = company_phone;
	    this.company_email = company_email;
	    this.company_addr1c = company_addr1c;
	    this.company_addr2c = company_addr2c;
	    this.company_cityc = company_cityc;
	    this.company_statec = company_statec;
	    this.company_zipcodec = company_zipcodec;
	    this.company_phonec = company_phonec;
	    this.company_emailc = company_emailc;
	    this.company_websitec = company_websitec;
	    this.company_latitudec = company_latitudec;
	    this.company_longitudec = company_longitudec;
	    this.company_rantsc = rantsc;
	    this.company_ravesc = ravesc;
	    this.company_pr = company_pr;
	    this.company_uuid = company_uuid;
	    this.company_text = company_text;

	  }

	  public Companies() {}

	  // getters and setters
	}