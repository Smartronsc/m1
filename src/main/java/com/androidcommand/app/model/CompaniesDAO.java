package com.androidcommand.app.model;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;

import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;

import lombok.Data;

import com.androidcommand.app.model.CassandraData;

@Table("companies")
@Data
@Configuration
public class CompaniesDAO extends CassandraData {
// 	private static final long serialVersionUID = 1L;
    private static Cluster cluster; 
	private static Session session; 
    private List<String> company_functionlist;
    public  ArrayList<String> functions;
//	private CassandraOperations cassandraOps;


    @PrimaryKeyColumn(name = "company_name", type = PrimaryKeyType.PARTITIONED)
    private String company_name;
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
    private String company_country;
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

	  public CompaniesDAO(	  
		  final String company_name,	  
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
	      final String company_country,
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
	    this.company_name = company_name;
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
	    this.company_country = company_country;
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

	  public CompaniesDAO() {}
	  
	    @Bean
	    public void initCassandra() {
	    	System.out.println("In CompaniesDAO.java for initCassandra");
			try { 
				   cluster = Cluster.builder().withoutJMXReporting().addContactPoints(InetAddress.getByName("192.168.1.4") ).build(); 
				   session = cluster.connect("rant"); 
				   
//				   PreparedStatement preparedStatement = session.prepare("insert into companies (company_country, company_name) values (?, ?)");
//				   BoundStatement boundStatement = preparedStatement.bind("United States", "Acme"); 
						
//				   CassandraOperations cassandraOps = new CassandraTemplate(session); 
/*				 
				   cassandraOps.insert(new CompaniesDAO("name1", "user", "category", "first", "last", "city", "state", "zipcode", "phone", "email",  
						   "addr1c", "adddr2c", "cityc", "statec", "zipcodec", "phonec", "emailc", "website", 0.0, 0.0, 
				           0, 0, "pr", 0, "text"));
				   Select s = QueryBuilder.select().from("Companies");
  				   s.where(QueryBuilder.eq("company_name", "name1")); 
				   LOGGER.info(cassandraOps.selectOne(Query.query(Criteria.where("id").is(jonDoe.getId())), Person.class).getId());
*/				 
//		           System.out.println("In CompaniesDAO.java for Cassandra information: " + cassandraOps.selectOne(s, CompaniesDAO.class).CompanyInformation()); 

//		           cassandraOps.truncate(CompaniesDAO.class);  // empties the table
		           
		           session.close();
		           cluster.close();
				 
				  } catch (UnknownHostException e) { 
				   e.printStackTrace(); 
				  }
			
				
			return;
	    }    
	    

	    public void insertCompany(String company_name) {
	    	System.out.println("Entry0070 CompaniesDAO.java for insertCompany");
			try { 		
			   cluster = Cluster.builder().withoutJMXReporting().addContactPoints(InetAddress.getByName("192.168.1.4") ).build(); 
			   session = cluster.connect("rant"); 
			   PreparedStatement preparedStatement = session.prepare("insert into companies (company_country, company_name) values (?, ?)");
//			   BoundStatement boundStatement = preparedStatement.bind("United States", randomUUID());
			   BoundStatement boundStatement = preparedStatement.bind("United States", company_name);
			   session.execute(boundStatement);
	           session.close();
	           cluster.close();
			  } catch (UnknownHostException e) { 
				   e.printStackTrace(); 
				  }
			return;
	    }
		
		@Bean
	    public void selectCompany() {
			String companyName = "None"; 
	    	System.out.println("Entry0020 CompaniesDAO.java for selectCompany");
//			try { 		
//			   cluster = Cluster.builder().withoutJMXReporting().addContactPoints(InetAddress.getByName("192.168.1.4") ).build(); 
//			   session = cluster.connect("rant"); 
//			   final String query = "select * from companies where company_country = " + company_country;
//			   final String query = "select * from companies";
//			   ResultSet results = CassandraData.getSession().execute(query);
			   PreparedStatement preparedStatement = CassandraData.getSession().prepare("select * from companies where company_country = ?");
			   BoundStatement boundStatement = preparedStatement.bind("United States"); 
			   CassandraData.getSession().execute(boundStatement);
			   ResultSet results = CassandraData.getSession().execute(boundStatement);

//	    	   company_country = "United States";
//			   String selectCompanyInformation = "SELECT * FROM companies WHERE company_country = ?";
//			   PreparedStatement preparedCompanyInformation = SelectCompanyInformation.preparedCompanyInformation(selectCompanyInformation);
//			   BoundStatement boundCompanyInformation = preparedCompanyInformation.bind(company_country);
//			   ResultSet results = CassandraData.getSession().execute(boundCompanyInformation);

//			   String selectCompanyInformation = "SELECT * FROM companies";
//			   ResultSet results = CassandraData.getSession().execute(selectCompanyInformation);
			   for(Row row : results) {
				   companyName = row.getString("company_name");
				   System.out.println("Entry0040 CompanesDAO.java " + companyName);
				   setCompany(companyName);
			   } 
//	           session.close();
//	           cluster.close();
//			  } catch (UnknownHostException e) { 
//				   e.printStackTrace(); 
//				  }
			return;
	    }
		

	    
		public String getCompany() {
//			System.out.println("Entry0030 CompaniesDAO.java getCompany() " + this.company_name);
			return this.company_name;
		}
	 
		public void setCompany(String company_name) {
//			System.out.println("Entry0040 CompaniesDAO.java setCompany() " + company_name);
			this.company_name = company_name;
		}
		
		public String getUserid() {
			System.out.println("In CompaniesDAO.java getUserid() " + this.company_userid);
			return this.company_userid;
		}

		public void setUserid(String company_userid) {
			System.out.println("In CompaniesDAO.java setCompany() " + company_userid);
			this.company_userid = company_userid;
		}
		
		public void setCategory(String company_catagory) {
			System.out.println("In CompaniesDAO.java setCompany() " + company_catagory);
			this.company_category = company_catagory;
		}
		
		public String getCategory() {
			System.out.println("In CompaniesDAO.java getCatagory() " + this.company_category);
			return this.company_category;
		}

		public void setFirst(String company_first) {
			System.out.println("In CompaniesDAO.java setFirst() " + company_first);
			this.company_category = company_first;
		}
		
		public String getFirst() {
			System.out.println("In CompaniesDAO.java getFirst() " + this.company_first);
			return this.company_first;
		}

		public void setLast(String company_last) {
			System.out.println("In CompaniesDAO.java setLast() " + company_last);
			this.company_category = company_last;
		}
		
		public String getLast() {
			System.out.println("In CompaniesDAO.java getLast() " + this.company_last);
			return this.company_last;
		}

		public void setCity(String company_city) {
			System.out.println("In CompaniesDAO.java setCity() " + company_city);
			this.company_city = company_city;
		}
		
		public String getCity() {
			System.out.println("In CompaniesDAO.java getCity() " + this.company_city);
			return this.company_city;
		}

		public void setState(String company_state) {
			System.out.println("In CompaniesDAO.java setState() " + company_state);
			this.company_state = company_state;
		}
		
		public String getState() {
			System.out.println("In CompaniesDAO.java getState() " + this.company_state);
			return this.company_state;
		}
		
		public void setZipcode(String company_zipcode) {
			System.out.println("In CompaniesDAO.java setZipcode() " + company_zipcode);
			this.company_zipcode = company_zipcode;
		}
		
		public String getZipcode() {
			System.out.println("In CompaniesDAO.java getZipcode() " + this.company_zipcode);
			return this.company_zipcode;
		}
		
		public void setPhone(String company_phone) {
			this.company_phone = company_phone;
		}
		
		public String getPhone() {
			return this.company_phone;
		}
		
		public void setEmail(String company_email) {
			this.company_email = company_email;
		}
		
		public String getEmail() {
			return this.company_email;
		}
		
		public void setAddr1c(String company_addr1c) {
			this.company_addr1c = company_addr1c;
		}
		
		public String getAddr1c() {
			return this.company_addr1c;
		}
		
		public void setAddr2c(String company_addr2c) {
			this.company_addr2c = company_addr2c;
		}
		
		public String getAddr2c() {
			return this.company_addr2c;
		}
		
		public void setCityc(String company_cityc) {
			this.company_cityc = company_cityc;
		}
		
		public String getCityc() {
			return this.company_cityc;
		}
		
		public void setStatec(String company_statec) {
			this.company_statec = company_statec;
		}
		
		public String getStatec() {
			return this.company_statec;
		}
		
		public void setZipcodec(String company_zipcodec) {
			this.company_zipcodec = company_zipcodec;
		}
		
		public String getZipcodec() {
			return this.company_zipcodec;
		}
		
		public void setEmailc(String company_emailc) {
			this.company_emailc = company_emailc;
		}
		
		public String getEmailc() {
			return this.company_emailc;
		}
		
		public void setLatitudec(Double company_latitudec) {
			this.company_latitudec = company_latitudec;
		}
		
		public Double getLatitudec() {
			return this.company_latitudec;
		}
		
		public Double getLongitudec() {
			return this.company_longitudec;
		}
		
		public void setLongitudec(Double company_longitudec) {
			this.company_longitudec = company_longitudec;
		}
		
		public void setPhonec(String company_phonec) {
			this.company_phonec = company_phonec;
		}
		
		public String getPhonec() {
			return this.company_phonec;
		}
		
		public void setPr(String company_pr) {
			this.company_pr = company_pr;
		}
		
		public String getPr() {
			return this.company_pr;
		}
		
		public void setRant(int company_rantsc) {
			this.company_rantsc = company_rantsc;
		}
		
		public int getRantsc() {
			return this.company_rantsc;
		}
		
		public void setRave(int company_ravesc) {
			this.company_ravesc = company_ravesc;
		}
		
		public int getRavesc() {
			return this.company_ravesc;
		}
		
		public void setUuid(int company_uuid) {
			this.company_uuid = company_uuid;
		}
		
		public int getUUid() {
			return this.company_uuid;
		}
		
		public void company_text(String company_text) {
			this.company_text = company_text;
		}
		
		public String getText() {
			return this.company_text;
		}
		
		public String getCountry() {
			System.out.println("In CompaniesDAO.java getCountry() " + this.company_country);
			return this.company_country;
		}
		public void setCountry(String company_country) {
			System.out.println("In CompaniesDAO.java setCountry() " + company_country);
			this.company_websitec = company_country;
		}
		
		public String getWebsite() {
			System.out.println("In CompaniesDAO.java getWebsite() " + this.company_websitec);
			return this.company_websitec;
		}
		
		public void setWebsite(String company_websitec) {
			System.out.println("In CompaniesDAO.java setWebsite() " + company_websitec);
			this.company_websitec = company_websitec;
		}
		
		public static UUID randomUUID() {
			   System.out.println("In CompaniesDAO.java setUUID() ");
			return UUID.randomUUID();
			} 
		
		public List<String> getFunctionlist() {
//			   System.out.println("Entry0005 CompaniesDAO.java getFunctionlist) ");
			   return this.company_functionlist;
			} 
		
		public ArrayList<String> getFunctions() {
//			System.out.println("Entry0060 CompaniesDAO.java getFuctions() " + this.functions.toString() );
			return this.functions;
		} 

		public void setFunctions(ArrayList<String> functions) {
//			System.out.println("Entry0010 CompaniesDAO.java setFunctions() entry ");
//			System.out.println("Entry0010 CompaniesDAO.java setFunctions() " + functions.toString()  );
//		    System.out.println("Entry0010 CompaniesDAO.java setFunctions() " + functions.size()); 
			if (functions.isEmpty()) {  System.out.println("Entry0010 CompaniesDAO.java setFunctions() empty "); return; }
//			System.out.println("Entry0010 CompaniesDAO.java setFunctions()1 " + functions.toString()  );
			this.functions = functions;
		}
		
		public String CompanyInformation() {
		    System.out.println("In CompaniesDAO.java CompanyInformation() " + this.company_userid);
		    return this.company_userid;
		} 

		
	}



