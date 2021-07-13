package com.poly.service;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.poly.entity.CartItem;

@SessionScope
@Service
public class ShoppingcartServiceImpl implements ShoppingcartService{
	Map<Integer, CartItem> maps = new HashMap<>();//gio hang
	
	@Override
	public void add(CartItem item) {
		CartItem cart = maps.get(item.getIdproduct());
		if(cart == null) {
			maps.put(item.getIdproduct(), item);
		}else{
			cart.setQty(cart.getQty() + 1);
		}
	}
	
	@Override
	public void remove(int id) {
		maps.remove(id);
	}
	
	public CartItem update(int idProduct, int quantity) {
		CartItem cart = maps.get(idProduct);
		cart.setQty(quantity);
		return cart;
	}
	
	@Override
	public void clear() {
		maps.clear();
	}
	
	@Override
	public Collection<CartItem> getAllItem(){
		return maps.values();
	}
	
	@Override
	public double getAmount() {
		return maps.values().stream().mapToDouble(item -> item.getQty() * item.getPrice()).sum();
	}

	@Override
	public com.poly.entity.CartItem CartItem(int idProduct, int quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
