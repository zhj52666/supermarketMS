package com.sms.test;

public class Test {
	public static void main(String[] args) throws Exception {
			
		Object[] params=new Object[]{
				"%" + "%"
		};
		params[params.length] = new Object();
		System.out.println(params[params.length]);
		
        /*List<Sale> sales = null;	
		
		String sql="SELECT pid, SUM(saleCount) saleCount,SUM(saleroom) saleroom ,SUM(profit) profit FROM sale WHERE pid IN(SELECT id FROM product WHERE cid = ?) GROUP BY pid";
		
		Object[] params=new Object[]{
				Integer.valueOf(11)
				new SimpleDateFormat(front),
				new SimpleDateFormat(rear)
		};
		
		sales = CommonDao.executeQuery_reflect(Sale.class, sql, params);
		
		System.out.println(sales);*/
	}
}
