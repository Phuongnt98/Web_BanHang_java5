package com.poly.service;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.OrderDetail;

public interface OrderDetailsRepository extends JpaRepository<OrderDetail, Long>{

	@Query("SELECT o FROM OrderDetail o WHERE o.order.account.username = ?1 order by o.order.createdate desc")
	List<OrderDetail> findCartByUsername(String username);
	
}
