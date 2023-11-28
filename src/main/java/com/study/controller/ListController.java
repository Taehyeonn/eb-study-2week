package com.study.controller;

import com.study.dto.BoardDto;
import com.study.dto.CategoryDto;
import com.study.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListController implements Controller {
    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 비즈니스 로직 수행 후 뷰의 논리 이름 반환
     * model은 파라미터로 처리
     *
     * @return viewName
     */
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        log.info("ListController 로직 시작");
//        List<Member> members = memberRepository.findAll();
//        model.put("members", members);
        BoardService boardService = new BoardService();

        List<CategoryDto> categoryList = boardService.getCategoryList(); //카테고리 list
        log.info("categoryList ={}", categoryList);

        int totalCount = boardService.getTotalCount(); // 게시물 총 갯수
        log.info("totalCount ={}", totalCount);

        int pageNum = 1; // 현재 페이지
        if (paramMap.get("pageNum") != null) {
            pageNum = Integer.parseInt(paramMap.get("pageNum"));
        }
        int limit = 10; // 한페이지에 보여줄 게시글 갯수
        log.info("boardId ={}", pageNum);
        int start = (pageNum - 1) * 10;
        log.info("start ={}", start);

        Map<String, Object> bindingParams = new HashMap<>(); // 바인딩용 파라미터Map
        bindingParams.put("start", start);
        bindingParams.put("limit", limit);

        List<BoardDto> boardList = boardService.getBoardList(bindingParams);
        log.info("boardList ={}", boardList);

        model.put("categoryList", categoryList);
        model.put("totalCount", totalCount);
        model.put("boardList", boardList);

        return "list";
    }
}
