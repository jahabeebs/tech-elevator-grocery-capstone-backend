package com.techelevator.model;

public class Category {
public int categoryId;
public String categoryName;
public String categoryDescription;
public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public Category(int categoryId, String categoryName) {
	super();
	this.categoryId = categoryId;
	this.categoryName = categoryName;
}

public Category(String categoryName) {
	this.categoryName = categoryName;
}
public Category(int categoryId, String categoryName, String categoryDescription) {
	super();
	this.categoryId = categoryId;
	this.categoryName = categoryName;
	this.categoryDescription = categoryDescription;
}
}
