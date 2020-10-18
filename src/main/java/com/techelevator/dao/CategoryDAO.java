package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Category;

public interface CategoryDAO {
	List <Category> viewProductsByCategory(int id);
	List<Category> getAllCategories();

}
