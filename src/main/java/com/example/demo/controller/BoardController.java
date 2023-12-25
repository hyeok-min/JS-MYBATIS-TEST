package com.example.demo.controller;

import com.example.demo.category.Categories;
import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    @GetMapping("/board/{categories}")
    public String getBoardList(@PathVariable("categories") Categories categories, Model model){
        model.addAttribute("category",categories);
        String cate = categories.name();
        log.info("cate==={}",cate);
        model.addAttribute("board",boardService.findAll(cate));
        log.info("==={}",categories);
        return "boardList";
    }
    @GetMapping("/board/{categories}/{id}")
    public void detailBoard(){}
    @GetMapping("/board/{categories}/update/{id}")
    public void updateBoard(){}
}
