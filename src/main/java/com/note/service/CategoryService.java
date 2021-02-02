package com.note.service;

import java.util.List;

import com.note.modal.Category;

public interface CategoryService {

	Category addCategory(Category category);

	Category editCategory(Category category, long id);

	void deleteCategory(long id);

	Category findCategory(long id);

	List<Category> findCategories();

}
