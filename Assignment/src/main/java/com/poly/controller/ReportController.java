package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.poly.service.CategoryService;
import com.poly.service.OrderDetailsRepository;
import com.poly.service.OrdersRepository;
@Controller
public class ReportController {
//	@Autowired
//	CategoryService categoriesRepository;
//	
//	@Autowired
//	OrderDetailsRepository orderDetailsRepository;
//	
//	@Autowired
//	OrdersRepository ordersRepository;
//	
//	@GetMapping("/report")
//	public String report(Model model) {
//		List<Object[]> listReport = orderDetailsRepository.findTop10();
//		System.out.println(listReport.toString());
//		
//		return "admin/report";
//	}
}
