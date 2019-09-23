package com.virtusa.bo;

import com.virtusa.bean.RoleBean;
import com.virtusa.dao.RoleDao;

public class SaveRoleBo{
	SaveRoleBo(){
		
	}
public static boolean saveRoles(RoleBean rb) {
		
		boolean b=RoleDao.saveRoles(rb);
		return b;
		
	}
	
}