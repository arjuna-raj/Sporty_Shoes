package com.controller;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Category {
	@Id
	String name;

}
