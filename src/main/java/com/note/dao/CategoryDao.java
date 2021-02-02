package com.note.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.note.modal.Category;

public interface CategoryDao extends JpaRepository<Category, Long> {

}
