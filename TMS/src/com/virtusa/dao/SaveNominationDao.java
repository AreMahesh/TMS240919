package com.virtusa.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


import com.virtusa.bean.TrainingBean;
import com.virtusa.controller.SaveLoginController;

public class SaveNominationDao {
	
	SaveNominationDao(){
		
	}
	
	public static List<TrainingBean> getTrainingsBasedOnRoleId(String s1) {
		
		ArrayList<TrainingBean> tb=new ArrayList<TrainingBean>();
		
		  int roleId1=Integer.parseInt(s1.substring(0,1));
		
		 Statement stmt = null;
		 Logger log=Logger.getLogger(SaveLoginController.class);
			PropertyConfigurator.configure("F:\\sw\\eclipse-jee-neon-3-win32\\eclipse\\kalyani\\TMS2\\src\\log4j.properties");
			log.debug("Sample debug message");
			log.info("Sample info message");
			log.warn("Sample warn message");
			log.error("Sample error message");
			log.fatal("Sample fatal message");
			
		
		   try {
		    	
			   Connection con=RegisterDao.getConnection();
		    	
		    	try(PreparedStatement ps=con.prepareStatement("SELECT t.trainingId,t.trainingName,t.trainingType,t.trainingDesc from roletrainingmappingdetails r inner join trainingdetails t on r.trainingid = t.trainingid where r.roleid=?")){
			    ps.setInt(1, roleId1);
		       try( ResultSet rs = ps.executeQuery()){
		        while (rs.next()) {
		        	TrainingBean tb1 = new TrainingBean();
                    tb1.setTrainingId(rs.getInt("trainingid"));
		            tb1.setTrainingName(rs.getString("trainingName"));
		            tb1.setTrainingType(rs.getString("trainingType"));
		            tb1.setTrainingDesc(rs.getString("trainingDesc"));
		            tb.add(tb1);
		            }

		       }} } catch (Exception e) {
		        
		      log.error(e);
		    }
		return tb;
	}


	public static boolean saveNominationDetails(String fname, String lname, String trainingId, String applyDate) {
		
		int trainingId1=Integer.parseInt(trainingId.substring(0, 1));
		String trainingName1=trainingId.substring(0);
		
		Logger log=Logger.getLogger(SaveLoginController.class);
		PropertyConfigurator.configure("F:\\sw\\eclipse-jee-neon-3-win32\\eclipse\\kalyani\\TMS2\\src\\log4j.properties");
		
		
		int status=0;
		Connection con=RegisterDao.getConnection();
		
		try{
			
			
			try(PreparedStatement ps=con.prepareStatement("insert into nominationDetails(id,name,trainingId,trainingName,applydate) values (?,?,?,?,?)")){
		    ps.setInt(1, getId());
			ps.setString(2,(fname+" "+lname));
			ps.setInt(3,trainingId1);
			ps.setString(4, trainingName1);
		    ps.setString(5, applyDate);	
		
			status=ps.executeUpdate();
			
			con.close();
			}}catch(Exception ex){
			log.error(ex);
	   }
	    
		
		
		
	
		return false;
	}
	
  public static int getId() {
		 int id=0;
		 
     try {
	    Connection con=RegisterDao.getConnection();
	   try( PreparedStatement ps=con.prepareStatement("select count(*) from nominationDetails")){
	    try( ResultSet rs=ps.executeQuery()){
	    if(rs.next()) {
		  id=rs.getInt(1)+1;
		}else {
		  id=id+1;
	       }
	    }  } } catch (Exception e) {
			e.printStackTrace();
	  }
	    return id;
	}
	
	
	
	
	
	
	
	
	}

