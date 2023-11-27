package com.study.controller;

import java.util.Map;

public class ListController implements Controller {


    /**
     * 비즈니스 로직 수행 후 뷰의 논리 이름 반환
     * model은 파라미터로 처리
     *
     * @return viewName
     */
    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        System.out.println("ListController.process");

//        List<Member> members = memberRepository.findAll();
//        model.put("members", members);
        
        return "list";
    }
}
