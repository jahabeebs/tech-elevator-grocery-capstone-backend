package com.techelevator.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.techelevator.dao.CategoryDAO;
import com.techelevator.dao.CheckoutDAO;
import com.techelevator.dao.ProductsDAO;
import com.techelevator.model.Category;
import com.techelevator.model.CategorySummary;
import com.techelevator.model.Certification;
import com.techelevator.model.Checkout;
import com.techelevator.model.Product;
import com.techelevator.service.ProductService;

@CrossOrigin
@RestController
public class ProductController {

@Autowired
private ProductsDAO dao;
@Autowired	
private CategoryDAO dao1;
@Autowired
private CheckoutDAO dao2;
	
	@RequestMapping(path="/test", method=RequestMethod.GET)
public void test() {
	System.out.println("It's working");
}

	@PreAuthorize("permitAll()")	
	@RequestMapping(path="/allProductsHome", method = RequestMethod.GET)
	public List<CategorySummary> getHomePageData() {
		
		List<CategorySummary> catSummaryList = new ArrayList<CategorySummary>();
		List<Category> allCategory= dao1.getAllCategories();
		
		for (Category cat : allCategory) {
			CategorySummary catSummary = new CategorySummary();
			
			catSummary.setCategoryDescription(cat.categoryDescription);
			catSummary.setCategoryName(cat.categoryName);
			catSummary.setCategoryId(cat.categoryId);
			List<Product> productsCatAll = dao.viewProductsByCategory(cat.categoryId);
			
			List<Product> productsCat = new ArrayList<Product>();
			for (int i=0; i < productsCatAll.size(); i++ ) {
				productsCat.add(productsCatAll.get(i));
			}
			
			catSummary.setProductsList(productsCat);
			
			catSummaryList.add(catSummary);
			
		}
		
		return catSummaryList;
		
		
	}
	
	
@PreAuthorize("permitAll()")	
@RequestMapping(path = "/allProducts", method = RequestMethod.GET)
	public List<Product> viewAllProducts() {
		List<Product> allProducts = dao.viewAllProducts();
		return allProducts;
	}

	@RequestMapping(path = "/byCategory/{categoryId}", method = RequestMethod.GET)
	public List<Product> viewProductsByCategory(@PathVariable int categoryId) {

		List<Product> productsCat = dao.viewProductsByCategory(categoryId);
		return productsCat;
	}

	@RequestMapping(path = "/byBrand/{brandId}", method = RequestMethod.GET)
	public List<Product> viewProductsByBrand(@PathVariable int brandId) {
		List<Product> productBrand = dao.viewProductsByBrand(brandId);
		return productBrand;
	}
	
	
	@RequestMapping(path= "/bySale", method = RequestMethod.GET)
	public List<Product> bySale(){
		List<Product> saleItems= dao.viewProductsBySale();
		return saleItems;
	}
	
	@RequestMapping(path = "/details/{productId}", method=RequestMethod.GET)
	public Product viewProductDetails(@PathVariable int productId){
		Product itemDetails= dao.viewProductDetails(productId);
		return itemDetails;
	}
	
	
	@RequestMapping(path = "/category/{categoryName}", method= RequestMethod.GET)
	public List<Product> getTitleFromCategory(@PathVariable String categoryName){
		List<Product> categoryList = dao.getTitleFromCategory(categoryName);
		return categoryList;
	}

	
	@RequestMapping(path = "/cat", method= RequestMethod.GET)
	public List<Category>getAllCategories(){
		List<Category> allCategory= dao1.getAllCategories();
		return allCategory;
	}
	
	@RequestMapping(path = "/certification/{certificateId}", method=RequestMethod.GET)
	public List<Product>getProductsByCert(@PathVariable int certificateId) {
		List<Product> prodsByCert = dao.getAllProductsByCertId(certificateId);
		return prodsByCert;
	}
	
	@RequestMapping(path = "/cert/{productId}", method=RequestMethod.GET)
	public List<Certification> getCertification(@PathVariable int productId) {
		List<Certification> certs = dao.getCertification(productId);
		return certs;
	}
	
	@RequestMapping(path = "/cartInventory", method=RequestMethod.GET)
	public List<Checkout>viewInventory() {
		List<Checkout> inventory = dao2.viewInventory();
		return inventory;
	}
	
	@RequestMapping(path= "/toCart/{productId}/{quantity}", method=RequestMethod.POST)
	public void transferToCart(@PathVariable int productId, @PathVariable int quantity) {
		dao2.transferToCart(productId, quantity);
		
	}
	@RequestMapping(path="/remove/{quantity}/{productId}",method=RequestMethod.POST)
	public void removeItemFromCart(@PathVariable int quantity, @PathVariable int productId) {
		dao2.removeItemFromCart(quantity, productId);
	}
	@RequestMapping(path="/checkout/{money}", method= RequestMethod.GET)
	public String finalCheckout(@PathVariable int money) {
		String output=dao2.finalCheckout(money);
				return output;
	}

}
