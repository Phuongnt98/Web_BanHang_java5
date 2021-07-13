package com.poly.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.poly.entity.Account;
import com.poly.service.AccountService;
import com.poly.service.ParamService;

@Controller
@RequestMapping("account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	ParamService paramService;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	HttpServletResponse response;
	
	@GetMapping("/register")
	public String showForm(Model model){
		model.addAttribute("ACCOUNT", new Account());
		return "register";
	}
	
	@PostMapping("SaveOrUpdate")
	public String saveOrUpdate(
			@Validated @ModelAttribute("ACCOUNT") Account ac,
			BindingResult result,
			//Errors result,
			Model model,
			@RequestParam("image") MultipartFile multipartFile) throws IOException{
		if(result.hasErrors()|| multipartFile.isEmpty()) {
			
			model.addAttribute("ERROR_PHOTO", "Please select a photo");
				
			return "register";
		}
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		String uploadDir = "uploads/";
		ac.setPhoto(fileName);
		accountService.save(ac);
		paramService.save(multipartFile, uploadDir);
		model.addAttribute("ACCOUNT", new Account());
		return "register";
	}
	
	@GetMapping("views")
	public String viewAccount(Model model) {
		model.addAttribute("ACCOUNT", accountService.findAll());
		return "admin/view-accounts";
	}
	
	@GetMapping("register/{username}")
	public String edit(@PathVariable("username") String username, Model model) {
		Optional<Account> account = accountService.findById(username);
		if (account.isPresent()) {
			model.addAttribute("ACCOUNT", account.get());
			
		} else {
			model.addAttribute("ACCOUNT", new Account());
		}
		
		return "register";
	}
	
	@GetMapping(value = "views", params = "btnDel")
	public String delAccount(@RequestParam("username") String username, Model model) {
		accountService.deleteById(username);
		return "redirect:/account/views";
	}
	
	
//	//Account
//	public static List<Account> lsAccount = new ArrayList<>();
//	public int findByUsername(String username) {
//		for (int i = 0; i < lsAccount.size(); i++) {
//			Account c = lsAccount.get(i);
//			if(c.getUsername().equals(username)) {
//				return i;
//			}
//		}
//		return -1;
//	}
//	@GetMapping("register")
//	public String showForm(Model model){
//		model.addAttribute("ACCOUNT", new Account());
//		return "register-form";
//	}
//	@PostMapping("SaveOrUpdate")
//	public String saveOrUpdate(
//			@Validated @ModelAttribute("ACCOUNT") Account ac,
//			BindingResult result,
//			//Errors result,
//			Model model,
//			@RequestParam("image") MultipartFile multipartFile) throws IOException{
//		if(result.hasErrors()) {
//			if(multipartFile.isEmpty()) {
//				model.addAttribute("ERROR_PHOTO", "Please select a photo");
//			}
//			return "register-form";
//		}
//		int position = findByUsername(ac.getUsername());
//		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//		String uploadDir = "uploads/";
//		FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
//		if(position < 0) {
//			//khong tim thay
//			ac.setPhoto(fileName);
//			lsAccount.add(ac);
//			System.out.println("them moi thanh cong" +ac.getUsername());
//		}else {
//			//update
//			ac.setPhoto(fileName);
//			lsAccount.set(position, ac);
//		}
//		model.addAttribute("ACCOUNT", new Account());
//		return "register-form";
//	}
//	@GetMapping("views")
//	public String viewAccount(Model model) {
//		model.addAttribute("ACCOUNTS", lsAccount);
//		return "view-accounts";
//	}
//	@GetMapping(value= "views", params = "btnDel")
//	public String delAccount(@RequestParam("username") String username,Model model) {
//		int pos = findByUsername(username);
//		if(pos >= 0) {
//			lsAccount.remove(pos);
//		}
//		return "redirect:/account/views";
//	}
//	@GetMapping("register/{username}")
//	public String edit(@PathVariable("username") String username, Model model) {
//		int pos = findByUsername(username);
//		if(pos < 0) {
//			model.addAttribute("ACCOUNT", new Account());
//		}else {
//			model.addAttribute("ACCOUNT", lsAccount.get(pos));
//		}
//		return "register-form";
//	}
//	
//	
//	//login
//	@GetMapping("login")
//	public String viewForm() {
//		return "login-form";
//	}
////	@PostMapping("login")
////	public String login(
//////			@RequestParam("username") String username,
//////			@RequestParam("password") String password,
////			Model model) {
////		String u = paramService.getString("username", "");
////		String p = paramService.getString("password", "");
////		try {
////			Account acc = accountService.findById(u);
////			if(!acc.get().getPassword().equals(p)) {
////				model.addAttribute("MESSAGE", "Invalid password");
////			}else {
////				String uri = session.get("security-uri");
////				if(uri != null) {
////					return "redirect:" + uri;
////				}else {
////					model.addAttribute("MESSAGE", "login Successfull!");
////					session.set("USERNAME", u);
////				}
////			}
////		} catch (Exception e) {
////			model.addAttribute("MESSAGE", "Invalid Username");
////		}
////		return "redirect:/product/views";
////	}
//	@GetMapping("logout")
//	public String logout() {
//		session.remove("USERNAME");
//		return "login-form";
//	}
//
//	
////	@GetMapping("register")
////	public String showFrom(Model model) {
////		model.addAttribute("ACCOUNT", new Account());
////		return "register-form";
////	}
////	
//////	@PostMapping("SaveOrUpdate")
//////	public String saveOrUpdate(
//////			@Validated @ModelAttribute("ACCOUNT") Account ac, 
//////			BindingResult result, 
//////			Model model,
//////			@RequestParam("image") MultipartFile multipartFile
//////			) throws IOException {
//////		if (result.hasErrors() || multipartFile.isEmpty()){
//////			model.addAttribute("ERROR_PHOTO", "Please select a photo");
//////			return "register-form";
//////		}
//////		
////////			String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
//////			String uploadDir = "uploads/";
//////			ac.setPhoto(fileName);
//////			accountService.save(ac);
//////			paramService.save(multipartFile, uploadDir);
//////			model.addAttribute("ACCOUNT", new Account());
//////			return "register-form";
//////		}
////	
////	@GetMapping("views")
////		public String viewAccount(Model model) {
////		model.addAttribute("ACCOUNT", accountService.findAll());
////		return "view-accounts";
////	}
////	
////	@GetMapping("register/{username}")
////	public String edit(@PathVariable("username") String username, Model model) {
////		Optional<Account> account = accountService.findById(username);
////		if (account.isPresent()) {
////			model.addAttribute("ACCOUNT", account.get());
////			
////		} else {
////			model.addAttribute("ACCOUNT", new Account());
////		}
////		
////		return "register-form";
////	}
////	 
////	@GetMapping(value = "views", params = "btnDel")
////	public String delAccount(@RequestParam("username") String username, Model model) {
////		accountService.deleteById(username);
////		return "redirect:/account/views";
////	}
////	
////	
////	
	
	}


