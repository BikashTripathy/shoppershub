package com.shoppershub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppershub.dao.CartRepo;
import com.shoppershub.entity.CartInfo;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepo cartRepo;

	@Override
	public List<CartInfo> getItems() {
		return cartRepo.findAll();
	}

	@Override
	public CartInfo getItemById(int id) {
		Optional<CartInfo> findById = cartRepo.findById(id);
		CartInfo cartInfo = null;
		if (findById.isPresent()) {
			cartInfo = findById.get();
		} else {
			new RuntimeException("Item not found: " + id);
		}
		return cartInfo;
	}

	@Override
	public void addOrUpdateItem(CartInfo cartInfo) {
		cartRepo.save(cartInfo);
	}

	@Override
	public void deleteItem(int id) {
		cartRepo.delete(getItemById(id));
	}

}
