package com.study.controller;

import com.study.service.BoardService;
import com.study.util.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class WriteActionController implements Controller {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        BoardService boardService = new BoardService();
        Validation validation = new Validation();

        String categoryId = paramMap.get("categoryId");
        String writer = paramMap.get("writer");
        String password = paramMap.get("password");
        String confirmPassword = paramMap.get("confirmPassword");
        String title = paramMap.get("title");
        String content = paramMap.get("content");

        Map<String, Object> bindingParams = new HashMap<>();
        bindingParams.put("categoryId", categoryId);
        bindingParams.put("writer", writer);
        bindingParams.put("password", password);
        bindingParams.put("title", title);
        bindingParams.put("content", content);


        log.info("파라미터 ={}", paramMap);
        log.info("바인딩 파라미터 ={}", bindingParams);


        /**
         * 서버 유효성검사 수행후 통과시 글 등록 로직 실행
         */
        if (validation.isWriter(writer) && validation.isCategory(categoryId) && validation.isContent(content)
            && validation.isPassword(password, confirmPassword) && validation.isTitle(title)) {

            boardService.writeBoard(bindingParams);
            model.put("result", "등록 성공");
        } else {
            model.put("result", "등록 실패");
        }

        return "write-result";
    }
}
