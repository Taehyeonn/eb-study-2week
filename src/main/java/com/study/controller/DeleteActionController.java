package com.study.controller;

import com.study.service.BoardService;
import com.study.util.Validation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class DeleteActionController implements Controller{
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        BoardService boardService = new BoardService();
        Validation validation = new Validation();

        String id = paramMap.get("id");
        String password = paramMap.get("password");

        Map<String, Object> pwCheckParams = new HashMap<>();
        pwCheckParams.put("id", id);
        pwCheckParams.put("password", password);

        boolean isVali = validation.isPassword(password); // 유효성 검사
        boolean isPassword = boardService.passwordCheck(pwCheckParams) == 1; // boardId와 password가 일치하는지 확인.

        log.info("model Map ={}", model);

        /**
         * 유효성검사와 패스워드 검사 모두 통과시 수정 로직 실행
         */
        if (isVali && isPassword){
            boardService.deleteBoard(id);
            model.put("result", "삭제 성공");
        } else {
            model.put("result", "삭제 실패");
        }

        return "result";
    }
}
