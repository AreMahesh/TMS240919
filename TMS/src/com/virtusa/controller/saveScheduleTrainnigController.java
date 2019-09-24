package com.virtusa.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.virtusa.bo.SaveScheduleTrainingBo;



@WebServlet("/saveScheduleTrainnigServlet")
public class saveScheduleTrainnigController extends HttpServlet {
	@Override
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();

		ArrayList al=null;
		ArrayList al1=null;
		
	    al=SaveScheduleTrainingBo.getTrainingsForSchedule();
	    al1=SaveScheduleTrainingBo.getVenuesForSchedule();
	   
         request.setAttribute("trainingsList", al);
         request.setAttribute("venuesList", al1);
         
         String trainingName=request.getParameter("trainingNameFinal");
         String scheduleDate=request.getParameter("scheduleDate");
         String venueName=request.getParameter("venueIdFinal");
         
         if(trainingName!= null && scheduleDate!=null && venueName!=null) {
        	 
        	 if(SaveScheduleTrainingBo.saveScheduleDetails(trainingName,scheduleDate,venueName)) {
				/*
				 * RequestDispatcher
				 * rd=request.getRequestDispatcher("SaveScheduleTrainingServlet2");
				 * rd.forward(request,response);
				 */
        		 pw.print(" ScheduleTrainingDetails details inserted");  
      			
    			 RequestDispatcher rd=request.getRequestDispatcher("scheduleTraining.jsp");
    			 rd.include(request,response);
        		 
        	 }else{
        		 pw.print("Sorry ScheduleTrainingDetails details not inserted");  
     			
    			 RequestDispatcher rd=request.getRequestDispatcher("scheduleTraining.jsp");
    			 rd.include(request,response);

        	 }
        	 
        }
         
	
         
	     request.getRequestDispatcher("/scheduleTraining.jsp").forward(request,response);
		
	}

}