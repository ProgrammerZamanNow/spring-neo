package com.example.demo.model;

import com.example.demo.entity.PaymentType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentRequest {

  private PaymentType type;

  private String orderId;

  private Long amount;
}
