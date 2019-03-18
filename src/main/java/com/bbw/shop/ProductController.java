package com.bbw.shop;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	private final ProductRepository repository;

	ProductController(ProductRepository repository) {
		this.repository = repository;
	}

	@CrossOrigin
	@GetMapping("/products")
	List<Product> all() {
		return repository.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/products/{id}")
	Product one(@PathVariable Long id) {

		return repository.findById(id)
			.orElseThrow(() -> new RuntimeException(id.toString()));
	}


}
