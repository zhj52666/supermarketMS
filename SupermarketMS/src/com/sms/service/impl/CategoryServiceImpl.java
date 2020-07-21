package com.sms.service.impl;

import java.util.List;

import com.sms.dao.CategoryDao;
import com.sms.dao.impl.CategoryDaoMySql;
import com.sms.pojo.Category;
import com.sms.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {

	CategoryDao categoryDao = new CategoryDaoMySql();
	
	@Override
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		List<Category> categories = null;
		try {
			categories = categoryDao.getCategories();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categories;
	}

	@Override
	public Category getCategoryById(Integer cid) {
		// TODO Auto-generated method stub
		Category category=null;
		try {
			category=categoryDao.getCategoryById(cid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return category;
	}

	@Override
	public void addCategory(String name, String recommend) {
		// TODO Auto-generated method stub
		try {
			categoryDao.addCategory(name,recommend);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		try {
			categoryDao.deleteCategory(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void upateCategroy(Integer id, String name, Integer recommend) {
		// TODO Auto-generated method stub
		try {
			categoryDao.updateCategory(id,name,recommend);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
