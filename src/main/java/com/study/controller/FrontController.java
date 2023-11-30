package com.study.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet("/")
public class FrontController extends HttpServlet {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private final Map<String, Controller> controllerMap = new HashMap<>();

    public FrontController() {
        log.info("FrontController 생성자 실행");
        controllerMap.put("/board/free/list", new ListController());
        controllerMap.put("/board/free/view", new ViewController());
        controllerMap.put("/board/free/commentaction", new CommentController());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.info("프론트 컨트롤러 실행 실행");

        // 1. request 객체의 요청 url를 가져온다.
        String requestURI = request.getRequestURI();
        log.info("접근 URI ={}", requestURI);

        // 2. 요청 url과 매칭하는 Controller 객체를 controllerMap에서 가져온다.
        Controller controller = controllerMap.get(requestURI);

        if(controller == null) { // 예외처리 - 매핑에 없는 url이 요청됐을 때
            log.info("404");
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // 3. 컨트롤러에게 넘겨줄 파라미터, 모델 Map 생성
        Map<String, String> paramMap = createParamMap(request);
        log.info("request의 param 값 ={}", paramMap);
        Map<String, Object> model = new HashMap<>();

        // 4. 컨트롤러에서 비즈니스로직 수행 후 뷰의 논리값을 받은 뒤 포워드
        String viewName = controller.process(paramMap, model);
        MyView view = viewResolver(viewName);
        log.info("로직실행후 컨트롤러에서 받아온 model 값 ={}", model);

//            view.render(request, response);
        view.render(model, request, response);

    }


    /**
     * request에 들어있는 파라미터들을 Map에 저장
     *
     * @param request
     * @return paramMap
     */
    private Map<String, String> createParamMap(HttpServletRequest request) {
        log.info("createParamMap 실행");
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator() // 모든 url 파라미터를 가져오기 위해 Iterator 사용
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName))); //url파라미터의 이름을 Key로, value는 url 파라미터의 값으로 저장한다.
        return paramMap;
    }

    /**
     * 각 컨트롤러에서 반환받은 논리이름을 view(.jsp) 경로로 만든다
     *
     * @param viewName
     * @return "/board/free/list.jsp"
     */
    private MyView viewResolver(String viewName) {
        log.info("viewResolver 실행");
        return new MyView("/board/free/" + viewName + ".jsp");
    }
}
