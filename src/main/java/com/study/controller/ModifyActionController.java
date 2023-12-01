package com.study.controller;

import com.study.service.BoardService;
import com.study.util.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class ModifyActionController implements Controller {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        BoardService boardService = new BoardService();
        Validation validation = new Validation();

        String id = paramMap.get("id");
        String writer = paramMap.get("writer");
        String password = paramMap.get("password");
        String title = paramMap.get("title");
        String content = paramMap.get("content");

        Map<String, Object> pwCheckParams = new HashMap<>();
        pwCheckParams.put("id", id);
        pwCheckParams.put("password", password);

        Map<String, Object> bindingParams = new HashMap<>();
        bindingParams.put("writer", writer);
        bindingParams.put("title", title);
        bindingParams.put("content", content);
        bindingParams.put("id", id);


        log.info("파라미터 ={}", paramMap);
        log.info("바인딩 파라미터 ={}", bindingParams);


        boolean isVali = validation.isWriter(writer) && validation.isPassword(password)
                        && validation.isContent(content) && validation.isTitle(title); // 유효성 검사

        boolean isPassword = boardService.passwordCheck(pwCheckParams) == 1; // boardId와 password가 일치하는지 확인.

        /**
         * 유효성검사와 패스워드 검사 모두 통과시 수정 로직 실행
         */
        if (isVali && isPassword){

            boardService.modifyBoard(bindingParams);
            model.put("result", "수정 성공");
        } else {
            model.put("result", "수정 실패");
        }

        return "result";
    }
}
