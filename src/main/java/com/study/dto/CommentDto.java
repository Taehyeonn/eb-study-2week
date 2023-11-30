package com.study.dto;

import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class CommentDto {
    private int id; //PK
    private int boardId; //FK
    private String content;
    private Timestamp registrationDate;
}
