package com.poly.service;

import org.springframework.data.jpa.repository.JpaRepository;
import com.poly.entity.Order;

public interface OrdersRepository extends JpaRepository<Order, Long>{
	
}
