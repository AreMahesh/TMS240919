package com.virtusa.bo;

import java.util.ArrayList;

import com.virtusa.dao.SaveScheduleTrainingDao;

public class SaveScheduleTrainingBo {
	SaveScheduleTrainingBo(){
		
	}

	public static ArrayList getTrainingsForSchedule() {
		
		
		ArrayList al=SaveScheduleTrainingDao.getTrainingsForSchedule();
		return al;
	}

	public static ArrayList getVenuesForSchedule() {

		ArrayList al1=SaveScheduleTrainingDao.getVenuesForSchedule();
		return al1;
	}

	public static boolean saveScheduleDetails(String trainingName, String scheduleDate, String venueName) {
		
		boolean b=false;
		b=SaveScheduleTrainingDao.saveScheduleTrainingDetails(trainingName,scheduleDate,venueName);
		
		return b;
	}

}