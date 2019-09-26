package com.virtusa.bo;

import com.virtusa.bean.EmployeeBean;
import com.virtusa.dao.RegisterDao;

public class SaveRegistrationBo {

	public static boolean save(EmployeeBean eb) {

		boolean b=false;
		
		b=RegisterDao.save(eb);
		
		return b;
	}

}
