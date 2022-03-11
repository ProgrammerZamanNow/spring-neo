package com.example.demo.controller;

import com.example.demo.model.PaymentRequest;
import com.example.demo.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class PaymentController {

  @Autowired
  private ApplicationContext applicationContext;

  @PostMapping("/pay")
  public String pay(@RequestBody PaymentRequest request){
    return applicationContext.getBeansOfType(PaymentService.class).values().stream()
        .filter(paymentService -> paymentService.isSupport(request.getType()))
        .findFirst()
        .map(paymentService -> paymentService.pay(request))
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
  }
}
