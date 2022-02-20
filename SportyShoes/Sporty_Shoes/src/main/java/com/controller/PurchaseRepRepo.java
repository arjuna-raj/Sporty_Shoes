package com.controller;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PurchaseRepRepo extends JpaRepository<Purchase, Integer>{

//	List<PurchaseRepRepo> findByOrderByCategoryAsc();
//	
//	List<PurchaseRepRepo> findByOrderByDateDesc();
	@Query("select purchase from Purchase purchase")
	public List<Purchase> findAllPurchase();

}
