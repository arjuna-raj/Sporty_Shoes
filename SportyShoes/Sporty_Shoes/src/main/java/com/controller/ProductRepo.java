package com.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	@Query("select product from Product product")
	public List<Product> findAllProduct();
	

	
	
}
