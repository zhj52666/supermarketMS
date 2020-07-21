package com.sms.service;

import java.util.List;

import com.sms.pojo.Product;

public interface ProductService {
	
	List<Product> getProducts();

	Product getProductById(Integer pid);

	void updateProductCount(Product product, Integer count);

	List<Product> selectProducts(String name, String cid, String front, String rear);

	void addStockById(Integer id, Integer stock,Integer oldStock);

	void addProduct(Product product);

	void updateProduct(Product product);

	void deleteProduct(Integer id);
	
}
