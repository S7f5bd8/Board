package com.example.demo.repository;

import com.example.demo.entity.Board;
import com.example.demo.entity.Member;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTests {
    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertBoard() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Member member = Member.builder()
                    .email("user"+i+"@kopo.ac.kr")
                    .build();

            Board board = Board.builder()
                    .title("Title " + i)
                    .content("Content " + i)
                    .writer(member)
                    .build();
            boardRepository.save(board);
        });

    }
    @Transactional
    @Test
    public void testRead(){
        Optional<Board> result = boardRepository.findById(5L);
        Board board = result.get();

        System.out.println(board);
        System.out.println(board.getWriter());
    }

    @Test
    public void testReadWithWriter(){
        Object result = boardRepository.getBoarWithWriter(10L);
        Object[] arr = (Object[]) result;
        System.out.println(Arrays.toString(arr));

    }
}
