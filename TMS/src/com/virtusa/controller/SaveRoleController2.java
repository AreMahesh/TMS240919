package com.virtusa.controller;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;




@WebServlet("/SaveRoleServlet2")
public class SaveRoleController2 extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 response.setContentType("text/html");
		 Logger log=Logger.getLogger(SaveRoleController2.class);
		 PropertyConfigurator.configure("F:\\sw\\eclipse-jee-neon-3-win32\\eclipse\\kalyani\\TMS2\\src\\log4j.properties");
			log.debug("Sample debug message");
			log.info("Sample info message");
			log.warn("Sample warn message");
			log.error("Sample error message");
			log.fatal("Sample fatal message");
		 try {
		    PrintWriter pw = response.getWriter();  
		          
		    pw.println("role Inserted Successfully");
		 }catch(Exception e) {
			log.error(e);
			
		 }
	}

}
