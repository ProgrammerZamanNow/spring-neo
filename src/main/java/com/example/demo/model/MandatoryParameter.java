package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MandatoryParameter {

  private String requestId;

  private String username;

  private String sessionId;
}
