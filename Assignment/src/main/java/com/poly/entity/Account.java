package com.poly.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Accounts")
public class Account implements Serializable{
	
	@Id
	@NotEmpty(message = "username not empty")
	@Column(columnDefinition = "varchar(30)")
	private String username;
	
	@NotEmpty(message = "password not empty")
	@Size(min = 6, message = "Mat khau tu 6 ky tu tro len")
	@Column(columnDefinition = "varchar(30)")
	private String password;
	
	@NotEmpty(message = "fullname not empty")
	@Column(columnDefinition = "nvarchar(70)")
	private String fullname;
	
	@NotEmpty(message = "Email not empty")
	@Email(message = "Email khong dung dinh dang")
	@Column(columnDefinition = "varchar(150)")
	private String email;
	
	private String photo;
	
	private Boolean activated;
	
	private Boolean admin;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<Order> orders;

	@Override
	public String toString() {
		return "=>"+getUsername()+"-"+getPassword();
	}
	
}
