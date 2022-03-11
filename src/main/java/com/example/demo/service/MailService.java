package com.example.demo.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailService {

  @SneakyThrows
  @Async("myExecutor")
  public void send(String to , String message){
    log.info("Send email {}", Thread.currentThread().getName());
    Thread.sleep(5000);
    log.info("Finish send email {}", Thread.currentThread().getName());
  }
}
