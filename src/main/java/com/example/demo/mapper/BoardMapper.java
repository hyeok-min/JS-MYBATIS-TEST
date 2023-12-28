package com.example.demo.mapper;

import com.example.demo.category.Categories;
import com.example.demo.entity.Board;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BoardMapper {
    List<Board> findtop10();
    public List<Board> findAll(String cate);
    public Board findById(Map<String,Object> map);
    public void insertBoard(Board board);
    public void deleteBoard(Long id);
    public void updateBoard(Board board);
    public void countBoard(Board board);
}
