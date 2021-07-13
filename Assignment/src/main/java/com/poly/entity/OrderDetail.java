package com.poly.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@Entity
@Table(name="OrderDetails")
public class OrderDetail implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idorderdetail;
	
	private Double price;
	
	private Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "idproduct")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "idorder")
	private Order order;

	public OrderDetail(long idorderdetail, Double price, Integer quantity, Product product, Order order) {
		super();
		this.idorderdetail = idorderdetail;
		this.price = price;
		this.quantity = quantity;
		this.product = product;
		this.order = order;
	}
	
	public OrderDetail() {
		super();
	}
	
}
