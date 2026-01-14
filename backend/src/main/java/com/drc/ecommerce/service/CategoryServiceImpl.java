package com.drc.ecommerce.service;

import com.drc.ecommerce.model.Category;
import com.drc.ecommerce.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();

        return categories;
    }

    @Override
    public Category getCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));

        return category;
    }

    @Override
    public Category createCategory(Category category) {
        Category savedCategory = categoryRepository.save(category);

        return savedCategory;
    }

    @Override
    public Category updateCategory(Long categoryId, Category category) {
        Category categoryToUpdate = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));

        // map all properties
        categoryToUpdate.setName(category.getName());

        Category updatedCategory = categoryRepository.save(categoryToUpdate);

        return updatedCategory;
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category categoryToDelete = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
        categoryRepository.delete(categoryToDelete);
    }
}
