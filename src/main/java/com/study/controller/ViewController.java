package com.study.controller;

import java.util.Map;

public class ViewController implements Controller {
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        System.out.println("ViewController.process");
        return "view";
    }
}
