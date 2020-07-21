package com.sms.pojo;

import java.math.BigDecimal;
import java.util.Date;


public class Product {

	private Integer id;
	private Integer cid;
	private String name;
	private Date yieldDate;
    private String manufacturers;
    private BigDecimal price;
    private Date createDate;
    private Integer stock;
    private BigDecimal nowPrice;
    private Integer saleCount;
    
    private Category category;

    public Product() {
		// TODO Auto-generated constructor stub
	}
    
	public Product(Integer id, Integer cid, String name, Date yieldDate, String manufacturers, BigDecimal price,
			Date createDate, Integer stock, BigDecimal nowPrice, Integer saleCount, Category category) {
		super();
		this.id = id;
		this.cid = cid;
		this.name = name;
		this.yieldDate = yieldDate;
		this.manufacturers = manufacturers;
		this.price = price;
		this.createDate = createDate;
		this.stock = stock;
		this.nowPrice = nowPrice;
		this.saleCount = saleCount;
		this.category = category;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getYieldDate() {
		return yieldDate;
	}

	public void setYieldDate(Date yieldDate) {
		this.yieldDate = yieldDate;
	}

	public String getManufacturers() {
		return manufacturers;
	}

	public void setManufacturers(String manufacturers) {
		this.manufacturers = manufacturers;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public BigDecimal getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(BigDecimal nowPrice) {
		this.nowPrice = nowPrice;
	}

	public Integer getSaleCount() {
		return saleCount;
	}

	public void setSaleCount(Integer saleCount) {
		this.saleCount = saleCount;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", cid=" + cid + ", name=" + name + ", yieldDate=" + yieldDate + ", manufacturers="
				+ manufacturers + ", price=" + price + ", createDate=" + createDate + ", stock=" + stock + ", nowPrice="
				+ nowPrice + ", saleCount=" + saleCount + ", category=" + category + "]";
	}
    
}
