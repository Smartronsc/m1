package com.androidcommand.app;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Rant Copyright 2020 RichardBradleySmith.com
 */
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 	
	 */
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet in CompServlet.java for " + request.getServletPath().toString());

		
		System.out.println("In EmployeeServlet");
		 
	  }
	  /**

	   */
	  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost in CompServlet.java for " + request.getServletPath().toString());
		 String company = request.getParameter("companyName");
	/*	 String infoArray = CompanyDAO.getCompanyInformation(company);  
		 request.setAttribute("infoArray", infoArray);*/
		 getServletContext().getRequestDispatcher("/employee.jsp").forward(request,response);    
	  }
}