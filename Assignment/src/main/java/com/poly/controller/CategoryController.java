package com.poly.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Category;
import com.poly.service.CategoryService;


@Controller
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	int page = 0;
	
	int pageTotal;
	
	@GetMapping("/manager-categories")
	public String managerCategories(Model model, @RequestParam(name = "sortby", required = false, defaultValue = "idcategory") String sortby,
			@RequestParam(name = "sort", required = false, defaultValue = "asc") String sort) {
		renderCategorySort(model, sortby, sort);
		return "admin/category-views";
	}
	
	@GetMapping("/edit-category/{idcategory}")
	public String editCategory(Model model, @PathVariable("idcategory") String idcategory) {
		Optional<Category> category = categoryService.findById(idcategory);
		model.addAttribute("category", category.get());
		//renderCategories(model);
		return "admin/category-form";
	}
	
	@PostMapping("/save-category")
	public String saveCategory(Model model,@Validated @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			renderCategories(model);
			return "admin/categories-manager";
		}
		categoryService.save(category);
		return "redirect:/manager-categories";
	}
	
	@GetMapping("/delete-category")
	public String deleteCategory(Model model, @RequestParam("idcategory") String id) {
		//Optional<Category> category = categoryService.findById(id);
		//category.get().setDeletecategory(true);
		categoryService.deleteById(id);
		return "redirect:/manager-categories";
	}
	
	@PostMapping("/reset-category")
	public String resetCategory(Model model) {
		model.addAttribute("category", new Category());
		renderCategories(model);
		return "admin/categories-manager";
	}
	
//	@GetMapping("/trash-can-category")
//	public String trashCanCategory(Model model) {
//		renderCategoriesTrashCan(model);
//		return "admin/trash-can-categories";
//	}
	
	@GetMapping("/restore-category/{idcategory}")
	public String restoreCategory(@PathVariable("idcategory") String idcategory) {
		Optional<Category> category = categoryService.findById(idcategory);
		category.get().setDeletecategory(false);
		categoryService.save(category.get());
		return "forward:/trash-can-category";
	}
	
	@GetMapping("/next-category")
	public String nextAcount(Model model) {
		next();
		return "forward:/manager-categories";
	}
	
	@GetMapping("/prev-category")
	public String prevAcount(Model model) {
		prev();
		return "forward:/manager-categories";
	}
	
	@GetMapping("/next-category-trashcan")
	public String nextAcountTrashCan(Model model) {
		next();
		return "forward:/trash-can-category";
	}
	
	@GetMapping("/prev-category-trashcan")
	public String prevAcountTrashCan(Model model) {
		prev();
		return "forward:/trash-can-category";
	}
	
	public void next() {
		if((page +  1) < pageTotal) {
			page ++;
		}
	}
	
	public void prev() {
		if(page > 0) {
			page --;
		}
	}
	
//	public void renderCategoriesTrashCan(Model model) {
//		Pageable pageable = PageRequest.of(page, 5);
//		Page<Category> listCategory = categoryService.findAllDeletePage(true, pageable);
//		pageTotal = listCategory.getTotalPages();
//		model.addAttribute("page", listCategory.getNumber() + 1 + " of " + pageTotal);
//		model.addAttribute("listCategory", listCategory.getContent());
//	}
	
	public void renderCategorySort(Model model, String sortBy, String sort) {
		Pageable pageable = null;
		if (sort.equals("asc")) {
			pageable = PageRequest.of(page, 5, Sort.by(sortBy).ascending());
		} else if (sort.equals("desc")) {
			pageable = PageRequest.of(page, 5, Sort.by(sortBy).descending());
		}
		Page<Category> listCategory = categoryService.findAll(pageable);
		pageTotal = listCategory.getTotalPages();
		model.addAttribute("page", listCategory.getNumber() + 1 + " of " + pageTotal);
		model.addAttribute("listCategory", listCategory.getContent());
	}
	
	public void renderCategories(Model model) {
		Pageable pageable = PageRequest.of(page, 5);
		Page<Category> listCategory = categoryService.findAll(pageable);
		pageTotal = listCategory.getTotalPages();
		model.addAttribute("page", listCategory.getNumber() + 1 + " of " + pageTotal);
		model.addAttribute("listCategory", listCategory.getContent());
	}
}
