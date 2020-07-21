package com.sms.dao.impl;

import java.math.BigDecimal;

import java.util.List;

import com.sms.dao.SaleDao;
import com.sms.dao.common.CommonDao;
import com.sms.pojo.Product;
import com.sms.pojo.Sale;

public class SaleDaoMySql implements SaleDao {

	@Override
	public void addSale(Product product, Integer count) throws Exception {
		// TODO Auto-generated method stub
		
		Sale sale = new Sale();
		sale.setPid(product.getId());
		BigDecimal saleCount = new BigDecimal(count.toString());
		sale.setSaleCount(saleCount);
		sale.setSaleroom(product.getNowPrice().multiply(saleCount));
		sale.setProfit(sale.getSaleroom().subtract(product.getPrice().multiply(saleCount)));
		
		String sql="insert into sale(pid,saleCount,saleroom,profit)values(?,?,?,?)";
		Object[] params=new Object[]{
				sale.getPid(),
				sale.getSaleCount(),
				sale.getSaleroom(),
				sale.getProfit()
		};
		CommonDao.executeUpdate(sql, params);
	}

	@Override
	public List<Sale> getSaleByGroup(String cid, String front, String rear) throws Exception {
		// TODO Auto-generated method stub
		List<Sale> sales = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT pid, SUM(saleCount) saleCount,SUM(saleroom) saleroom ,SUM(profit) profit FROM sale WHERE pid IN(SELECT id FROM product WHERE cid = ?) ");
		if (front!="") {
			sql.append(" and createDate >= \'" + front +"\'");	
		}
		if (rear!="") {
			sql.append(" and createDate <= \"" + rear +"\"");
		}
		sql.append(" GROUP BY pid");
		Object[] params=new Object[]{
				Integer.valueOf(cid)
		};
		
		sales = CommonDao.executeQuery_reflect(Sale.class, sql.toString(), params);	
		
		
		return sales;
	}

}
