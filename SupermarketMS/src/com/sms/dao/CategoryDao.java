package com.sms.dao;

import java.util.List;

import com.sms.pojo.Category;

public interface CategoryDao {
	List<Category> getCategories() throws Exception;

	Category getCategoryById(Integer cid) throws Exception;

	void addCategory(String name, String recommend) throws Exception;

	void deleteCategory(Integer id) throws Exception;

	void updateCategory(Integer id, String name, Integer recommend) throws Exception;
}
