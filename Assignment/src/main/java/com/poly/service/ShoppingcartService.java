package com.poly.service;

import java.util.Collection;

import com.poly.entity.CartItem;

public interface ShoppingcartService {
	//dinh nghi cac ham
	double getAmount();

	Collection<CartItem> getAllItem();

	void clear();

	CartItem CartItem(int idProduct, int quantity);
	
	CartItem update(int idProduct, int quantity);

	void remove(int id);

	void add(CartItem item);

	
}
