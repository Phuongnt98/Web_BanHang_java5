package com.poly.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Category;

public interface CategoryService extends JpaRepository<Category, String>{

//	@Query(value = "SELECT c FROM Category c where c.deleteCategory = ?1")
//	Page<Category> findAllDeletePage(boolean b, Pageable pageable);

}