<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h2>게시판 - 보기</h2>
<div>
    <span>${board.writer}</span>
    <span>${board.registrationDate}</span>
    <span>${board.modificationDate}</span>
</div>
<div>
    <span>${board.categoryName}</span>
    <span>${board.title}</span>
    <span>${board.viewCount}</span>
</div>
<hr>
<div>
    <p>${board.content}</p>
</div>
<div>
    <p>첨부파일</p>
</div>
<div style="background-color: beige">


    <c:choose>
        <c:when test="${empty comments}">
            <p>등록된 댓글이 없습니다.</p>
        </c:when>
        <c:otherwise>
            <c:forEach var="co" items="${comments}">
                <div>
                    <p>${co.registrationDate}</p>
                    <span>${co.content}</span>
                    <hr>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    <div>
        <form action="commentaction" method="get">
            <label><textarea rows="3" cols="112" name="content"></textarea></label>
            <input type="hidden" name="id" value="${id}">
            <input type="hidden" name="pageNum" value="${pageNum}">
            <input type="submit" value="등록">
        </form>
    </div>
</div>
<div>
    <button type="button" onclick="location.href='list?pageNum=${pageNum}'">목록</button>
    <button type="button" onclick="location.href='passwordCheck?id=${id}&pageNum=${pageNum}&type=modify'">수정</button>
    <button type="button" onclick="location.href='passwordCheck?id=${id}&pageNum=${pageNum}&type=delete'">삭제</button>
</div>
</body>
</html>
