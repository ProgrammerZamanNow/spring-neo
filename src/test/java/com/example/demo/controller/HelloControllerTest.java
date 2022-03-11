package com.example.demo.controller;

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
public class HelloControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  void testHello() {
    URI endpoint = URI.create("http://localhost:" + port + "/hello?name=Eko");
    RequestEntity<String> request = new RequestEntity<>(HttpMethod.GET, endpoint);

    ResponseEntity<String> response = restTemplate.exchange(request, String.class);

    Assertions.assertEquals(200, response.getStatusCodeValue());
    Assertions.assertEquals("Hello Eko", response.getBody());
  }
}
