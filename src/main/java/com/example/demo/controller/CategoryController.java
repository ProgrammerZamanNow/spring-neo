package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.event.CategoryEvent;
import com.example.demo.model.CreateCategoryRequest;
import com.example.demo.model.MandatoryParameter;
import com.example.demo.repository.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
public class CategoryController {

  @Autowired
  private ApplicationContext applicationContext;

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private ApplicationEventPublisher applicationEventPublisher;

  @PostMapping("/categories")
  public Category create(@Valid @RequestBody CreateCategoryRequest request,
                         MandatoryParameter mandatoryParameter){
    log.info(mandatoryParameter.toString());

    Category category = applicationContext.getBean(Category.class);
    category.setName(request.getName());

    categoryRepository.save(category);
    // publish event
    applicationEventPublisher.publishEvent(new CategoryEvent(category));

    return category;
  }
}
