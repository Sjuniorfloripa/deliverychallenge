package br.com.deliverychallenge.deliverychallenge.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.deliverychallenge.deliverychallenge.model.ProductEntity;
import br.com.deliverychallenge.deliverychallenge.services.ProductService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class productController {

	private final ProductService productService;

	@GetMapping
	public List<ProductEntity> list(){
		return productService.list();
	}
	
	@PostMapping
	public ProductEntity create(@RequestBody ProductEntity product) {
		return productService.create(product);
	}
	
}
