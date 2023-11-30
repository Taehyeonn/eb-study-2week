package com.study.mapper;

import com.study.dto.CommentDto;

import java.util.List;
import java.util.Map;

public interface CommentMapper {

    // 댓글 조회
    public List<CommentDto> getCommentsByBoardId(String id);

    // 댓글 작성
    public void insertComment(Map<String, Object> params);

}
