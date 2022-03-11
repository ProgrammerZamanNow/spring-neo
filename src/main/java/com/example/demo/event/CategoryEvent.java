package com.example.demo.event;

import com.example.demo.entity.Category;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class CategoryEvent extends ApplicationEvent {

  private Category category;

  public CategoryEvent(Category category) {
    super(category);
    this.category = category;
  }
}
