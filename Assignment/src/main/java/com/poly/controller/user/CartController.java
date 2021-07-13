package com.poly.controller.user;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Account;
import com.poly.entity.CartItem;
import com.poly.entity.Order;
import com.poly.entity.OrderDetail;
import com.poly.entity.Product;
import com.poly.service.AccountService;
import com.poly.service.OrderDetailsRepository;
import com.poly.service.OrdersRepository;
import com.poly.service.ParamService;
import com.poly.service.ProductService;
import com.poly.service.SessionService;
import com.poly.service.ShoppingcartService;

@Controller

public class CartController {
	
	@Autowired
	SessionService session;
	
	@Autowired
	ProductService service;
	
	@Autowired
	ShoppingcartService cartService;
	
	@Autowired
	ParamService param;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	OrdersRepository ordersRepository;
	
	@Autowired
	AccountService accountService;
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/cart")
	public String cart() {
		return "user/cart";
	}
	
	@GetMapping("/viewsCarts")
	public String viewCarts(Model model) {
		model.addAttribute("CART_ITEMS", cartService.getAllItem());
		model.addAttribute("TOTAL", cartService.getAmount());
		return "user/cart";
	}
	
	@GetMapping("/add/{id}")
	public String addCart(@PathVariable("id") Integer id) {
		Optional<Product> product = service.findById(id);
		CartItem item = new CartItem(id, product.get().getName(), product.get().getImage(), product.get().getPrice(), 1);
		cartService.add(item);
		return "redirect:/viewsCarts";
	}
	
	@PostMapping("update")
	public String update(Model model,@RequestParam("id") Integer id, @RequestParam("qty")Integer qty) {

		cartService.update(id, qty);
		return "redirect:/viewsCarts";
	}
	
	@GetMapping("clear")
		public String clearCart() {
			cartService.clear();
			return "redirect:/viewsCarts";
		}
	
	@GetMapping("del/{id}")
	public String removeCart(@PathVariable("id") Integer id) {
		cartService.remove(id);
		return "redirect:/viewsCarts";
	}
	
	//sap xep
			@GetMapping("views")
			public String viewProducts(
					Model model,
					@RequestParam("field") Optional<String> field) {
				Sort sort = Sort.by(Direction.DESC, field.orElse("price"));
				List<Product> ls = service.findAll(sort);
				model.addAttribute("PRODUCT", ls);
				return "user/cart";
			}
		
			public boolean checkSecurity() {
				String username = session.get("USERNAME");
				System.err.println("checkSecurity"+ username);
				if(username != null) {
					return true;
				}
				return false;
			}
		
	//phan trang
			@GetMapping("views/page")
			public String paginate( Model model, @RequestParam("p") Optional<Integer> p ) {
				if(p.get() < 0) {
					Pageable pageable = PageRequest.of(0, 8);
					Page<Product> page = service.findAll(pageable);
					model.addAttribute("PRODUCT", page);
					return "user/shop";
				}
				Pageable pageable = PageRequest.of(p.orElse(0), 8);
				Page<Product> page = service.findAll(pageable);
				model.addAttribute("PRODUCT", page);
				return "user/shop";
			}
			
		@GetMapping("/buy-product")
		public String buyProduct() {
			String username = (String) request.getSession().getAttribute("username");
			System.out.println(username);
			Collection<CartItem> mapsCart = cartService.getAllItem();
			System.out.println(mapsCart);
			ordersRepository.save(new Order(0, "address", new Date(), accountService.findById(username).get()));
			for(CartItem cart : mapsCart) {
				List<Order> listOrder = ordersRepository.findAll();
				long idOrder = 0;
				for(Order order : listOrder) {
					idOrder = order.getIdorder();
				}
				Optional<Order> order = ordersRepository.findById(idOrder);
				Optional<Product> product = productService.findById(cart.getIdproduct());
				orderDetailsRepository.save(new OrderDetail(0, cart.getPrice(), cart.getQty(), product.get(), order.get()));
			}
			cartService.clear();
			return "redirect:/home";
		}
		
		
		public void showAvata(Model model) {
			if(request.getSession().getAttribute("username") == null) {
				model.addAttribute("avata", "acount.png");
			}else {
				String username = (String) request.getSession().getAttribute("username");
				Optional<Account> acount = accountService.findById(username);
				model.addAttribute("avata", acount.get().getPhoto());
			}
		}
		
		@GetMapping("/purchased-products")
		public String purchasedProducts(Model model) {
			showAvata(model);
			String username = (String) request.getSession().getAttribute("username");
			List<OrderDetail> listOrderDetail = orderDetailsRepository.findCartByUsername(username);
			model.addAttribute("listOrderDetail", listOrderDetail);
			return "user/purchased-products";
		}
}
