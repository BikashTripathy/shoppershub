package com.shoppershub.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shoppershub.entity.CartInfo;
import com.shoppershub.service.CartService;

@RestController
public class CartController {

	@Autowired
	private CartService cartService;

	@GetMapping("/cart/items")
	public List<CartInfo> getItems() {
		return cartService.getItems();
	}

	@GetMapping("/cart/items/{productId}")
	public CartInfo getItemById(@PathVariable int productId) {
		return cartService.getItemById(productId);
	}

	@PostMapping("/cart/items")
	public void addItemToCart(@RequestBody CartInfo cartInfo) {
		cartService.addOrUpdateItem(cartInfo);
	}

	@PutMapping("/cart/items")
	public void modifyItemOnCart(@RequestBody CartInfo cartInfo) {
		cartService.addOrUpdateItem(cartInfo);
	}

	@DeleteMapping("/cart/items/{productId}")
	public void deleteItemOnCart(@PathVariable int productId) {
		cartService.deleteItem(productId);
	}
}
