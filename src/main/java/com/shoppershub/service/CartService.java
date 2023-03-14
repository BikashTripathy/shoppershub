package com.shoppershub.service;

import java.util.List;

import com.shoppershub.entity.CartInfo;

public interface CartService {

	public List<CartInfo> getItems();
	
	public CartInfo getItemById(int id);
	
	public void addOrUpdateItem(CartInfo cartInfo);
	
	public void deleteItem(int id);
}
