package com.sunny.services;

import java.util.List;
import com.sunny.model.Product;

public interface ProductService {
	public Product saveProduct(Product product);
	public List<Product> getAlListProduct();
	public Product getProductById(Integer id);
	public String deleteProduct(Integer id);
}
