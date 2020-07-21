package com.sms.dao.impl;

import java.util.List;

import com.sms.dao.CategoryDao;
import com.sms.dao.common.CommonDao;
import com.sms.pojo.Category;

public class CategoryDaoMySql implements CategoryDao {

	@Override
	public List<Category> getCategories() throws Exception {
		// TODO Auto-generated method stub
		List<Category> categories=null;
		String sql="select * from category";
		categories = CommonDao.executeQuery_reflect(Category.class,sql);
		return categories;
	}

	@Override
	public Category getCategoryById(Integer cid) throws Exception {
		// TODO Auto-generated method stub
		Category category=null;
		String sql="select * from category where id=?";
		List<Category> categories=CommonDao.executeQuery_reflect(Category.class, sql, cid);
		if(categories!=null && categories.size()==1){
			category=categories.get(0);
		}
		
		return category;
	}

	@Override
	public void addCategory(String name, String recommend) throws Exception {
		// TODO Auto-generated method stub
		Integer recommends = Integer.valueOf(recommend);
		String sql="insert into category(name,recommend)values(?,?)";
		Object[] params=new Object[]{
				name,
				recommends
		};
		CommonDao.executeUpdate(sql, params);
	}

	@Override
	public void deleteCategory(Integer id) throws Exception {
		// TODO Auto-generated method stub
		String sql="delete from category where id = ?";
		Object[] params=new Object[]{
				id
		};
		CommonDao.executeUpdate(sql, params);
	}

	@Override
	public void updateCategory(Integer id, String name, Integer recommend) throws Exception {
		// TODO Auto-generated method stub
		String sql="update category set name=?,recommend=? where id=?";
		Object[] params=new Object[]{
				name,
				recommend,
				id
		};
		CommonDao.executeUpdate(sql, params);
	}

}
