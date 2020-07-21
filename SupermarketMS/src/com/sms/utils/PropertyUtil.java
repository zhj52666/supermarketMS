package com.sms.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

	private Properties p=new  Properties();
	public PropertyUtil(String fileName){
		try {
			InputStream is=PropertyUtil.class.getClassLoader().getResourceAsStream(fileName);
			p.load(is);//把属性文件的内容加载到p对象中
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//从p对象中获取key所对应的值
	public String getProperty(String key){
		return p.getProperty(key);
	}
	
}
