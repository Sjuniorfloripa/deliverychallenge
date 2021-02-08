package br.com.deliverychallenge.deliverychallenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.deliverychallenge.deliverychallenge.exceptions.ProductNotFoundException;
import br.com.deliverychallenge.deliverychallenge.model.ProductEntity;
import br.com.deliverychallenge.deliverychallenge.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	public List<ProductEntity> list() {
		return productRepository.findAll();
	}

	public ProductEntity create(ProductEntity produto) {
		return productRepository.save(produto);
	}

	public ProductEntity findById(Long id) throws ProductNotFoundException {
		return productRepository.findById(id)
				.orElseThrow(() -> new ProductNotFoundException("Error, Product not found."));
	}
}
