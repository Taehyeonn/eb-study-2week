<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Writer</title>
    <%
        //페이징 변수 선언
        int pageNum = (int) request.getAttribute("pageNum");
        int startPage = (int) request.getAttribute("startPage");
        int endPage = (int) request.getAttribute("endPage");
        int maxPage = (int) request.getAttribute("maxPage");
    %>

</head>
<body>
<h2>자유게시판 - 목록</h2>
<div class="searchGroup">
    <form action="list" method="get">
        <span>등록일</span>
        <input type="date" name="start_date" value=${startDate}>
        -
        <input type="date" name="end_date" value=${endDate}>
        <select name="category">
            <option value="">전체 카테고리</option>
            <c:forEach var="ca" items="${categoryList}">
                <option value=${ca.id}>${ca.name}</option>
            </c:forEach>
        </select>
        <input type="text" name="search_text" placeholder="검색어를 입력해주세요. (제목+작성자+내용)">
        <input type="submit" value="검색"/>
    </form>
</div>
<div>
    <p>총 ${totalCount}건</p>
</div>
<div>
    <table>
        <thead>
            <tr>
                <td>카테고리</td>
                <td>첨부</td>
                <td>제목</td>
                <td>작성자</td>
                <td>조회수</td>
                <td>등록일시</td>
                <td>수정일시</td>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="bo" items="${boardList}">
                <tr>
                    <td>${bo.categoryName}</td>
                    <td></td>
                    <c:choose>
                        <c:when test="${bo.title.length() > 80}">
                            <td><a href="view?id=${bo.id}&pageNum=${pageNum}">${(bo.title.substring(0,81))}...</a></td>
                        </c:when>
                        <c:otherwise>
                            <td><a href="view?id=${bo.id}&pageNum=${pageNum}">${bo.title}</a></td>
                        </c:otherwise>
                    </c:choose>
                    <td>${bo.writer}</td>
                    <td>${bo.viewCount}</td>
                    <td><fmt:formatDate value='${bo.registrationDate}' pattern='yyyy.MM.dd HH:MM' /></td>
                    <c:choose>
                        <c:when test="${bo.modificationDate != null}">
                            <fmt:formatDate value='${bo.modificationDate}' pattern='yyyy.MM.dd HH:MM' />
                        </c:when>
                        <c:otherwise>
                            <td>-</td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<div class="list_page">
    <% if(pageNum > 1) {%>
    <a href="list?pageNum=<%=pageNum-1%>">Prev</a>
    <%}else {%>
    <a href="javascript:void(0)">Prev</a>
    <%}%>

    <% for(int i = startPage; i <= endPage; i++) {%>
     <% if(pageNum == i) {%>
        <a href="javascript:void(0)"><%=i%></a>
        <%}else {%>
       <a href="list?pageNum=<%=i%>"><%=i%></a>
        <%}
    }%>

    <% if(pageNum < maxPage) {%>
    <a href="list?pageNum=<%=pageNum+1%>">Next</a>
    <%}else {%>
    <a href="javascript:void(0)">Next</a>
    <%}%>
</div>
<div class="list_button">
    <button type="button" onclick="location.href='write?pageNum=<%= pageNum %>'">등록</button>
</div>
</body>
</html>