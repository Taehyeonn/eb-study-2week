package com.study.controller;

import com.study.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


public class CommentController implements Controller {
    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 댓글 등록 후 comment-result 반환
     */
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        CommentService commentService = new CommentService();

        String id = paramMap.get("id");
        String content = paramMap.get("content");

        Map<String, Object> bindingParams = new HashMap<>();
        bindingParams.put("content", content);
        bindingParams.put("id", id);

        commentService.insertComment(bindingParams);

        model.put("result", "댓글 등록 성공");

        log.info("바인딩 파라미터 ={}", bindingParams);
        log.info("파라미터 ={}", paramMap);

        return "result";
    }
}
