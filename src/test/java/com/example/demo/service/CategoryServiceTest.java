package com.example.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.ConstraintViolationException;

@SpringBootTest
public class CategoryServiceTest {

  @Autowired
  private CategoryService categoryService;

  @Test
  void testFindByIdInvalid() {
    Assertions.assertThrows(ConstraintViolationException.class, () -> {
      categoryService.findById("");
    });
  }
}
