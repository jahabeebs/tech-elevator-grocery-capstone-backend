package com.techelevator.model;

import java.math.BigDecimal;

public class Checkout {
public int productId;
public int inventorynum;
public String productName;
public BigDecimal price;
public String image;

public Checkout(int productId, int inventorynum, String productName, BigDecimal price, String image) {
	this.productName = productName;
	this.productId = productId;
	this.inventorynum = inventorynum;
	this.price = price;
	this.image = image;
}

public Checkout(int productId, int inventorynum) {
	
	this.productId = productId;
	this.inventorynum = inventorynum;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public int getInventorynum() {
	return inventorynum;
}
public void setInventorynum(int inventorynum) {
	this.inventorynum = inventorynum;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
}
