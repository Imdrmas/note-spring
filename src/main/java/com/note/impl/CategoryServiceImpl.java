package com.note.impl;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.note.dao.CategoryDao;
import com.note.modal.Category;
import com.note.service.CategoryService;

@Transactional
@Component
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	@Override
	public Category addCategory(Category category) {
		category.setCreateAt(new Date());
		return categoryDao.save(category);
	}

	@Override
	public Category editCategory(Category category, long id) {
		Category existsCategory = categoryDao.findById(id).orElse(null);
		existsCategory.setUpdateAt(new Date());
		existsCategory.setName(category.getName());
		existsCategory.setCreateAt(null);
		return categoryDao.save(existsCategory);
	}

	@Override
	public void deleteCategory(long id) {
		categoryDao.deleteById(id);
	}

	@Override
	public Category findCategory(long id) {
		return categoryDao.findById(id).orElse(null);
	}

	@Override
	public List<Category> findCategories() {
		List<Category> categories = categoryDao.findAll();
		categories = categories.stream().sorted(Comparator.comparing(Category::getName).reversed())
				.collect(Collectors.toList());
		return categories;
	}

}
