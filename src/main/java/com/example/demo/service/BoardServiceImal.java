package com.example.demo.service;
import com.example.demo.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImal implements BoardService {
    private final BoardRepository repository;
    @Override
    public Long register(BoardDTO dto) {
        Board board = dtoToEntity(dto);
        repository.save(board);
        return null;
    }
}
