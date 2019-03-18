package com.bbw.shop;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CartController {
	
	private final CartRepository repository;

	CartController(CartRepository repository) {
		this.repository = repository;
	}
	
	@CrossOrigin
	@GetMapping("/cart")
	List<Product> allItems() {
		log.info(repository.findAll().get(0) + "");
		return repository.findAll().get(0).getItems();
	}
	
	@CrossOrigin
	@PostMapping("/cart")
	Cart addItem(@RequestBody Product product) {

		Cart cart = repository.findAll().get(0);
		List<Product> itemList = cart.getItems();
		itemList.add(product);
		cart.setItems(itemList);
		log.info(cart + "");
		return repository.save(cart);
	}

	@DeleteMapping("/cart/{id}")
	Cart deleteItem(@PathVariable Long id) {
		Cart cart = repository.findAll().get(0);
		for(int i = 0 ; i < cart.getItems().size() ; i++){
			if(id == cart.getItems().get(i).getId()) {
				cart.getItems().remove(i);
			}
		}
		return repository.save(cart);

	}


}
