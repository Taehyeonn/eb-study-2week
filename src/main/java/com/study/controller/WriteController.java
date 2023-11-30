package com.study.controller;

import com.study.dto.CategoryDto;
import com.study.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class WriteController implements Controller {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        BoardService boardService = new BoardService();

        String pageNum = paramMap.get("pageNum");
        List<CategoryDto> categoryList = boardService.getCategoryList();

        model.put("categoryList", categoryList);
        model.put("pageNum", pageNum);

        log.info("categoryList Map ={}",categoryList);
        log.info("pageNum Map ={}",pageNum);



        return "write";
    }
}
