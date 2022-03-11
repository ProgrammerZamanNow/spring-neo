package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.model.CreateCategoryRequest;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CategoryController {

  @Autowired
  private ApplicationContext applicationContext;

  @Autowired
  private CategoryRepository categoryRepository;

  @PostMapping("/categories")
  public Category create(@Valid @RequestBody CreateCategoryRequest request){
    Category category = applicationContext.getBean(Category.class);
    category.setName(request.getName());

    return categoryRepository.save(category);
  }
}
