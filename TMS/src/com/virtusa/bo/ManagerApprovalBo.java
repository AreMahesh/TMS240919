package com.virtusa.bo;

import java.util.ArrayList;

import com.virtusa.bean.ManagerApprovalBean;
import com.virtusa.dao.ManagerApprovalDao;

public class ManagerApprovalBo {
	
	ManagerApprovalDao mad=new ManagerApprovalDao();
	public ArrayList<ManagerApprovalBean> getNominationDetails(){
		ArrayList<ManagerApprovalBean> mAList=null;
		
		
		mAList=mad.getNominationDetails();
		
		
		return mAList;
		
		
	}

	public boolean saveStatusOfNominationBo(String[] selectedItems, String status) {
				boolean a=mad.saveStatusOfNominationDao(selectedItems,status);
		
		
		return a;
	}
}