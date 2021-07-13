package com.poly.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "Cartitem")
public class CartItem implements Serializable{
	@Id
	private Integer idproduct;
	private String name;
	private String image;
	private double price;
	private int qty = 1;
	
}
