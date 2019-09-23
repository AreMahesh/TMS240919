package com.virtusa.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SaveScheduleTrainingDao {
	SaveScheduleTrainingDao() {

	}

	public static ArrayList getTrainingsForSchedule() {

		ArrayList al = new ArrayList();
		Statement stmt = null;
		try {
			Connection con = RegisterDao.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * from nominationdetails where status='2'";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				al.add(rs.getString("trainingName"));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return al;
	}

	public static ArrayList getVenuesForSchedule() {
		ArrayList al = new ArrayList();
		Statement stmt = null;
		try {
			Connection con = RegisterDao.getConnection();
			stmt = con.createStatement();
			String sql = "SELECT * from venuedetails";

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				al.add(rs.getInt("venueid") + rs.getString("venuename"));
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return al;
	}

	public static boolean saveScheduleTrainingDetails(String trainingName, String scheduleDate, String venueName) {

		boolean b = false;
		int status = 0;
		int venueId = Integer.parseInt(venueName.substring(0, 1));
		Connection con = RegisterDao.getConnection();
		try {
			try (PreparedStatement ps = con
					.prepareStatement("insert into scheduleDetails(id,trainingName,scheduleDate,venueid) values (?,?,?,?)")) {
				ps.setInt(1, getId());
				ps.setString(2, trainingName);
				ps.setString(3,scheduleDate);
				ps.setInt(4, venueId);
				status = ps.executeUpdate();
				b = true;
				con.close();

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return b;

	}
	
	public static int getId() {
		 int id=0;
		 
		 
    try {
	    Connection con=RegisterDao.getConnection();
	    try(PreparedStatement ps=con.prepareStatement("select count(*) from scheduleDetails")){
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