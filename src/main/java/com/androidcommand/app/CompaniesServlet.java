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
 * Rant Copyright 2015 RichardBradleySmith.com
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
	  /**
	   * Java Servlet Pages /company.jsp posts this to get the company to present
	   * This uses CompanyDAO to pull the data from rant.companyinformation and format it in infoArray. 
	   * Then company.jsp parses it to build the infoWindow markers.
	   * web.xml is what defines /company to the server.
	   * 
	   * It is important to note here that by design Rant now has an index.jsp.
	   * index.jsp simply forwards on to home.jsp.
	   * home.jsp initiates the Cross Origin Resource Sharing (CORS) so Rant is allowed to work with the Google Maps API.
	   * 
	   * As of 6/6/2016 home.jsp formats the company data as the color map for the Rant home page.
	   * 				company.jsp formats the company data as the Rant icons for the Google Map API.
	   */
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost in CompServlet.java for " + request.getServletPath().toString());
		 String company = request.getParameter("companyName");
	/*	 String infoArray = CompanyDAO.getCompanyInformation(company);  
		 request.setAttribute("infoArray", infoArray);*/
		 getServletContext().getRequestDispatcher("/company.jsp").forward(request,response);    
	  }
}