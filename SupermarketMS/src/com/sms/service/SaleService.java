package com.sms.service;

import java.util.List;

import com.sms.pojo.Product;
import com.sms.pojo.Sale;

public interface SaleService {

	void addSale(Product product, Integer count);

	List<Sale> getSaleByGroup(String cid, String front, String rear);

}
