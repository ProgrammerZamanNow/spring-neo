package com.example.demo.service;

import com.example.demo.entity.PaymentType;
import com.example.demo.model.PaymentRequest;

public interface PaymentService {

  boolean isSupport(PaymentType type);

  String pay(PaymentRequest request);

}
