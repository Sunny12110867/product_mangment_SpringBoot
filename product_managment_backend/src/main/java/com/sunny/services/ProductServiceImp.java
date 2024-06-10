package com.sunny.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunny.model.Product;
import com.sunny.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Override
	public Product saveProduct(Product product) {
		Product newProduct = productRepo.save(product);
		return newProduct;
	}

	@Override
	public List<Product> getAlListProduct() {
		return productRepo.findAll();
	}

	@Override
	public Product getProductById(Integer id) {
		Optional<Product> product = productRepo.findById(id);
		return product.orElse(null);
	}

	@Override
	public String deleteProduct(Integer id) {
		Optional<Product> product = productRepo.findById(id);
		if(product.isPresent()) {
			productRepo.deleteById(id);
			return "Product deleted successfully";
		}
		return "Product not found";
	}
}
