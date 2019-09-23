package com.virtusa.bo;

import com.virtusa.bean.VenueBean;
import com.virtusa.dao.SaveVenueDao;

public class SaveVenueBo {
	SaveVenueBo(){
		
	}

	public static boolean saveVenues(VenueBean vb) {
		
		boolean b=SaveVenueDao.saveVenues(vb);
		return b;
		
	}

	
	
}
