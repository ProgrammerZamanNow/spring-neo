package com.example.module.bri;

import com.example.demo.entity.PaymentType;
import com.example.demo.model.PaymentRequest;
import com.example.demo.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class BriPaymentService implements PaymentService {

  @Override
  public boolean isSupport(PaymentType type) {
    return type == PaymentType.BANK_BRI;
  }

  @Override
  public String pay(PaymentRequest request) {
    return "BRI";
  }
}
