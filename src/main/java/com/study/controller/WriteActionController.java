package com.study.controller;

import com.study.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class WriteActionController implements Controller {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        BoardService boardService = new BoardService();

        String categoryId = paramMap.get("categoryId");
        String writer = paramMap.get("writer");
        String password = paramMap.get("password");
        String title = paramMap.get("title");
        String content = paramMap.get("content");

        Map<String, Object> bindingParams = new HashMap<>();
        bindingParams.put("categoryId", categoryId);
        bindingParams.put("writer", writer);
        bindingParams.put("password", password);
        bindingParams.put("title", title);
        bindingParams.put("content", content);

        boardService.writeBoard(bindingParams);

        log.info("파라미터 ={}", paramMap);
        log.info("바인딩 파라미터 ={}", bindingParams);


        return "write-result";
    }
}
