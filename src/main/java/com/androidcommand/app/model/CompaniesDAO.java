package com.androidcommand.app.model;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;

import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.ColumnDefinitions;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

import lombok.Data;
import com.androidcommand.app.model.SelectCompanyInformation;

import com.androidcommand.app.model.CassandraData;

@Table("companies")
@Data
@Configuration
public class CompaniesDAO extends CassandraData {
  	private static final long serialVersionUID = 1L;
    private static Cluster cluster; 
	private static Session session; 
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
				   cluster = Cluster.builder().withoutJMXReporting().addContactPoints(InetAddress.getByName("192.168.1.5") ).build(); 
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
	    


		@Bean
	    public void insertCompany() {
	    	System.out.println("CompaniesDAO.java for insertCompany");
			try { 		
			   cluster = Cluster.builder().withoutJMXReporting().addContactPoints(InetAddress.getByName("192.168.1.5") ).build(); 
			   session = cluster.connect("rant"); 
			   PreparedStatement preparedStatement = session.prepare("insert into companies (company_country, company_name) values (?, ?)");
//			   BoundStatement boundStatement = preparedStatement.bind("United States", randomUUID());
			   BoundStatement boundStatement = preparedStatement.bind("United States", "Acme"); 
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
	    	System.out.println("Entry0030 CompaniesDAO.java for selectCompany");
//			try { 		
//			   cluster = Cluster.builder().withoutJMXReporting().addContactPoints(InetAddress.getByName("192.168.1.5") ).build(); 
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
			System.out.println("In CompaniesDAO.java getCompany() " + this.company_name);
			return this.company_name;
		}
	 
		public void setCompany(String company_name) {
			System.out.println("In CompaniesDAO.java setCompany() " + company_name);
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
		
		public String CompanyInformation() {
			   System.out.println("In CompaniesDAO.java CompanyInformation() " + this.company_userid);
			   return this.company_userid;
			} 
	}