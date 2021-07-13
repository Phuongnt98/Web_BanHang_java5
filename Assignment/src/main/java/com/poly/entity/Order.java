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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@SuppressWarnings("serial")
@Data
@Entity
@Table(name="Orders")
//@NoArgsConstructor
//@AllArgsConstructor

public class Order implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idorder;
	
	private String address;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "Createdate")
	private Date createdate;
	
	@ManyToOne
	@JoinColumn(name = "Username")
	private Account account;
	
	@JsonIgnore
	@OneToMany(mappedBy = "order")
	List<OrderDetail> orderdatails;

	public Order(long idorder, String address, Date createdate, Account account) {
		super();
		this.idorder = idorder;
		this.address = address;
		this.createdate = createdate;
		this.account = account;
	}
	
	public Order() {
		super();
	}
	
}
