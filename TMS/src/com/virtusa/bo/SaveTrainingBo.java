package com.virtusa.bo;


import com.virtusa.bean.TrainingBean;

import com.virtusa.dao.TrainingDao;

public class SaveTrainingBo {
	SaveTrainingBo(){
		
	}
public static boolean saveTrainings(TrainingBean tb) {
		
		boolean b=TrainingDao.saveTrainings(tb);
		return b;

}
}
