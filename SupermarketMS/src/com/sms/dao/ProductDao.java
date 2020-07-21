package com.sms.dao;

import java.util.List;

import com.sms.pojo.Product;

public interface ProductDao {

	List<Product> getProducts() throws Exception;

	Product getProductById(Integer pid) throws Exception;

	void updateProductCount(Product product, Integer count) throws Exception;

	List<Product> selectProducts(String name, String cid, String front, String rear) throws Exception;

	void addStockById(Integer id, Integer stock, Integer oldStock) throws Exception;

	void addProduct(Product product) throws Exception;

	void updateProduct(Product product) throws Exception;

	void deleteProduct(Integer id) throws Exception;

}
