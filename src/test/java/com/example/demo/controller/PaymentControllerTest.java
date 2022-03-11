package com.example.demo.controller;

import com.example.demo.entity.Category;
import com.example.demo.entity.PaymentType;
import com.example.demo.model.CreateCategoryRequest;
import com.example.demo.model.PaymentRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import java.net.URI;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PaymentControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  void testCreate() {
    PaymentRequest body = new PaymentRequest();
    body.setType(PaymentType.BANK_NEO);

    URI endpoint = URI.create("http://localhost:" + port + "/pay");
    RequestEntity<PaymentRequest> request = new RequestEntity<>(body, HttpMethod.POST, endpoint);

    ResponseEntity<String> response = restTemplate.exchange(request, String.class);

    Assertions.assertEquals(200, response.getStatusCodeValue());
    Assertions.assertEquals("NEO", response.getBody());
  }

  @Test
  void testBca() {
    PaymentRequest body = new PaymentRequest();
    body.setType(PaymentType.BANK_BCA);

    URI endpoint = URI.create("http://localhost:" + port + "/pay");
    RequestEntity<PaymentRequest> request = new RequestEntity<>(body, HttpMethod.POST, endpoint);

    ResponseEntity<String> response = restTemplate.exchange(request, String.class);

    Assertions.assertEquals(200, response.getStatusCodeValue());
    Assertions.assertEquals("BCA", response.getBody());
  }

  @Test
  void testMandiri() {
    PaymentRequest body = new PaymentRequest();
    body.setType(PaymentType.BANK_MANDIRI);

    URI endpoint = URI.create("http://localhost:" + port + "/pay");
    RequestEntity<PaymentRequest> request = new RequestEntity<>(body, HttpMethod.POST, endpoint);

    ResponseEntity<String> response = restTemplate.exchange(request, String.class);

    Assertions.assertEquals(200, response.getStatusCodeValue());
    Assertions.assertEquals("MANDIRI", response.getBody());
  }

  @Test
  void testJago() {
    PaymentRequest body = new PaymentRequest();
    body.setType(PaymentType.BANK_JAGO);

    URI endpoint = URI.create("http://localhost:" + port + "/pay");
    RequestEntity<PaymentRequest> request = new RequestEntity<>(body, HttpMethod.POST, endpoint);

    ResponseEntity<String> response = restTemplate.exchange(request, String.class);

    Assertions.assertEquals(200, response.getStatusCodeValue());
    Assertions.assertEquals("JAGO", response.getBody());
  }

  @Test
  void testBri() {
    PaymentRequest body = new PaymentRequest();
    body.setType(PaymentType.BANK_BRI);

    URI endpoint = URI.create("http://localhost:" + port + "/pay");
    RequestEntity<PaymentRequest> request = new RequestEntity<>(body, HttpMethod.POST, endpoint);

    ResponseEntity<String> response = restTemplate.exchange(request, String.class);

    Assertions.assertEquals(200, response.getStatusCodeValue());
    Assertions.assertEquals("BRI", response.getBody());
  }
}
