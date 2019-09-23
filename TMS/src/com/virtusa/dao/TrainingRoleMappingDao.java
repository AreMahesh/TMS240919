package com.virtusa.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.virtusa.bean.RoleBean;
import com.virtusa.bean.TrainingBean;

public class TrainingRoleMappingDao {

	

	
	
	public static ArrayList<RoleBean> getAllRoles() {
	    ArrayList<RoleBean> rb = new ArrayList<RoleBean>();
	    Statement stmt = null;
	   try {
	    	Connection con=RegisterDao.getConnection();
	    	  stmt = con.createStatement();
	        String sql = "SELECT * from roleDetails";

	        ResultSet rs = stmt.executeQuery(sql);
	        while (rs.next()) {
	        	RoleBean rb1 = new RoleBean();

	        	rb1.setRoleId(rs.getInt("roleId"));
	            rb1.setRoleName(rs.getString("roleName"));
	            rb1.setRoleDescription("roleDescription");

	            rb.add(rb1);
	            }

	    } catch (Exception e) {
	        
	        e.printStackTrace();
	    }

	  
	    return (rb);
	}

	public ArrayList<TrainingBean> getAllTrainings() {
	    ArrayList<TrainingBean> tb = new ArrayList<TrainingBean>();
	    Statement stmt = null;
	   try {
		   Connection con=RegisterDao.getConnection();
	    	  stmt = con.createStatement();
	        String sql = "SELECT * from trainingDetails";

	        ResultSet rs = stmt.executeQuery(sql);
	        while (rs.next()) {
	        	TrainingBean tb1 = new TrainingBean();

	        	tb1.setTrainingId(rs.getInt("trainingId"));
	            tb1.setTrainingName(rs.getString("trainingName"));
	            tb1.setTrainingType(rs.getString("trainingType"));
	            tb1.setTrainingDesc(rs.getString("trainingDesc"));

	            tb.add(tb1);
	            }

	    } catch (Exception e) {
	      
	        e.printStackTrace();
	    }

	  
	    return (tb);
	}

	public static boolean saveMapping(int roleid, ArrayList trainingIdsList) {
		
		boolean b1=false;
		int a=0;
		int b=0;
		try{
			Connection con=RegisterDao.getConnection();
			PreparedStatement stmt=con.prepareStatement("delete roletrainingMappingdetails where roleid=?");
			stmt.setInt(1,roleid);
			a=stmt.executeUpdate();
			
			for(int i=0;i<trainingIdsList.size();i++) {
			PreparedStatement ps=con.prepareStatement("insert into roletrainingMappingdetails(roleId,trainingId) values (?,?)");

			ps.setInt(1, roleid);
			ps.setInt(2,(int) trainingIdsList.get(i));
			b=ps.executeUpdate();
			}
			b1=true;
			con.close();
		}catch(Exception ex){
			ex.printStackTrace();
	   }
		return b1;
		
		
	}

	public static int getId() {
		 int id=0;
     try {
	    Connection con=RegisterDao.getConnection();
	    PreparedStatement ps=con.prepareStatement("select count(*) from roleTrainingMappingDetails");
	     ResultSet rs=ps.executeQuery();
	    if(rs.next()) {
		  id=rs.getInt(1)+1;
		}else {
		  id=id+1;
	       }
	    } catch (Exception e) {
			e.printStackTrace();
	  }
	    return id;
	}

	
}
