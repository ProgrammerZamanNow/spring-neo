package com.example.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Configuration
public class ThreadpoolConfiguration {

  @Bean
  public Executor myExecutor(){
    return Executors.newFixedThreadPool(10);
  }
}
