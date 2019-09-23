package com.virtusa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.virtusa.bean.VenueBean;
import com.virtusa.bo.SaveVenueBo;

@WebServlet("/saveVenueServlet")
public class SaveVenueController extends HttpServlet {
	@Override
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String venueName=request.getParameter("venueName");
		String venueDesc=request.getParameter("venueDesc");
		
		
		VenueBean vb=new VenueBean();
		vb.setVenueName(venueName);
		vb.setVenueDescription(venueDesc);
		
		if(SaveVenueBo.saveVenues(vb)) {
			
			 RequestDispatcher rd=request.getRequestDispatcher("saveVenueServlet2");  
		     rd.forward(request,response);  
		}else {
			 pw.print("Sorry venue details not inserted");  
			
			 RequestDispatcher rd=request.getRequestDispatcher("venue.jsp");
			 rd.include(request,response);
			   
		}
		
		
	}

}
