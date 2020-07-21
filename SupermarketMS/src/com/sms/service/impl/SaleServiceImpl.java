package com.sms.service.impl;

import java.util.List;

import com.sms.dao.SaleDao;
import com.sms.dao.impl.SaleDaoMySql;
import com.sms.pojo.Product;
import com.sms.pojo.Sale;
import com.sms.service.SaleService;

public class SaleServiceImpl implements SaleService {

	SaleDao saleDao = new SaleDaoMySql();
	
	@Override
	public void addSale(Product product, Integer count) {
		// TODO Auto-generated method stub
		try {
			saleDao.addSale(product, count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Sale> getSaleByGroup(String cid, String front, String rear) {
		// TODO Auto-generated method stub
		List<Sale> sales = null;
		try {
			sales = saleDao.getSaleByGroup(cid,front,rear);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sales;
	}

}
