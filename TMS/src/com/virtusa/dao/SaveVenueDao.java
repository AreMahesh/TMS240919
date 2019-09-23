package com.virtusa.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.virtusa.bean.VenueBean;

public class SaveVenueDao {
	SaveVenueDao(){
		
	}
	

	public static boolean saveVenues(VenueBean vb) {

		boolean b = false;
		int status = 0;
		try {
			Connection con = RegisterDao.getConnection();
			PreparedStatement ps = con
					.prepareStatement("insert into venueDetails(venueId,venueName,venueDescription) values (?,?,?)");
			ps.setInt(1, getId());
			ps.setString(2, vb.getVenueName());
			ps.setString(3, vb.getVenueDescription());
			status = ps.executeUpdate();
			b = true;
			con.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return b;

	}

	public static int getId() {
		int id = 0;
		try {
			Connection con = RegisterDao.getConnection();
			PreparedStatement ps = con.prepareStatement("select count(*) from venueDetails");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt(1) + 1;
			} else {
				id = id + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

}
