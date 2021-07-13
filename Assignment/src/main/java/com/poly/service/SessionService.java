package com.poly.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionService {
	
	@Autowired
	HttpSession session;
	
	//doc gia tri cua attribute trong session
	//@param name ten attribute
	//@return gia tri doc duoc hoac null neu khong ton tai
	
	@SuppressWarnings("unchecked")
	public <T> T get(String name) {
		return (T) session.getAttribute(name);
	}
	
		//doc gia tri cua attribute trong session
		//@param name ten attribute
		//@param defaultValue gia tri mac dinh
		//@return gia tri doc duoc hoac null neu khong ton tai
	
	public <T> T get(String name, T defaultValue) {
		T value = get(name);
		return value != null ? value : defaultValue;
	}
	
	//thay doi hoac tao moi attribute trong session
	//@param name ten attribute
	//@param value gia tri attribute
	
	public void set(String name, Object value) {
		session.setAttribute(name, value);
	}
	
	//xoas attribute trong session
	//@param name ten attribute can xoa
	public void remove(String name) {
		session.removeAttribute(name);
	}
}
