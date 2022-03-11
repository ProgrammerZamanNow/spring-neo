package com.example.demo.service;

import com.example.demo.model.Member;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class MemberService {

  @SneakyThrows
  @Async("myExecutor")
  public Future<Member> findById(String id){
    log.info("find member by id {}", id);
    Thread.sleep(5000);

    Member member = new Member();
    member.setId(id);
    member.setName("Contoh");

    log.info("finish find member by id {}", id);
    return new AsyncResult<>(member);
  }
}
