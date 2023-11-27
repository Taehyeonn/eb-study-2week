package com.study.dto;


import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
public class BoardDto {
    private int id; //게시글 번호
    private int categoryId; //카테고리 코드 1:spring 2:java 등
    private String writer;
    private String password;
    private String title;
    private String content;
    private String view_count ; // 조회수
    private Timestamp registration_date; //등록날짜
    private Timestamp modification_date; //수정날짜
}
