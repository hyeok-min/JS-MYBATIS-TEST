package com.example.demo.controller;

import com.example.demo.category.Categories;
import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/home")
    public String getTop10(Model model){
        model.addAttribute("board",boardService.findTop10());
        return "home";
    }
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
        Board board=boardService.findById(map);
        board.setCount(board.getCount() + 1);
        boardService.countBoard(board);
        model.addAttribute("board",board);
        return "boards/detailBoard";
    }
    @GetMapping("/board/insert/{categories}")
    public String insertBoard(@PathVariable("categories") Categories categories,Model model){
        model.addAttribute("category",categories);
        return "boards/insertBoard";
    }
    @PostMapping("/board/insert/{categories}")
    public String insertBoard(@PathVariable("categories") Categories categories,Board board){
        boardService.insertBoard(board);
        String end="redirect:/board/"+categories;
        return end;
    }

    @GetMapping("/board/{categories}/update/{id}")
    public String updateBoard(@PathVariable("categories") Categories categories,@PathVariable("id") Long id,Model model){
        log.info("====update in====");
        Map<String,Object> map =new HashMap<>();
        model.addAttribute("category",categories);
        String cate = categories.name();
        map.put("cate",cate);
        map.put("id",id);
        model.addAttribute("board",boardService.findById(map));
        log.info("{}",boardService.findById(map));
        return "boards/updateBoard"; }
    @PostMapping("/board/{categories}/update/{id}")
    public String updateBoard(@PathVariable("categories") Categories categories,@PathVariable("id") Long id,Board board){
        board.setBoardId(id);
        boardService.updateBoard(board);
        String end="redirect:/board/"+categories+"/"+id;
        return end;
    }

    @GetMapping("/board/{categories}/delete/{id}")
    public String deleteBoard(@PathVariable("categories") Categories categories,@PathVariable("id") Long id){
        log.info("==delete in =====");
        boardService.deleteBoard(id);
        String end="redirect:/board/"+categories;
        log.info("====delete end ===={}",end);
        return end;
    }

}
