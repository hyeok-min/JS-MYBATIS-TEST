package com.example.demo.service;

import com.example.demo.category.Categories;
import com.example.demo.entity.Board;
import com.example.demo.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardMapper boardMapper;

    public List<Board> findTop10(){return boardMapper.findtop10();}
    public List<Board> findAll(String cate){
        return boardMapper.findAll(cate);
    }
    public Board findById(Map<String,Object> map){return boardMapper.findById(map);}
    public void countBoard(Board board){ boardMapper.countBoard(board);}
    public void insertBoard(Board board){ boardMapper.insertBoard(board);}
    public void deleteBoard(Long id){boardMapper.deleteBoard(id);}
    public void updateBoard(Board board){boardMapper.updateBoard(board);}
}
