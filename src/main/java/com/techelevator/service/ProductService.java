package com.techelevator.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.techelevator.model.Product;

public class ProductService {

	public static List<Product> getProducts(JsonNode jsonNode) {
		List<Product> productList = new ArrayList<Product>();

		for (int i = 0; i < jsonNode.path("data").size(); i++) {
			String productName = jsonNode.path("data").path(i).path("description").toString();
			String image = jsonNode.path("data").path(i).path("images").path(0).path("sizes").path(4).path("url")
					.toString();
			String price = jsonNode.path("data").path(i).path("items").path("price").path("regular").toString();
			BigDecimal bdPrice = new BigDecimal(price);
			String weight = jsonNode.path("data").path(i).path("items").path("size").toString();
			

			Product product = new Product(i, productName, image, bdPrice, weight);
			productList.add(product);

		}
		return productList;
	}
}
