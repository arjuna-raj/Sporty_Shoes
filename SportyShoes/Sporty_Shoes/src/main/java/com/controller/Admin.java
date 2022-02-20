package com.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data 
@Entity
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int Aid;
	String adminName;
	String adminPassword;
}
