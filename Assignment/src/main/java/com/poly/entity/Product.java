package com.poly.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="Products")
public class Product implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	@DecimalMin("0")
	private Integer idproduct;
	
	@NotEmpty(message = "Name not empty!")
	private String name;
	
	private String image;
	
	@NotNull
	@DecimalMin("1")
	private Double price;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Createdate")
	Date createdate = new Date();
	
	private Boolean available;
	
	@ManyToOne
	@JoinColumn(name = "idcategory")
	private Category category;
	
	//@JsonIgnore
	//@OneToMany(mappedBy = "product")
	//List<OrderDetail> orderdetails;

	@Override
	public String toString() {
		return "Product [idproduct=" + idproduct + ", name=" + name + ", image=" + image + ", price=" + price
				+ ", createdate=" + createdate + ", available=" + available + ", category=" + category
				+ "]";
	}
	
}
