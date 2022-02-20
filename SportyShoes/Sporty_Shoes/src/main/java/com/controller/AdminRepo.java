package com.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepo extends JpaRepository<Admin, Integer>{
	@Query("select admin from Admin admin where admin.adminName=?1")
	public Admin findByAdminName(String adminName);
	@Query("select admin from Admin admin where admin.adminPassword=?1")
	public Admin findByAdminPassword(String adminPassword);
}
