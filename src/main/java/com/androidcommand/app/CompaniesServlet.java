package com.androidcommand.app;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import com.datastax.driver.core.querybuilder.QueryBuilder;
import com.datastax.driver.core.querybuilder.Select;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Rant Copyright 2020 RichardBradleySmith.com
 */
public class CompaniesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static Cluster cluster; 
	private static Session session; 

	/**
	 * 	
	 */
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet in CompServlet.java for " + request.getServletPath().toString());
//		List<CatDAO> catRantUUID = CatDAO.listCatRantUUID();
//		request.setAttribute("catRantUUID", catRantUUID);
//		getServletContext().getRequestDispatcher("/cat.jsp").forward(request,response);
		
		System.out.println("Attempting to start Cassandra");
		try { 
			 
			   cluster = Cluster.builder().withoutMetrics().addContactPoints(InetAddress.getByName("192.168.1.4") ).build(); 
			 
			   session = cluster.connect("rant"); 
			 
			   CassandraOperations cassandraOps = new CassandraTemplate(session); 
			 
			   cassandraOps.insert(new Companies("name1", "user", "category", "first", "last", "city", "state", "zipcode", "phone", "email",  
					   "addr1c", "adddr2c", "cityc", "statec", "zipcodec", "phonec", "emailc", "website", 0.0, 0.0, 
			           0, 0, "pr", 0, "text"));
			   Select s = QueryBuilder.select().from("Companies"); 
			   s.where(QueryBuilder.eq("company_company", "name1")); 
			 
//             LOG.info(cassandraOps.queryForObject(s, Companies.class).getId()); 
	           System.out.println(cassandraOps.selectOne(s, Companies.class).CompanyInformation());
	           getServletContext().getRequestDispatcher("/companies.jsp").forward(request,response);

	           cassandraOps.truncate(Companies.class);  // empties the table
			 
			  } catch (UnknownHostException e) { 
			   e.printStackTrace(); 
			  } 
			 
	  }
	  /**

	   */
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost in CompServlet.java for " + request.getServletPath().toString());
		 String company = request.getParameter("companyName");
	/*	 String infoArray = CompanyDAO.getCompanyInformation(company);  
		 request.setAttribute("infoArray", infoArray);*/
		 getServletContext().getRequestDispatcher("/companies.jsp").forward(request,response);    
	  }
}