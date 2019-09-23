package com.virtusa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import com.virtusa.bean.ManagerApprovalBean;
import com.virtusa.bo.ManagerApprovalBo;



@WebServlet("/managerApprovalServlet")
public class ManagerApprovalController extends HttpServlet {
      @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<ManagerApprovalBean> mAList = null;
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();

		ManagerApprovalBo mad = new ManagerApprovalBo();
		mAList = mad.getNominationDetails();
		request.setAttribute("nominationsList", mAList);

		String[] selectedItems = request.getParameterValues("selectedItems");
		String staus = request.getParameter("status");
		if (selectedItems != null) {
			boolean b= mad.saveStatusOfNominationBo(selectedItems,staus
					);	
		
			RequestDispatcher rd = request.getRequestDispatcher("managerApprovalServlet2");
			rd.forward(request, response);
	
		}
		
		

		RequestDispatcher rd = request.getRequestDispatcher("/managerApproval.jsp");
		rd.forward(request, response);

	}

}