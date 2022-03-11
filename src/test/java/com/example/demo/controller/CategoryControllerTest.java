package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.model.CreateCategoryRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CategoryControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  void testCreate() {
    CreateCategoryRequest body = new CreateCategoryRequest();
    body.setName("Contoh");

    URI endpoint = URI.create("http://localhost:" + port + "/categories");
    RequestEntity<CreateCategoryRequest> request = new RequestEntity<>(body, HttpMethod.POST, endpoint);

    ResponseEntity<Category> response = restTemplate.exchange(request, Category.class);

    Assertions.assertEquals(200, response.getStatusCodeValue());
    Assertions.assertEquals("Contoh", response.getBody().getName());
    Assertions.assertNotNull(response.getBody().getId());
    Assertions.assertNotNull(response.getBody().getCreatedAt());
    Assertions.assertNotNull(response.getBody().getUpdatedAt());
  }
}
