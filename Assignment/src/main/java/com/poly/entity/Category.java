package com.poly.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Categories")
public class Category implements Serializable{
	
	@Id
	@NotEmpty(message = "Id category not empty!")
	private String idcategory;
	
	@NotEmpty(message = "Name not empty!")
	private String name;
	
	private boolean deletecategory;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	List<Product> products;

	@Override
	public String toString() {
		return "Category [idcategory=" + idcategory + ", name=" + name + "]";
	}

	public boolean getDeletecategory() {
		return this.deletecategory;
	}

	public void setDeletecategory(boolean deletecategory) {
		this.deletecategory = deletecategory;
	}
	
}
