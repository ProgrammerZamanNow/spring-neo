package com.example.demo.configuration;

import com.example.demo.entity.Category;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.UUID;

@Configuration
public class EntityConfiguration {

  @Bean
  @Scope("prototype")
  public Category category(){
    Category category = new Category();
    category.setId(UUID.randomUUID().toString());
    category.setCreatedAt(System.currentTimeMillis());
    category.setUpdatedAt(System.currentTimeMillis());
    return category;
  }

}
