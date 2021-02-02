package com.note.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.note.modal.Category;
import com.note.service.CategoryService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/addCategory")
	Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}

	@PutMapping("/editCategory/{id}")
	Category editCategory(@RequestBody Category category, @PathVariable long id) {
		return categoryService.editCategory(category, id);
	}

	@DeleteMapping("/deleteCategory/{id}")
	void deleteCategory(@PathVariable long id) {
		categoryService.deleteCategory(id);
	}

	@GetMapping("/findCategory/{id}")
	Category findCategory(@PathVariable long id) {
		return categoryService.findCategory(id);
	}

	@GetMapping("/findCategories")
	List<Category> findCategories() {
		return categoryService.findCategories();
	}

}
