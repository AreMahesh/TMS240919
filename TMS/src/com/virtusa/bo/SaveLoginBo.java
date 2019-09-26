package com.virtusa.bo;

import java.util.ArrayList;
import java.util.List;

import com.virtusa.dao.RegisterDao;

public class SaveLoginBo {

	public static List<String> loginValidate(String uname, String passWord) {
		
		List<String> al=new ArrayList();
		
		al=RegisterDao.loginValidate(uname, passWord);
		
		return al;
	}


	
	
}
