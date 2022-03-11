package com.example.demo.controller;

import com.example.demo.entity.PaymentType;
import com.example.demo.model.PaymentRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import java.net.URI;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(
    properties = {
        "payment.bri.active=false"
    }
)
public class BriPaymentControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Test
  void testBri() {
    PaymentRequest body = new PaymentRequest();
    body.setType(PaymentType.BANK_BRI);

    URI endpoint = URI.create("http://localhost:" + port + "/pay");
    RequestEntity<PaymentRequest> request = new RequestEntity<>(body, HttpMethod.POST, endpoint);

    ResponseEntity<String> response = restTemplate.exchange(request, String.class);

    Assertions.assertEquals(404, response.getStatusCodeValue());
  }
}
