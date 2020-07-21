package com.sms.dao.common;

import java.sql.ResultSet;

public interface RowMapper<T> {
	public T mapRow(ResultSet rs)throws Exception;
}
