package com.techelevator.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Certification;
import com.techelevator.model.Product;

@Component
public class ProductsJDBCDAO implements ProductsDAO {
	private JdbcTemplate template;

	public ProductsJDBCDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}

	@Override
	public List<Product> viewAllProducts() {
		// TODO Auto-generated method stub
		String getAllProducts = "SELECT * FROM product";
		List<Product> allProducts = new ArrayList<>();
		SqlRowSet result = template.queryForRowSet(getAllProducts);
		while (result.next()) {
			int id = result.getInt("product_id");
			String title = result.getString("title");
			int brandId = result.getInt("brand_id");
			String details = result.getString("details");
			String weight = result.getString("weight");
			int category = result.getInt("category_id");
			String image = result.getString("image");
			Boolean sale = result.getBoolean("sale");
			BigDecimal price = result.getBigDecimal("price");
			int quantity = result.getInt("inventory");

			Product product = new Product(id, title, brandId, details, quantity, weight, category, image, sale, price);
			allProducts.add(product);
		}
		return allProducts;
	}

	@Override
	public List<Product> viewProductsByCategory(int categoryId) {
		// TODO Auto-generated method stub
		String productsByCat = "Select * from product where category_id = ? ";
		List<Product> productCat = new ArrayList<>();
		SqlRowSet result = template.queryForRowSet(productsByCat, categoryId);
		while (result.next()) {
			int id = result.getInt("product_id");
			String title = result.getString("title");
			int brandId = result.getInt("brand_id");
			String details = result.getString("details");
			String weight = result.getString("weight");
			int category = result.getInt("category_id");
			String image = result.getString("image");
			Boolean sale = result.getBoolean("sale");
			BigDecimal price = result.getBigDecimal("price");

			Product product = new Product(id, title, brandId, details, weight, category, image, sale, price);
			productCat.add(product);
		}
		return productCat;
	}

	@Override
	public List<Product> viewProductsByBrand(int brandId) {
		String productsByBrand = "Select * from product where brand_id = ? ";
		List<Product> productBrand = new ArrayList<>();
		SqlRowSet result = template.queryForRowSet(productsByBrand, brandId);
		while (result.next()) {
			int id = result.getInt("product_id");
			String title = result.getString("title");
			int brandId1 = result.getInt("brand_id");
			String details = result.getString("details");
			String weight = result.getString("weight");
			int category = result.getInt("category_id");
			String image = result.getString("image");
			Boolean sale = result.getBoolean("sale");
			BigDecimal price = result.getBigDecimal("price");

			Product product = new Product(id, title, brandId1, details, weight, category, image, sale, price);
			productBrand.add(product);
		}
		return productBrand;

	}

	@Override
	public List<Product> viewProductsBySale() {
		String productsBySale = "Select * from product where sale = true ";
		List<Product> productSale = new ArrayList<>();
		SqlRowSet result = template.queryForRowSet(productsBySale);
		while (result.next()) {
			int id = result.getInt("product_id");
			String title = result.getString("title");
			int brandId = result.getInt("brand_id");
			String details = result.getString("details");
			String weight = result.getString("weight");
			int category = result.getInt("category_id");
			String image = result.getString("image");
			Boolean sale = result.getBoolean("sale");
			BigDecimal price = result.getBigDecimal("price");

			Product product = new Product(id, title, brandId, details, weight, category, image, sale, price);
			productSale.add(product);
		}
		return productSale;
	}

	@Override
	public Product viewProductDetails(int productId) {
		// TODO Auto-generated method stub
		String getAllProducts = "SELECT * from product where product_id = ?";
		Product productDetails = null;
		SqlRowSet result = template.queryForRowSet(getAllProducts, productId);
		while (result.next()) {
			int id = result.getInt("product_id");
			String title = result.getString("title");
			int brandId = result.getInt("brand_id");
			String details = result.getString("details");
			String weight = result.getString("weight");
			int category = result.getInt("category_id");
			String image = result.getString("image");
			Boolean sale = result.getBoolean("sale");
			BigDecimal price = result.getBigDecimal("price");
			int qty = 1;
			

			productDetails = new Product(id, title, brandId, details, qty, weight, category, image, sale, price);
		}
		return productDetails;

	}

	public List<Product> getTitleFromCategory(String categoryName) {
		String getName = "SELECT * from product A join category B on A.category_id = B.category_id where B.category_name = ?";
		List<Product> productName = new ArrayList<>();
		SqlRowSet result = template.queryForRowSet(getName, categoryName);
		while (result.next()) {
			int id = result.getInt("product_id");
			String title = result.getString("title");
			int brandId = result.getInt("brand_id");
			String details = result.getString("details");
			String weight = result.getString("weight");
			int category = result.getInt("category_id");
			String image = result.getString("image");
			Boolean sale = result.getBoolean("sale");
			BigDecimal price = result.getBigDecimal("price");

			Product product = new Product(id, title, brandId, details, weight, category, image, sale, price);
			productName.add(product);
		}
		return productName;
	}

	public List<Certification> getCertification(int productId) {
		String select = "SELECT a.certification_name, a.certification_id from certification a join certification_product cp ON a.certification_id = cp.certification_id"
				+ " join product p ON p.product_id = cp.product_id WHERE p.product_id = ?";
		List<Certification> certs = new ArrayList<>();
		
		SqlRowSet result = template.queryForRowSet(select, productId);
		while (result.next()) {
			int id = result.getInt("certification_id");
			String name = result.getString("certification_name");

			Certification cert = new Certification(id, name);
			certs.add(cert);
		}
		return certs;
	}
	
	@Override
	public List<Product> getAllProductsByCertId(int certId) {
		String select = "SELECT p.*, a.certification_name, a.certification_id from certification a join certification_product cp ON a.certification_id = cp.certification_id"
				+ " join product p ON p.product_id = cp.product_id WHERE cp.certification_id = ?";
		
		List<Product> allProductsByCert = new ArrayList<>();
		SqlRowSet result = template.queryForRowSet(select, certId);
		while (result.next()) {
			int id = result.getInt("product_id");
			String title = result.getString("title");
			int brandId = result.getInt("brand_id");
			String details = result.getString("details");
			String weight = result.getString("weight");
			int category = result.getInt("category_id");
			String image = result.getString("image");
			Boolean sale = result.getBoolean("sale");
			BigDecimal price = result.getBigDecimal("price");
			int certification = result.getInt("certification_id");

			Product product = new Product(id, title, brandId, details, weight, category, image, sale, price, certification);
			allProductsByCert.add(product);
		}
		return allProductsByCert;
	}
}