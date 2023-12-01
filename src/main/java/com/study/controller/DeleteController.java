package com.study.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class DeleteController implements Controller{
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {

        String id = paramMap.get("id");

        model.put("id", id);

        log.info("model Map ={}",model);
        log.info("paramMap Map ={}",paramMap);


        return "delete";
    }
}
