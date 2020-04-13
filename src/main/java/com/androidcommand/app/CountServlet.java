package com.androidcommand.app;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
/**
 * 
 * Copyright 2019, 2020 RichardBradleySmith.com
 */
@Controller
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    @RequestMapping(value = "/counts", method = RequestMethod.POST)
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("servlet " + request.getServletPath().toString() + " doGet in CountServlet.java");
	System.out.println("In CountServlet ");
    response.sendRedirect("home");
    return;
}

/**
 * This doGet is driven to display the count of words.
 * Calls CountDAO.wordCount() to read from SELECT * FROM rant.word_count;
 * Displays an array of wordCount objects containing word and count.
 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("servlet " + request.getServletPath().toString() + " doPost in CountServlet.java");
    getServletContext().getRequestDispatcher("/counts.jsp").forward(request,response);
  }
}

