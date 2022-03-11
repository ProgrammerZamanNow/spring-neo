package com.example.demo.listener;

import com.example.demo.entity.Category;
import com.example.demo.event.CategoryEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CategoryListener {

  @EventListener(CategoryEvent.class)
  public void onCategoryEvent(CategoryEvent event){
    Category category = event.getCategory();
    log.info("Receive event category {} : {}", category.getId(), category.getName());
  }

  @EventListener(CategoryEvent.class)
  public void onCategoryEvent2(CategoryEvent event){
    Category category = event.getCategory();
    log.info("2: Receive event category {} : {}", category.getId(), category.getName());
  }
}
