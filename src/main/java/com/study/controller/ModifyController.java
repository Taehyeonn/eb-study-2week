package com.study.controller;

import com.study.dto.BoardDto;
import com.study.dto.CategoryDto;
import com.study.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class ModifyController implements Controller {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        BoardService boardService = new BoardService();

        String pageNum = paramMap.get("pageNum");
        String id = paramMap.get("id");

        BoardDto board = boardService.getBoardById(id);

        model.put("pageNum", pageNum);
        model.put("board", board);

        model.put("id", id);

        log.info("model Map ={}", model);
        log.info("pageNum Map ={}",pageNum);

        return "modify";
    }
}
