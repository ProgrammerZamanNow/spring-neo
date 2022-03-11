package com.example.demo.service;

import com.example.demo.entity.PaymentType;
import com.example.demo.model.PaymentRequest;
import org.springframework.stereotype.Service;

@Service
public class MandiriPaymentService implements PaymentService{

  @Override
  public boolean isSupport(PaymentType type) {
    return type == PaymentType.BANK_MANDIRI;
  }

  @Override
  public String pay(PaymentRequest request) {
    return "MANDIRI";
  }
}
