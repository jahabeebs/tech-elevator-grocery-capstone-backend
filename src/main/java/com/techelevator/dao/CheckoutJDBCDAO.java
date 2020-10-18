package com.techelevator.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Checkout;

@Component
public class CheckoutJDBCDAO implements CheckoutDAO {
	private JdbcTemplate template;

	public CheckoutJDBCDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}

	@Override
	public List<Checkout> viewInventory() {
		String getInv = "SELECT * FROM purchases JOIN product ON purchases.product_id = product.product_id;";
		List <Checkout> inventory = new ArrayList<>();
		SqlRowSet result = template.queryForRowSet(getInv);
		while(result.next()) {
			int id = result.getInt("product_id");
			int inv = result.getInt("item_quantity");
			String name = result.getString("title");
			BigDecimal price = result.getBigDecimal("price");
			String image = result.getString("image");
		Checkout checkout = new Checkout(id, inv, name, price, image);
		inventory.add(checkout);
		}
		return inventory;	
	}

	@Override
	public void transferToCart(int productId, int quantity) {
		String sql = "Insert Into purchases (product_id, item_quantity) VALUES(?, ?)";
		template.update(sql, productId, quantity);
		updateProduct(quantity, productId);
	}

	@Override
	
	public void updateProduct(int quantity, int productId) {
		// TODO Auto-generated method stub
		String sql = "Update product Set inventory = inventory-? where product_id = ?";
		template.update(sql, quantity, productId);
	}
	
	public void removeItemFromCart(int quantity,int productId) {
		String sql = "update purchases set item_quantity = item_quantity - ? where product_id = ?";
		template.update(sql, quantity, productId);
		updateProductRemoval(quantity, productId);
	}
	public void updateProductRemoval(int quantity, int productId) {
		String sql = "update product set inventory = inventory +? where product_id =?";
		template.update(sql,quantity, productId);
	}
	public String finalCheckout(double money) {
		String response = "";
		if(money >= 25.00) {
			response = "Transaction Successful";
		}else {
			response = "Order must be Minimum $25.00";
		}
		return response;
	}
}
