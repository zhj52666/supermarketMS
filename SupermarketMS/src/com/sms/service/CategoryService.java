package com.sms.service;

import java.util.List;

import com.sms.pojo.Category;

public interface CategoryService {
	List<Category> getCategories();

	Category getCategoryById(Integer cid);

	void addCategory(String name, String recommend);

	void deleteCategory(Integer id);

	void upateCategroy(Integer id, String name, Integer recommend);
}
