package com.virtusa.controller;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.virtusa.bo.SaveLoginBo;
import com.virtusa.dao.RegisterDao;


@WebServlet("/SaveLoginServlet")
public class SaveLoginController extends HttpServlet {
	
	List<String> al=null;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
	
		String uname=request.getParameter("uName");
		String passWord=request.getParameter("passWord");
		String hiddenId=request.getParameter("adminId");
		
		al=SaveLoginBo.loginValidate(uname,passWord);
	  boolean ans = al.isEmpty(); 
	  if(ans == false){
	     	String s1=al.get(0);
		     HttpSession session = request.getSession();
             session.setAttribute("user", uname);
             request.setAttribute("hiddenId", s1);
             session.setAttribute("fname", al.get(1));
             session.setAttribute("lname", al.get(2));
             try {
		    RequestDispatcher rd=request.getRequestDispatcher("HomePage.jsp");
			rd.forward(request, response);
             }catch(Exception e) {
            	e.printStackTrace();
             }
		
			
	 }else{
		    pw.println("User Name and Password Not exist");
		    
		    try {
			RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");
			rd.include(request, response); 
	 }catch(Exception e) {
		e.printStackTrace();
	 }
	}

}
}
