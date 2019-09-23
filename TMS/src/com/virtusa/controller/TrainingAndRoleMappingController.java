package com.virtusa.controller;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.bean.RoleBean;
import com.virtusa.bean.TrainingBean;
import com.virtusa.dao.TrainingRoleMappingDao;


@WebServlet("/TrainingRoleMappingServlet")
public class TrainingAndRoleMappingController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		ArrayList<RoleBean> rb=null;
		ArrayList<TrainingBean> tb=null;
		TrainingRoleMappingDao trmd=new TrainingRoleMappingDao();
	    rb=trmd.getAllRoles();
	    tb=trmd.getAllTrainings();
	    
	     request.setAttribute("roleList", rb);
	    request.setAttribute("trainingList", tb);
	    
	       
		request.getRequestDispatcher("/trainingAndRoleMapping.jsp").forward(request,response);
		
	}

}
