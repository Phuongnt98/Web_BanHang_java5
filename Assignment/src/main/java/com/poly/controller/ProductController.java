package com.poly.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.poly.entity.Category;
import com.poly.entity.Product;
import com.poly.service.CategoryService;
import com.poly.service.ParamService;
import com.poly.service.ProductService;
import com.poly.service.SessionService;

@Controller
@RequestMapping("product")
public class ProductController {
	@Autowired
	SessionService session;
	
	@Autowired
	ProductService service;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	ParamService paramService;
	
	@GetMapping("/managerproduct")
	public String managerProduct(Model model){
		model.addAttribute("PRODUCT", new Product());
		return "admin/product-form";
	}
	
	@PostMapping("SaveOrUpdate")
	public String saveOrUpdate(
			@Validated @ModelAttribute("PRODUCT") Product pr,
			BindingResult result, @RequestParam("id-category") String idCategory,
			//Errors result, 
			@RequestParam("image-product") MultipartFile file,
			Model model ) throws IOException{
		
		Optional<Category> category = categoryService.findById(idCategory);
		
		if(result.hasErrors()|| file.isEmpty()) {
			model.addAttribute("ERROR_PHOTO", "Please select a photo");
			return "admin/product-form";
		}
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		String uploadDir = "uploads/";
		pr.setAvailable(true);
		pr.setImage(fileName);
		pr.setCategory(categoryService.findById(idCategory).get());
		service.save(pr);
		paramService.save(file, uploadDir);
		return "admin/product-form";
	}
	
	@GetMapping("viewsProduct")
		public String viewProduct(Model model) {
		Pageable pageable = PageRequest.of(0, 5);
		model.addAttribute("PRODUCT", service.findAll(pageable));
		return "admin/product-views";
	}
	
	@GetMapping("managerproduct/{idproduct}")
	public String edit(@PathVariable("idproduct") Integer idproduct, Model model) {
		Optional<Product> product = service.findById(idproduct);
		if (product.isPresent()) {
			model.addAttribute("PRODUCT", product.get());
			model.addAttribute("category", product.get().getCategory());
		} else {
			model.addAttribute("PRODUCT", new Product());
		}
		
		return "admin/product-form";
	}
	
	//sap xep
	@GetMapping("views")
	public String viewProducts(Model model,@RequestParam("field") Optional<String> field) {
		Sort sort = Sort.by(Direction.DESC, field.orElse("price"));
		List<Product> ls = service.findAll(sort);
		model.addAttribute("PRODUCT", ls);
		return "admin/product-views";
	}

	public boolean checkSecurity() {
		String username = session.get("USERNAME");
		System.err.println("checkSecurity"+ username);
		if(username != null) {
			return true;
		}
		return false;
	}
	
	@GetMapping("views/page")
	public String paginate( Model model, @RequestParam("p") Optional<Integer> p ) {
		if(p.get() < 0) {
			Pageable pageable = PageRequest.of(0, 5);
			Page<Product> page = service.findAll(pageable);
			model.addAttribute("PRODUCT", page);
			return "admin/product-views";
		}
		Pageable pageable = PageRequest.of(p.orElse(0), 5);
		Page<Product> page = service.findAll(pageable);
		model.addAttribute("PRODUCT", page);
		return "admin/product-views";
	}
	
	@GetMapping(value = "viewsProduct", params = "btnDel")
	public String delProduct(@RequestParam("idproduct") Integer idproduct, Model model) {
		service.deleteById(idproduct);
		return "redirect:/product/viewsProduct";
	}
	
	
	
		
	
	
	
	
	
	
	
	
		
		
		
		
		
		
		
		
		
	
	
//	public static List<Product> ls = new ArrayList<>();
//	//thong tin product 
//	@GetMapping("product-form")
//	public String form(Model model) {
//		model.addAttribute("PRODUCT", new Product());
//		model.addAttribute("ACTION", "product-form");
//		return "product-form";
//	}
//	//add 
//	@PostMapping("product-form")
//	public String add(
//			Model model,
////			@RequestParam("image") String image,
//			@RequestParam("id") Integer id,
//			@RequestParam("name") String name,
//			@RequestParam("price") double price
//			) {
//		Product p = new Product();
//		ls.add(p);
//		return "product-form";
//	}
//	//update
////	@PostMapping("product-update")
////	public String update(
////			Model model,
//////			@RequestParam("image") String image,
////			@RequestParam("id") Integer id,
////			@RequestParam("name") String name,
////			@RequestParam("price") double price
////			) {
////		for(int i = 0; i < ls.size(); i++) {
////			Product p = ls.get(i);
////			if(p.getId().equals(id)) {
////				ls.set(i, new Product());
////			}
////		}
////		return "redirect:/product/viewsProduct";
////	}
//	//view product 
//	@GetMapping("viewsProduct")
//	public String viewProdAdmin(Model model) {
//		model.addAttribute("PRODUCT",ls);
//		return "product-views";
//	}
////	//xoa 
////	@GetMapping(value = "views" , params = "btnDel")
////	public String del(@RequestParam("id") String id, Model model) {
////		for (int i = 0; i < ls.size(); i++) {
////			Product pro = ls.get(i);
////			if(pro.getId().equals(id)) {
////				ls.remove(i);
////			}
////		}
////		return "redirect:/product/viewsProduct";
////	}
////	//edit
////	public Product getProductById(String id) {
////		for(Product product : ls) {
////			if(product.getId().equals(id)) {
////				return product;
////			}
////		}
////		return null;
////	}
////	@GetMapping("product-form/{id}")
////	public String edit(@PathVariable("id") String id, Model model) {
////		model.addAttribute("PRODUCT", getProductById(id));
////		model.addAttribute("ACTION", "/product/product-update");
////		return "product-form";
////	}
//	
//	
//	
//	//USER
//	//views va sap xep (user)
//	@GetMapping("views")
//	public String viewProducts(
//			Model model,
//			@RequestParam("field") Optional<String> field) {
//		Sort sort = Sort.by(Direction.DESC, field.orElse("price"));
//		List<Product> ls = service.findAll(sort);
//		model.addAttribute("LIST_PRODUCT", ls);
//		return "view-products";
////		if(checkSecurity()) {
////			model.addAttribute("LIST_PRODUCT", service.getdAll());
////			return "view-products";
////		}
////		return "redirect:/account/login";
//	}
//	//check
//	public boolean checkSecurity() {
//		String username = session.get("USERNAME");
//		System.err.println("checkSecurity"+ username);
//		if(username != null) {
//			return true;
//		}
//		return false;
//	}
//	//phan trang
//	@GetMapping("views/page")
//	public String paginate(
//			Model model, 
//			@RequestParam("p") Optional<Integer> p ) {
//		Pageable pageable =(Pageable) PageRequest.of(p.orElse(0), 10);
////		Page<Product> page = service.findAll(pageable);
////		model.addAttribute("LIST_PRODUCT", page);
//		return "";
//	}
}
