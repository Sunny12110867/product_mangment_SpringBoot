package com.sunny.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sunny.model.Product;
import com.sunny.services.ProductService;

@RestController
@RequestMapping("/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/save")
	public ResponseEntity<?> saveProduct(@RequestBody Product product){
		return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED); 
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/")
	public ResponseEntity<?> getAllProduct(){
		return new ResponseEntity<>(productService.getAlListProduct(), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Integer id){
		return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable Integer id){
		 return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/edit")
	public ResponseEntity<?> editProduct(@RequestBody Product product){
		return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
	}
}
