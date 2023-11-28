package com.study.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MyView {

    private final Logger log = LoggerFactory.getLogger(getClass());
    private String viewPath;


    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    /**
     * view로 이동하는 메서드(model 없이)
     */
    public void render(HttpServletRequest request, HttpServletResponse response){
        log.info("Myview.render 실행 viewPath ={}", viewPath);

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        System.out.println("dispatcher = " + dispatcher);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            log.error("MyView.render 에러 ={}", e, e);
        }
    }

    /**
     * 컨트롤러에서 model을 받아 view로 보내주는 메서드
     */
    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
        log.info("viewPath ={}", viewPath);

        modelToRequestAttribute(model, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
//        log.info("model ={}", request.getAttribute("model"));

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            log.error("MyView.render 에러 ={}", e, e);
        }
    }

    /**
     * model 값을 request Attribute에 저장해주는 메서드
     */
    private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
//        log.info("model ={}", model);
        model.forEach((key, value) -> request.setAttribute(key, value));
    }

}
