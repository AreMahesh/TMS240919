package com.virtusa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/saveVenueServlet2")
public class SaveVenueController2 extends HttpServlet {
	@Override
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");  
		    PrintWriter pw = response.getWriter();  
		          
		    pw.println("venue details Inserted Successfully"); 
	}

}
