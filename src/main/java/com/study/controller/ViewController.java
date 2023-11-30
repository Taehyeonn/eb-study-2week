package com.study.controller;

import com.study.dto.BoardDto;
import com.study.dto.CommentDto;
import com.study.service.BoardService;
import com.study.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

import static com.study.util.BoardInfo.DEFAULT_PAGE_NUMBER;

public class ViewController implements Controller {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        log.info("ViewController 로직 시작");
        BoardService boardService = new BoardService();
        CommentService commentService = new CommentService();

        log.info("파라미터값 ={}",paramMap);

        int pageNum = (paramMap.get("pageNum") != null) ? Integer.parseInt(paramMap.get("pageNum")) : DEFAULT_PAGE_NUMBER; //현재 페이지(기본값 1)
        String id = paramMap.get("id");
        log.info("아이디 ={}",id);

        model.put("pageNum", pageNum);
        model.put("id", id);

        boardService.increaseViewCount(id);
        BoardDto board = boardService.getBoardById(id);
        List<CommentDto> comments = commentService.getCommentsByBoardId(id);
        log.info("댓글 Map ={}",comments);

        model.put("board", board);
        model.put("comments", comments);

        return "view";
    }
}
