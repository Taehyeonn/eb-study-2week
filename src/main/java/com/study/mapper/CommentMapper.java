package com.study.mapper;

import com.study.dto.CommentDto;

import java.util.List;

public interface CommentMapper {

    // 댓글 조회
    public List<CommentDto> getCommentsByBoardId(String id);

}
