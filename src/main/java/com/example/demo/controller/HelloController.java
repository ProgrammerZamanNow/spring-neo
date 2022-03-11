package com.example.demo.controller;

import com.example.demo.model.MandatoryParameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  @GetMapping("/hello")
  public String hello(MandatoryParameter mandatoryParameter,
                      @RequestParam("name") String name){
    return "Hello " + name;
  }

}
