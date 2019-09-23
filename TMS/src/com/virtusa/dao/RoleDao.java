package com.virtusa.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;





import com.virtusa.bean.RoleBean;


public class RoleDao {
	RoleDao(){
		
	}

		
	
	
	
	public static boolean saveRoles(RoleBean rb){
		boolean b=false;
		int status=0;
		Connection con=RegisterDao.getConnection();
		
		try{

			
			try(PreparedStatement ps=con.prepareStatement("insert into roleDetails(roleId,roleName,roleDescription) values (?,?,?)")){
		    ps.setInt(1, getId());
			ps.setString(2,rb.getRoleName());
			ps.setString(3,rb.getRoleDescription());
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
	    Connection con=RegisterDao.getConnection();
	    try(PreparedStatement ps=con.prepareStatement("select count(*) from roleDetails")){
	     try(ResultSet rs=ps.executeQuery()){
	    if(rs.next()) {
		  id=rs.getInt(1)+1;
		}else {
		  id=id+1;
	       }
	     }}
	    } catch (Exception e) {
			e.printStackTrace();
	  }
    
	    return id;
	    
	}
	
	}	

