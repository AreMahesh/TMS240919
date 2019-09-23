package com.virtusa.bean;

public class TrainingBean {

	int trainingId;
	String trainingName;
	String trainingType;
	String trainingDesc;
	
	
	public int getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public String getTrainingType() {
		return trainingType;
	}
	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}
	public String getTrainingDesc() {
		return trainingDesc;
	}
	public void setTrainingDesc(String trainingDesc) {
		this.trainingDesc = trainingDesc;
	}
	@Override
	public String toString() {
		return "TrainingBean [trainingId=" + trainingId + ", trainingName=" + trainingName + ", trainingType="
				+ trainingType + ", trainingDesc=" + trainingDesc + "]";
	}
	
	
	
}
