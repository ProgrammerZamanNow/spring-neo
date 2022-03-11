package com.example.demo.service;

import com.example.demo.model.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

  @Autowired
  private MemberService memberService;

  @Test
  void testFindById() throws ExecutionException, InterruptedException {
    Future<Member> memberFuture1 = memberService.findById("1");
    Future<Member> memberFuture2 = memberService.findById("2");
    Future<Member> memberFuture3 = memberService.findById("3");

    memberFuture1.get();
    memberFuture2.get();
    memberFuture3.get();
  }
}