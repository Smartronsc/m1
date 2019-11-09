package com.androidcommand.app;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
/**
 * This is responsible for displaying the count of words in rant.word_count. 
 * 
 * Copyright 2019 RichardBradleySmith.com
 */
/* @WebServlet("/counts") */
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
/**
 * This do post is not in use
 */
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

