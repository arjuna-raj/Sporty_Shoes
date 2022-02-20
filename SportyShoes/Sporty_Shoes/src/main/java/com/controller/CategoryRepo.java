package com.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepo extends JpaRepository<Category, Integer>{
	
	@Query("select category from Category category")
	public List<Category> findAllCats();

}
