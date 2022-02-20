package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAO {

	@Autowired
	ProductRepo prepo;
	
	//insert a product
	public Product insert(Product p) {
		return prepo.save(p);
	}
	
	//remove a product
	public String delete(int pid) {
		prepo.deleteById(pid);
		return "deleted product of id:"+ pid;
	}
	
	//update a product
	public Product update(Product p) {
		Product existing = prepo.findById(p.getPid()).orElse(null);
		existing.setName(p.getName());
		return prepo.save(existing);
	}
}
