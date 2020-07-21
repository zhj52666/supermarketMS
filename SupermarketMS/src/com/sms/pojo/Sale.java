package com.sms.pojo;

import java.math.BigDecimal;
import java.sql.Date;

public class Sale {
	private Integer id;
	private Integer pid;
	private Date createDate;
	private BigDecimal saleCount;
	private BigDecimal saleroom;
	private BigDecimal profit;
	
	private Product product;
  
	public Sale() {
		// TODO Auto-generated constructor stub
	}
	
	public Sale(Integer id, Integer pid, Date createDate, BigDecimal saleCount, BigDecimal saleroom, BigDecimal profit,
			Product product) {
		super();
		this.id = id;
		this.pid = pid;
		this.createDate = createDate;
		this.saleCount = saleCount;
		this.saleroom = saleroom;
		this.profit = profit;
		this.product = product;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public BigDecimal getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(BigDecimal saleCount) {
		this.saleCount = saleCount;
	}

	public BigDecimal getSaleroom() {
		return saleroom;
	}

	public void setSaleroom(BigDecimal saleroom) {
		this.saleroom = saleroom;
	}

	public BigDecimal getProfit() {
		return profit;
	}

	public void setProfit(BigDecimal profit) {
		this.profit = profit;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Sale [id=" + id + ", pid=" + pid + ", createDate=" + createDate + ", saleCount=" + saleCount
				+ ", saleroom=" + saleroom + ", profit=" + profit + ", product=" + product + "]";
	}
	
}
