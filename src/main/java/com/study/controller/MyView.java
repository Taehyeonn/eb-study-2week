package com.study.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MyView {

    private String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(HttpServletRequest request, HttpServletResponse response){ // throws ServletException, IOException
        System.out.println("asdasdsad viewPath = " + viewPath);
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        System.out.println("dispatcher = " + dispatcher);
//        dispatcher.forward(request, response);
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            System.out.println("MyView.render 에러");
            e.printStackTrace();
        }
    }

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) {
        System.out.println("asdasdsad viewPath = " + viewPath);
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        modelToRequestAttribute(model, request);
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);

        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            System.out.println("MyView.render 에러");
            e.printStackTrace();
        }
    }
    private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        model.forEach((key, value) -> request.setAttribute(key, value));
    }

}
