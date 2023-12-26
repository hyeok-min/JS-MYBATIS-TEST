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
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    @GetMapping("/board/{categories}")
    public String getBoardList(@PathVariable("categories") Categories categories, Model model){
        log.info("====boardlist in====");
        model.addAttribute("category",categories);
        String cate = categories.name();
        log.info("cate==={}",cate);
        model.addAttribute("board",boardService.findAll(cate));
        log.info("==={}",categories);
        return "boards/boardList";
    }
    @GetMapping("/board/{categories}/{id}")
    public String getBoardDetail(@PathVariable("categories") Categories categories,@PathVariable("id") Long id,Model model){
        log.info("====boarddetail in====");
        Map<String,Object> map =new HashMap<>();
        model.addAttribute("category",categories);
        String cate = categories.name();
        map.put("cate",cate);
        map.put("id",id);
        model.addAttribute("board",boardService.findById(map));
        return "boards/detailBoard";
    }

//    @PostMapping("/board/{categories}/insert")
//    public Board insertBoard(Board board){
//
//    }
//
//    @GetMapping("/board/{categories}/update/{id}")
//    public void updateBoard(){}
//

}
