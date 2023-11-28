<%@ page import="com.study.service.BoardService" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.study.dto.CategoryDto" %>
<%@ page import="static com.study.util.Utils.getStartDate" %>
<%@ page import="static com.study.util.Utils.getEndDate" %>
<%@ page import="com.study.dto.BoardDto" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
//    int boardId = Integer.parseInt(request.getParameter("boardId")); // JSP에서 boardId 값 받아오기
//    BoardService boardService = new BoardService();
//    String writer = boardService.getWriterById(boardId);
//
//    request.setAttribute("writer", writer); // writer 값을 request에 저장
%>
<%--<h1>Writer: <%= request.getAttribute("writer") %></h1>--%>



<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Writer</title>
    <%

        List<CategoryDto> categoryList = (List<CategoryDto>) request.getAttribute("categoryList");
        int totalCount = (int) request.getAttribute("totalCount");
        List<BoardDto> boardList = (List<BoardDto>) request.getAttribute("boardList");

        String boardId = (request.getParameter("id") != null) ? request.getParameter("id") : "1";
        out.println("boardId ="+boardId);

        //페이징
        int pageNum = (request.getParameter("pageNum") != null) ? Integer.parseInt(request.getParameter("pageNum")) : 1;
        int amount = 10; //한페이지에 보여줄 게시글 수
        int lastPage = (int) Math.ceil((double)totalCount / amount); // 총 페이지 수
        int pageListLimit = 10; // 최대 페이지 수 << < 1~10 > >>
        int startPage = (pageNum-1) / pageListLimit * pageListLimit + 1; // 인덱스의 시작 페이지
        int endPage = startPage + pageListLimit - 1; //인덱스의 마지막 페이지

        System.out.println("endPage = " + endPage);
        System.out.println("lastPage = " + lastPage);
        System.out.println("startPage = " + startPage);

        // 만약에 endPage가 lastPage보다 클 때는 endPage를 lastPage로 변경!
        if(endPage > lastPage) {
            endPage = lastPage;
        }
        System.out.println("endPage = " + endPage);

    %>

</head>
<body>
<h2>자유게시판 - 목록</h2>
<div class="searchGroup">
    <form action="list" method="get">
        <span>등록일</span>
        <input type="date" name="start_date" value=<%= getStartDate() %>>
        -
        <input type="date" name="end_date" value=<%= getEndDate() %>>
        <select name="category">
            <option value="">전체 카테고리</option>
            <%
                for(CategoryDto ca : categoryList) {
            %>
            <option value=<%= ca.getId() %>><%= ca.getName() %></option>
            <%
                }
            %>
        </select>
        <input type="text" name="search_text" placeholder="검색어를 입력해주세요. (제목+작성자+내용)">
        <input type="submit" value="검색"/>
    </form>
</div>
<div>
    <p>총 <%= totalCount%> 건</p>
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
        <%
            for(BoardDto b : boardList) {
        %>
        <tr>
            <td><%= b.getCategoryName() %></td>
            <td></td> <%-- 첨부파일 유무 --%>
<%--            <td><a href="view.jsp?id=<%= b.getId() %>&pageNum=<%=pageNum%>"><%= b.getTitle() %></a></td>--%>
<%--            <td><a href="view.jsp?id="><%= b.getId() %><%= b.getTitle() %></a></td>--%>
            <td><a href="view?id=<%= b.getId() %>&pageNum=<%=pageNum%>"><%= b.getTitle() %></a></td>
            <td><%= b.getWriter() %></td>
            <td><%= b.getViewCount() %></td>
            <td><%= b.getRegistrationDate() %></td>
            <td><%= b.getModificationDate() != null ? b.getModificationDate() : "-" %></td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
<div class="list_page">
    <% if(pageNum > 1) {%>
    <a href="list?pageNum=<%=pageNum-1%>">Prev</a>
    <%}else {%>
    <a href="javascript:void(0)">Prev</a>

    <%}
        for(int i = startPage; i <= endPage; i++) {%>
    <% if(pageNum == i) {%>
    <a href="javascript:void(0)"><%=i%></a>
    <%}else {%>
    <a href="list?pageNum=<%=i%>"><%=i%></a>
    <%}
    }%>

    <% if(pageNum < lastPage) {%>
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