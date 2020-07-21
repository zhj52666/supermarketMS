package com.sms.dao.impl;

import java.util.List;

import com.sms.dao.ProductDao;
import com.sms.dao.common.CommonDao;
import com.sms.pojo.Product;

public class ProductDaoMySql implements ProductDao {

	@Override
	public List<Product> getProducts() throws Exception {
		// TODO Auto-generated method stub
		List<Product> products=null;
		String sql="select * from product";
		products = CommonDao.executeQuery_reflect(Product.class,sql);
		return products;
	}

	@Override
	public Product getProductById(Integer pid) throws Exception {
		// TODO Auto-generated method stub
		Product product = null;
		String sql="select * from product where id=?";
		List<Product> products=CommonDao.executeQuery_reflect(Product.class, sql, pid);
		if(products!=null && products.size()==1){
			product=products.get(0);
		}
		return product;
	}

	@Override
	public void updateProductCount(Product product, Integer count) throws Exception {
		// TODO Auto-generated method stub
		String sql="update product set saleCount=?,stock=? where id=?";
		Object[] params=new Object[]{
				product.getSaleCount()+count,
				product.getStock()-count,
				product.getId()
		};
		CommonDao.executeUpdate(sql, params);
	}

	@Override
	public List<Product> selectProducts(String name, String cid, String front, String rear) throws Exception {
		// TODO Auto-generated method stub
		List<Product> products = null;
		
		StringBuffer sql = new StringBuffer();
		sql.append(" select * from product where name like ? ");		
		if (cid!="") {
			Integer cids = Integer.valueOf(cid);
			sql.append(" and cid =" + cids);			
		}
		if (front!="") {
			sql.append(" and yieldDate >= \'" + front +"\'");	
		}
		if (rear!="") {
			sql.append(" and yieldDate <= \"" + rear +"\"");
		}
		
		Object[] params=new Object[]{
				"%" +name+ "%"				
		};
			
		products = CommonDao.executeQuery_reflect(Product.class, sql.toString(), params);
		return products;
	}

	@Override
	public void addStockById(Integer id, Integer stock, Integer oldStock) throws Exception {
		// TODO Auto-generated method stub
		String sql="update product set stock=? where id=?";
		Object[] params=new Object[]{
				(oldStock+stock),
				id
		};
		CommonDao.executeUpdate(sql, params);
	}

	@Override
	public void addProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		String sql="insert into product(name,cid,yieldDate,manufacturers,price,nowPrice,stock)values(?,?,?,?,?,?,?)";
		Object[] params=new Object[]{
				product.getName(),
				product.getCid(),
				product.getYieldDate(),
				product.getManufacturers(),
				product.getPrice(),
				product.getNowPrice(),
				product.getStock()
		};
		CommonDao.executeUpdate(sql, params);
	}

	@Override
	public void updateProduct(Product product) throws Exception {
		// TODO Auto-generated method stub
		String sql="update product set name=?,cid=?,yieldDate=?,manufacturers=?,price=?,nowPrice=?,stock=? where id =?";
		Object[] params=new Object[]{
				product.getName(),
				product.getCid(),
				product.getYieldDate(),
				product.getManufacturers(),
				product.getPrice(),
				product.getNowPrice(),
				product.getStock(),
				product.getId()
		};
		CommonDao.executeUpdate(sql, params);
	}

	@Override
	public void deleteProduct(Integer id) throws Exception {
		// TODO Auto-generated method stub
		String sql="delete from product where id=?";
		Object[] params=new Object[]{
				id
		};
		CommonDao.executeUpdate(sql, params);
	}

}
