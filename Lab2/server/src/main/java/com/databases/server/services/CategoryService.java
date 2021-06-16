package com.databases.server.services;

import com.databases.server.entities.Category;
import com.databases.server.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
  private final CategoryRepository categoryRepository;


  public CategoryService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public List<Category> findAll() {
    return this.categoryRepository.findAll();
  }

  public List<Category> findAllSortedByName() {
    return this.categoryRepository.findAllSortedByName();
  }

  public void update(Long categoryNumber, String categoryName) {
    this.categoryRepository.update(categoryNumber, categoryName);
  }

  public void insert(Long categoryNumber, String categoryName) {
    this.categoryRepository.insert(categoryNumber, categoryName);
  }

  public void delete(Long categoryNumber) {
    this.categoryRepository.delete(categoryNumber);
  }
}
