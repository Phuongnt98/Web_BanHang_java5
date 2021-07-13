package com.poly.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.poly.entity.Product;

public interface ProductDAO extends PagingAndSortingRepository<Product, Integer>{

}
