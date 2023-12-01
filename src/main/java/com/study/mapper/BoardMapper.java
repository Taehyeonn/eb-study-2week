package com.study.mapper;

import com.study.dto.BoardDto;
import com.study.dto.CategoryDto;

import java.util.List;
import java.util.Map;

public interface BoardMapper {

    // 전체 게시글 출력
    public List<BoardDto> getBoardList(Map<String, Object> bindingParams);

    // 카테고리 리스트 출력
    public List<CategoryDto> getCategoryList();

    // 특정 게시글 출력
    public BoardDto getBoardById(String id);

    // 게시글 총 갯수 출력
    public int getTotalCount();

    // 조회수 증가
    public void increaseViewCount(String id);

    // 글쓰기
    public void writeBoard(Map<String, Object> bindingParams);

    // 글수정
    public void modifyBoard(Map<String, Object> bindingParams);

    // 비밀번호 확인
    public int passwordCheck(Map<String, Object> bindingParams);

    // 글 삭제
    public void deleteBoard(String id);
}
