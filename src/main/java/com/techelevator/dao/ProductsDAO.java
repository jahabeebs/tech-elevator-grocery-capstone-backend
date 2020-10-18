package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Certification;
import com.techelevator.model.Product;

public interface ProductsDAO {

	List<Product> getAllProductsByCertId(int certId);

	List<Product> viewAllProducts();
	
	List<Product> viewProductsByCategory(int categoryId);
	
	List<Product> viewProductsByBrand(int brand);
	
	List<Product> viewProductsBySale();
	Product viewProductDetails(int id);
	List<Product> getTitleFromCategory(String categoryName);

	List<Certification> getCertification(int productId);

	
}
