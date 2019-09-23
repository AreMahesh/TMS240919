package com.virtusa.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


@WebServlet("/logOutServlet")
public class LogOutServlet extends HttpServlet {
	public LogOutServlet() {
        super();
    
    }
 @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		request.getSession().invalidate();
		Logger log=Logger.getLogger(SaveRoleController.class);
		PropertyConfigurator.configure("F:\\sw\\eclipse-jee-neon-3-win32\\eclipse\\kalyani\\TMS2\\src\\log4j.properties");
		log.debug("Sample debug message");
		log.info("Sample info message");
		log.warn("Sample warn message");
		log.error("Sample error message");
		log.fatal("Sample fatal message");
	            try {
			RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
			rd.forward(request,response);
		
	   }catch(Exception e) {
		   log.error(e);
	   }
  }
}
