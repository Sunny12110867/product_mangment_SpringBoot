package com.sunny.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunny.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
