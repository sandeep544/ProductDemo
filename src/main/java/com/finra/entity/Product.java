package com.finra.entity;

public class Product {
	
	public String productId;
	public String name ;
	
	Product()
	{
		
	}
	
	Product(String productId, String name)
	{
		this.productId = productId;
		this.name = name;
	}
	
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	

}
