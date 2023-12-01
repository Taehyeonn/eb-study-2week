package com.study.util;


/**
 * 파라미터의 유효성 검증 후 통과시 TRUE 반환
 */
public class Validation {

    public boolean isWriter(String writer) {
        return writer != null && !writer.trim().isEmpty() && writer.length() >= 3 && writer.length() < 5;
    }

    public boolean isPassword(String password) {
        return password != null && !password.trim().isEmpty() && password.length() >= 4 && password.length() < 16 &&
                password.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=]).*$");
    }

    public boolean isPassword(String password, String confirmPassword) {
        return password != null && !password.trim().isEmpty() && password.length() >= 4 && password.length() < 16 &&
                password.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=]).*$") && password.equals(confirmPassword);
    }

    public boolean isCategory(String category) {
        return category != null && !category.trim().isEmpty();
    }

    public boolean isTitle(String title) {
        return title != null && !title.trim().isEmpty() && title.length() >= 4 && title.length() < 100;
    }

    public boolean isContent(String content) {
        return content != null && !content.trim().isEmpty() && content.length() >= 4 && content.length() < 2000;
    }
}
