package com.sms.dao;

import java.util.List;

import com.sms.pojo.Product;
import com.sms.pojo.Sale;

public interface SaleDao {

	void addSale(Product product, Integer count) throws Exception;

	List<Sale> getSaleByGroup(String cid, String front, String rear) throws Exception;

}
