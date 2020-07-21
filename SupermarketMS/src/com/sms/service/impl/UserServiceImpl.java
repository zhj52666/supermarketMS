package com.sms.service.impl;

import com.sms.dao.UserDao;
import com.sms.dao.impl.UserDaoMySql;
import com.sms.pojo.User;
import com.sms.service.UserService;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoMySql();
	
	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		Boolean flag=false;
		try {
			int id=userDao.login(user);//返回值是id
			if(id>0){
				flag=true;//查询到了数据
			}
		} catch (Exception e) {
			flag=false;
			e.printStackTrace();
		}
		return flag;
	}

}
