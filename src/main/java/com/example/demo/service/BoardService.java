package com.example.demo.service;

import com.example.demo.category.Categories;
import com.example.demo.entity.Board;
import com.example.demo.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardMapper boardMapper;

    public List<Board> findAll(String cate){
        return boardMapper.findAll(cate);
    }
}
