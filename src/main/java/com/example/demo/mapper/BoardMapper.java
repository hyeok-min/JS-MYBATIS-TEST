package com.example.demo.mapper;

import com.example.demo.category.Categories;
import com.example.demo.entity.Board;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardMapper {
    public List<Board> findAll(String cate);
}
