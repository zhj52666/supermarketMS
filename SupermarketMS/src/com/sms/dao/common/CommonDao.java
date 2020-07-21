package com.sms.dao.common;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import com.sms.dao.common.RowMapper;
import com.sms.utils.CommonValue;
import com.sms.utils.PropertyUtil;

public class CommonDao {
	private static PropertyUtil pu=new PropertyUtil(CommonValue.propertyFileName);
	private static PropertyUtil puu=new PropertyUtil(pu.getProperty("dbtype")+".properties");
	private static String driverClass=puu.getProperty("driverClass");
	private static String url=puu.getProperty("url");
	private static String name=puu.getProperty("name");
	private static String password=puu.getProperty("password");
	public static Connection getConnection()throws Exception{
		Connection con=null;
		Class.forName(driverClass);
		con=DriverManager.getConnection(url,name,password);
		return con;
	}
	public static void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con)throws Exception{
		if(rs!=null){
			rs.close();
		}
		if(pstmt!=null){
			pstmt.close();
		}
		if(con!=null){
			con.close();
		}
	}
	//通用更新
	public static int executeUpdate(String sql,Object...params)throws Exception{
		int rowAffect=0;
		Connection con=getConnection();
		PreparedStatement pstmt=con.prepareStatement(sql);
		if(params!=null){
			for(int i=0;i<params.length;i++){
				pstmt.setObject((i+1), params[i]);
			}
		}
		rowAffect=pstmt.executeUpdate();
		closeAll(null,pstmt,con);
		return rowAffect;
	}
	//通用查询的策略版
	public static <T> List<T> executeQuery_strategy(RowMapper<T> rm,String sql,Object...params)throws Exception{
		List<T> list=new ArrayList<T>();
		Connection con=getConnection();
		PreparedStatement pstmt=con.prepareStatement(sql);
		if(params!=null){
			for(int i=0;i<params.length;i++){
				pstmt.setObject((i+1), params[i]);
			}
		}
		ResultSet rs=pstmt.executeQuery();
		while(rs.next()){
			T t=rm.mapRow(rs);
			list.add(t);
		}
		closeAll(rs,pstmt,con);
		return list;
	}
	//通用查询反射版本
	public static <T> List<T> executeQuery_reflect(Class<T> clazz,String sql,Object...params)throws Exception{
		List<T> list=new ArrayList<T>();
		Connection con=getConnection();
		PreparedStatement pstmt=con.prepareStatement(sql);
		if(params!=null){
			for(int i=0;i<params.length;i++){
				pstmt.setObject((i+1), params[i]);
			}
		}
		ResultSet rs=pstmt.executeQuery();
		//获取结果集的元数据
		ResultSetMetaData rsmd=rs.getMetaData();
		//放置结果集的列名字
		List<String> columnNames=new ArrayList<String>();
		for(int i=0;i<rsmd.getColumnCount();i++){
			String columnName=rsmd.getColumnLabel((i+1));
			columnNames.add(columnName);
		}
		while(rs.next()){
			T t=clazz.newInstance();
			for(String columnName : columnNames){
				String setterMethodName="set"+columnName.substring(0, 1).toUpperCase()+columnName.substring(1);
				Method[] methods=clazz.getDeclaredMethods();
				for(Method method: methods){
					if(setterMethodName.equals(method.getName())){
						Object value=rs.getObject(columnName);
						//处理有关于聚合函数返回结果是Long
						if(value instanceof Long){
						    						
							Long l=(Long)value;
							value=l.intValue();
						}
						//处理oralce的number类型的数据进入结果集编程BigDecimal
						/*if(value instanceof BigDecimal){
							BigDecimal bd=(BigDecimal)value;
							value=bd.intValue();
						}*/
						method.invoke(t, value);
					}
				}
			}
			list.add(t);
		}
		closeAll(rs,pstmt,con);
		return list;
	}
}
