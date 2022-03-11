package com.example.demo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MailServiceTest {

  @Autowired
  private MailService mailService;

  @Test
  void testSend() throws InterruptedException {
    mailService.send("eko@gmail.com", "hello");

    Thread.sleep(6000);
  }
}
