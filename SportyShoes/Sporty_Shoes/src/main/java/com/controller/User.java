package com.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class User {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	int Uid;
	String name;
	String password;
	String email;
}
