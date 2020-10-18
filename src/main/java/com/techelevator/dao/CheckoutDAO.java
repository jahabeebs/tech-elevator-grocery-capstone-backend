package com.techelevator.dao;

import java.util.List;

import com.techelevator.model.Checkout;

public interface CheckoutDAO {
List <Checkout> viewInventory();

void transferToCart(int productId, int quantity);
void updateProduct(int quantity, int productId);
void removeItemFromCart(int quantity,int productId);
void updateProductRemoval(int quantity, int productId);
String finalCheckout(double money);
}
