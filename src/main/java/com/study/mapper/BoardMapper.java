package com.study.mapper;

import com.study.dto.BoardDto;
import com.study.dto.CategoryDto;

import java.util.List;
import java.util.Map;

public interface BoardMapper {
    String selectWriterById(int boardId);

    // 전체 게시글 출력
    public List<BoardDto> getBoardList(Map<String, Object> bindingParams);

    public List<CategoryDto> getCategoryList();

//    // 특정 게시글 출력
//    public BoardDto getBoardById();
//
    // 게시글 총 갯수 출력
    public int getTotalCount();
//
//    // 글쓰기
//    public void write();
//
//    // 글수정
//    public void modify();
//
//    // 글 삭제
//    public void delete();
}
