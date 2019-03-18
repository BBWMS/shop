package com.bbw.shop;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
class Cart {
    private @Id @GeneratedValue Long cartId;
    private String user;

   Cart() {
	   this.user = "Username";
   }
   
   
   @OneToMany(
	        cascade = CascadeType.ALL, 
	        orphanRemoval = true
	    )
   @JoinColumn(name = "cart_id")
   private List<Product> items = new ArrayList<>();
}