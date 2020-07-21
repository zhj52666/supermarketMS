package com.sms.pojo;

import java.util.List;

public class Category {
	private Integer id;
    private String name;
    private Integer recommend;
    
    private List<Product> products;
    
    public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(Integer id, String name, Integer recommend, List<Product> products) {
		super();
		this.id = id;
		this.name = name;
		this.recommend = recommend;
		this.products = products;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getRecommend() {
		return recommend;
	}
	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", recommend=" + recommend + ", products=" + products + "]";
	}  
}
