package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class MemberRepositoryTests {
    @Autowired
    private MemberRepository memberRepository;

    @Test
    public void insertMember() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Member member = Member.builder()
                    .email("user"+i+"@kopo.ac.kr")
                    .password("123456")
                    .name("user"+i)
                    .build();
            memberRepository.save(member);
        });

    }

}
