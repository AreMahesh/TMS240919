package com.virtusa.bo;


import java.util.List;

import com.virtusa.bean.TrainingBean;
import com.virtusa.dao.SaveNominationDao;

public class SaveNominationBo {
	SaveNominationBo(){
		
	}

	public static List<TrainingBean> getTrainingsBasedOnRoleId(String s1) {
	
	 List<TrainingBean> tb=null;
	 tb=SaveNominationDao.getTrainingsBasedOnRoleId(s1);
	 
	 return tb;
		
	}

	public static boolean saveNominationDetails(String fname, String lname, String trainingId, String applyDate) {

		boolean b=false;
		
		b=SaveNominationDao.saveNominationDetails(fname,lname,trainingId,applyDate);
		
		return b;
	}

	
	
}
