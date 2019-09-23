package com.virtusa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.virtusa.bean.RoleBean;
import com.virtusa.bo.SaveRoleBo;




@WebServlet("/SaveRoleServlet")
public class SaveRoleController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String roleName=request.getParameter("roleName");
		String roleDesc=request.getParameter("roleDesc");
		
		Logger log=Logger.getLogger(SaveRoleController.class);
		PropertyConfigurator.configure("F:\\sw\\eclipse-jee-neon-3-win32\\eclipse\\kalyani\\TMS2\\src\\log4j.properties");
		log.debug("Sample debug message");
		log.info("Sample info message");
		log.warn("Sample warn message");
		log.error("Sample error message");
		log.fatal("Sample fatal message");
		
		
		log.info(roleName);
		
		RoleBean rb=new RoleBean();
		rb.setRoleName(roleName);
		rb.setRoleDescription(roleDesc);
		
		 
		if(SaveRoleBo.saveRoles(rb)) {
			try {
			 RequestDispatcher rd=request.getRequestDispatcher("SaveRoleServlet2");  
		     rd.forward(request,response);  
		}catch(Exception e){
			log.error(e);
		}
		}
			else {
		
			 pw.print("Sorry role details not inserted");  
			try {
			 RequestDispatcher rd=request.getRequestDispatcher("role.jsp");
			 rd.include(request,response);
			   
		}catch(Exception e) {
			log.error(e);
		}
	}
	}
}
