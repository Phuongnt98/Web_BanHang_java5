package com.poly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.poly.entity.Product;

public interface ProductService {
	//khai bao cac ham
	void deleteAll();

	void deleteAll(List< Product> entities);

	void deleteAllById(List<Integer> ids);

	void delete(Product entity);

	void deleteById(Integer id);

	long count();

	List<Product> findAllById(List<Integer> ids);

	List<Product> findAll();

	boolean existsById(Integer id);

	Optional<Product> findById(Integer id);

	List<Product> saveAll(List<Product> entities);

	List<Product> findAll(Sort sort);

	Product save(Product entity);

	Page<Product> findAll(Pageable pageable);
	
}
