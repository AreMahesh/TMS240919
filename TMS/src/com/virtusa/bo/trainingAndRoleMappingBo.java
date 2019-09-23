package com.virtusa.bo;

import java.util.ArrayList;


import com.virtusa.dao.TrainingRoleMappingDao;

public class trainingAndRoleMappingBo {
	trainingAndRoleMappingBo(){
		
	}

	public static boolean trainingAndRoleMapping(String s1, String[] trainings) {
		
		
		ArrayList trainingIdsList=new ArrayList(); 
		String s2=s1.substring(0,1);
		int roleid=Integer.parseInt(s2);

		for(int i=0;i<trainings.length;i++) {
			trainingIdsList.add(Integer.parseInt(trainings[i].substring(0, 1)));
		}
       boolean c=	TrainingRoleMappingDao.saveMapping(roleid,trainingIdsList);
       return c;
	}
  
}
