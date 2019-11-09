package com.androidcommand.app;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

import org.apache.logging.log4j.Logger;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

@SpringBootApplication
public class SpringRbsApplication {
	
//	 private static final Logger LOG = LoggerFactory. getLogger(CassandraApp.class); 
	 
	 private static Cluster cluster; 
	 private static Session session; 

	public static void main(String[] args) {
//		SpringApplication.run(SpringRbsApplication.class, args);
		
		
		try { 
			 
			   cluster = Cluster.builder().withoutMetrics().addContactPoints(InetAddress.getByName("192.168.1.5") ).build(); 
			 
			   session = cluster.connect("rant"); 
			 
			   CassandraOperations cassandraOps = new CassandraTemplate(session); 
			 
			   cassandraOps.insert(new Companies("name", "user", "category", "first", "last", "city", "state", "zipcode", "phone", "email",  
					   "addr1c", "adddr2c", "cityc", "statec", "zipcodec", "phonec", "emailc", "website", 0.0, 0.0, 
			           0, 0, "pr", 0, "text"));
			   Select s = QueryBuilder.select().from("company_company"); 
			   s.where(QueryBuilder.eq("company_name", "test")); 
			 
//			   LOG.info(cassandraOps.queryForObject(s, Person.class).getId()); 
			 
//			   cassandraOps.truncate("person"); 
			 
			  } catch (UnknownHostException e) { 
			   e.printStackTrace(); 
			  } 
			 
			 } 
	}


