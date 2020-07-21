package com.sms.dao.impl;

import java.util.List;

import com.sms.dao.UserDao;
import com.sms.dao.common.CommonDao;
import com.sms.pojo.User;


public class UserDaoMySql implements UserDao {

	@Override
	public Integer login(User user) throws Exception {
		// TODO Auto-generated method stub
		Integer id=null;
		String sql="select id from user where username=? and password=?";
		Object[] params=new Object[]{
				user.getUsername(),
				user.getPassword()
		};
		List<User> users=CommonDao.executeQuery_reflect(User.class, sql, params);
		if(users!=null && users.size()==1){
			id=users.get(0).getId();
		}
		return id;
	}

}
