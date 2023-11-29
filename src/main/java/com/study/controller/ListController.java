package com.study.controller;

import com.study.dto.BoardDto;
import com.study.dto.CategoryDto;
import com.study.service.BoardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.study.util.BoardInfo.*;
import static com.study.util.Utils.getEndDate;
import static com.study.util.Utils.getStartDate;

public class ListController implements Controller {
    private final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 카테고리, 게시글목록, 게시글 개수, 페이징변수를 얻어서 Model에 저장 후 논리주소 반환
     *
     * @return list
     */
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        log.info("ListController 로직 시작");
        BoardService boardService = new BoardService();

        int totalCount = boardService.getTotalCount(); // 게시물 총 갯수 쿼리호출
        log.info("totalCount ={}", totalCount);

        List<CategoryDto> categoryList = boardService.getCategoryList(); //카테고리 list 쿼리호출
        log.info("categoryList ={}", categoryList);

        int pageNum = (paramMap.get("pageNum") != null) ? Integer.parseInt(paramMap.get("pageNum")) : DEFAULT_PAGE_NUMBER; //현재 페이지(기본값 1)
        addPageInfoToMap(model, pageNum, totalCount); // 페이지 네비게이션에 필요한 요소들을 모델에 저장하는 메서드

        int start = (pageNum - 1) * PAGE_LIMIT; //페이징 시작 num
        Map<String, Object> bindingParams = new HashMap<>(); // 게시글 조회 쿼리 바인딩용 파라미터Map
        bindingParams.put("start", start);
        bindingParams.put("limit", PAGE_LIMIT);
        log.info("bindingParams ={}", bindingParams);

        List<BoardDto> boardList = boardService.getBoardList(bindingParams); // 게시글 list 쿼리호출
        log.info("boardList ={}", boardList);

        // list.jsp 달력용 values
        model.put("startDate", getStartDate());
        model.put("endDate", getEndDate());

        // 현 페이지, 카테고리, 총게시글갯수, 게시글(10개단위)
        model.put("pageNum", pageNum);
        model.put("categoryList", categoryList);
        model.put("totalCount", totalCount);
        model.put("boardList", boardList);

        return "list";
    }


    /**
     * 페이징 네비게이션에 필요한 동적 변수들을 Map에 저장하는 메서드
     */
    private void addPageInfoToMap(Map<String, Object> model, int pageNum, int totalCount) {

        int maxPage = (int) Math.ceil((double)totalCount / PAGE_LIMIT); // 페이지의 전체 개수
        int startPage = (pageNum-1) / PAGE_LIST_LIMIT * PAGE_LIST_LIMIT + 1; // 인덱스의 시작 페이지
        int endPage = startPage + PAGE_LIST_LIMIT - 1; //인덱스의 마지막 페이지

        // 만약에 endPage가 lastPage보다 클 때는 endPage를 lastPage로 변경!
        if(endPage > maxPage) {
            endPage = maxPage;
        }

        //페이징용 파라미터
        model.put("maxPage", maxPage);
        model.put("startPage", startPage);
        model.put("endPage", endPage);
        //
    }
}
