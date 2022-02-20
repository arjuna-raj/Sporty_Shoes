package com.controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Data
@Entity
public class Product {
	@Id
    @GenericGenerator(name = "sequence", strategy = "sequence", parameters = {
            @org.hibernate.annotations.Parameter(name = "sequenceName", value = "sequence"),
            @org.hibernate.annotations.Parameter(name = "allocationSize", value = "1"),
    })
	@GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
	int Pid;
	String name;
	String category;
}
