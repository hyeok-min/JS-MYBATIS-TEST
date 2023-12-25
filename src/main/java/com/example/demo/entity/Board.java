package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    private long boardId;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime dateTime;
    private Long count;
    private String category;
}
