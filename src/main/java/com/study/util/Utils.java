package com.study.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utils {

    /**
     * list.jsp 달력에 들어갈 1년전 날짜 구하기
     */
    public static String getStartDate() {
        LocalDate currentDate = LocalDate.now();
        LocalDate oneYearAgo = currentDate.minusYears(1);
        return oneYearAgo.format(DateTimeFormatter.ISO_LOCAL_DATE); //16:24:02.408
    }

    /**
     * list.jsp 달력에 들어갈 오늘 날짜 구하기
     */
    public static String getEndDate() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
}
