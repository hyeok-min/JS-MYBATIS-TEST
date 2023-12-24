package com.example.demo.controller;

import com.example.demo.category.Categories;
import com.example.demo.entity.Board;
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

    @GetMapping("/board/{categories}")
    public String getBoardList(@PathVariable("categories") Categories categories, Model model){
        model.addAttribute("category",categories);
        log.info("==={}",categories);
        return "boards/board";
    }
}
