package com.bbw.shop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
class Product {
    private @Id @GeneratedValue Long id;
    private String name;
    private int price;
    
    Product() {
    	name = "";
    	price = 0;
    }
    
    Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

}