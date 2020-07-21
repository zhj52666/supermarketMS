package com.sms.dao;

import com.sms.pojo.User;

public interface UserDao {

	Integer login(User user) throws Exception;

}
