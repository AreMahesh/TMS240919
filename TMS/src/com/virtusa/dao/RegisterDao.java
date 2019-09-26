package com.virtusa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.virtusa.bean.EmployeeBean;



public class RegisterDao {

	public static Connection getConnection(){
		Connection con=null;
		try{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		   // Class.forName("oracle.jdbc.driver.OracleDriver");

		    Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tms","root","system");
		}catch(Exception e){
			System.out.println(e);
		}
		return con;
	}
	RegisterDao(){
		
	}
	
	public static boolean save(EmployeeBean e){
		boolean b=false;
		int status=0;
		try{
			Connection con=RegisterDao.getConnection();
			try(PreparedStatement ps=con.prepareStatement("insert into userdetails(id,fname,lname,email,dob,address,username,password,role) values (?,?,?,?,?,?,?,?,?)")){
		    ps.setInt(1, getId());
			ps.setString(2,e.getFirstName());
			ps.setString(3,e.getLastName());
			ps.setString(4,e.getEmail());
			ps.setString(5,e.getDob());
			ps.setString(6,e.getAddress());
			ps.setString(7,e.getUserName());
			ps.setString(8,e.getPassword());
			ps.setString(9,e.getHiddenId());
			status=ps.executeUpdate();
			b=true;
			con.close();
			}}catch(Exception ex){
			ex.printStackTrace();
	   }
		return b;
	}
	
   
	public static int getId() {
		 int id=0;
     try {

	    try(PreparedStatement ps=RegisterDao.getConnection().prepareStatement("select count(*) from userDetails")){
	     ResultSet rs=ps.executeQuery();
	     
	    if(rs.next()) {
		  id=rs.getInt(1)+1;
		}else {
		  id=id+1;
	       }
	    } } catch (Exception e) {
			e.printStackTrace();
	  }
	    return id;
	}
	public static List<String> loginValidate(String uname,String pw) {
		List<String> al=new ArrayList();
		
		
		try {
			   Connection con=RegisterDao.getConnection();
			  try( Statement stmt=con.createStatement()){  
			   String query = "SELECT username,password,role,fname,lname FROM userDetails";
	            try(ResultSet rs = stmt.executeQuery(query)){
               while (rs.next()) {
	            String userName = rs.getString("username");
	            String passWord =  rs.getString("password");
	            String hiddenId=rs.getString("role");
	            String fname=rs.getString("fname");
	            String lname=rs.getString("lname");
	            
	               if ((uname.equals(userName)) && (pw.equals(passWord))) {
	            	   al.add(hiddenId);
	            	   al.add(fname);
	            	   al.add(lname);
	            	 
	              }
               
	            }
	            }}}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(al);
		return al;
	}

	
   }
