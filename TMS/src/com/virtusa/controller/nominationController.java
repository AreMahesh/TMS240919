package com.virtusa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.virtusa.bean.RoleBean;
import com.virtusa.bean.TrainingBean;
import com.virtusa.bo.SaveNominationBo;
import com.virtusa.dao.TrainingRoleMappingDao;


@WebServlet("/nominationServlet")
public class nominationController extends HttpServlet {

		@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");

		
		  List<RoleBean> rb=null;
		  List<TrainingBean> tb=null;
		     String fname=request.getParameter("fname");
		     String lname=request.getParameter("lname");
		     String trainingId=request.getParameter("trainingIdFinal");
		     String applyDate=request.getParameter("applyDate");
		    
	     rb=TrainingRoleMappingDao.getAllRoles();
	     request.setAttribute("roleList", rb);
	     String s1=request.getParameter("roleIdFinal");
	     if(s1!=null) {
	    	
	    tb=SaveNominationBo.getTrainingsBasedOnRoleId(s1);
	          request.setAttribute("trainingList", tb);
	      
	       }
	    
	    
	    if(fname != null && lname != null && trainingId != null && applyDate!=null ) {
	    	 Logger log=Logger.getLogger(nominationController.class);
	    	 PropertyConfigurator.configure("F:\\sw\\eclipse-jee-neon-3-win32\\eclipse\\kalyani\\TMS2\\src\\log4j.properties");
	 		log.debug("Sample debug message");
	 		log.info("Sample info message");
	 		log.warn("Sample warn message");
	 		log.error("Sample error message");
	 		log.fatal("Sample fatal message");
	    	 
	  	boolean b= SaveNominationBo.saveNominationDetails(fname,lname,trainingId,applyDate);
	    	if(b) {
	    		
	    		try {
	    		
	    		request.getRequestDispatcher("nominationServlet2").forward(request,response);
	    	}catch(Exception e){
	    		log.error(e);
	    	}
	    	}
	    		else {
	    			
	    	
	    		try {
	    		request.getRequestDispatcher("nominationServlet2").forward(request,response);
	    	}catch(Exception e) {
	    		log.error(e);
	    		
	    	}
	     }
	     
	     try {
		request.getRequestDispatcher("/nomination.jsp").forward(request,response);
		
		
     	}catch(Exception e) {
     		log.error(e);
     	}
	}
}
}

