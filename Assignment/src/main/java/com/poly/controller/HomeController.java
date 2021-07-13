package com.poly.controller;


import java.util.Optional;
import java.util.Random;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.cookie.CookieService;
import com.poly.entity.Account;
import com.poly.service.AccountService;
import com.poly.service.MailService;
import com.poly.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@Autowired
	MailService mail;
	
	@GetMapping("/home")
	public String home(Model model) {
		Pageable pageable = PageRequest.of(0, 8);
		model.addAttribute("PRODUCT", productService.findAll(pageable));
		return "user/shop";
	}
	
	//*user/ten file tra ve*
	
	@GetMapping("/dang-nhap")
	public String dangNhap(Model model) {
		String username = CookieService.get("username", request);
		String password = CookieService.get("password", request);
		model.addAttribute("username", username);
		model.addAttribute("password", password);
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam String password) {
		String remember = "";
		remember = request.getParameter("chkemember");
		Optional<Account> a = accountService.findById(username);
		if(a.isPresent()) {
			if(a.get().getPassword().equals(password)) {
				int hours = (remember == null) ? 0 : 30*24;
				CookieService.add("username", username, hours, response);
				CookieService.add("password", password, hours, response);
				request.getSession().setAttribute("username", a.get().getUsername());
				if(a.get().getAdmin() == true) {
					return "redirect:/account/views";
				}
			}else {
				return "login";
				//cai nay la return ve login khi ko dang nhap duoc 
			}
		}
		return "redirect:/home"; //home la cai nay 
	}
	
	@GetMapping("/log-out")
	public String logOut() {
		request.getSession().setAttribute("username", null);
		return "redirect:/home";
	}
	
	@GetMapping("/quen-mat-khau")
	public String quenMatKhau() {
		
		return "forgot-password";
	}
	
	@PostMapping("/forgot-password")
	public String forgotPassword(@RequestParam("username") String username) {
		Optional<Account> acount = accountService.findById(username);
		String email = acount.get().getEmail();
		System.out.println("email" + email);
		//Random
		Random rd = new Random();
	    String newPass = String.valueOf(100000 + rd.nextInt(999999));
	    //Save
	    acount.get().setPassword(newPass);
	    accountService.save(acount.get());
		try {
			System.out.println("email //" + newPass);
			mail.push(email, "Java Spring Boot", "Java Spring Boot send new password " + newPass);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return "redirect:/dang-nhap";
	}
	
	
}
