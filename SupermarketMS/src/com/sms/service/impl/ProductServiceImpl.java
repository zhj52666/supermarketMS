package com.sms.service.impl;

import java.util.List;

import com.sms.dao.ProductDao;
import com.sms.dao.impl.ProductDaoMySql;
import com.sms.pojo.Product;
import com.sms.service.ProductService;

public class ProductServiceImpl implements ProductService {

	ProductDao productDao = new ProductDaoMySql();
	
	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		List<Product> products=null;
		try {
			products = productDao.getProducts();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public Product getProductById(Integer pid) {
		// TODO Auto-generated method stub
		Product product = null;
		try {
			product = productDao.getProductById(pid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public void updateProductCount(Product product, Integer count) {
		// TODO Auto-generated method stub
		try {
			productDao.updateProductCount(product,count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> selectProducts(String name, String cid, String front, String rear) {
		// TODO Auto-generated method stub
		List<Product> products = null;
		try {
			products = productDao.selectProducts(name,cid,front,rear);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public void addStockById(Integer id, Integer stock, Integer oldStock) {
		// TODO Auto-generated method stub
		try {
			productDao.addStockById(id,stock,oldStock);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			productDao.addProduct(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			productDao.updateProduct(product);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		try {
			productDao.deleteProduct(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
