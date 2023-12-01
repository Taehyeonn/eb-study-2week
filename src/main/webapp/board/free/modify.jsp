<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script>
        /**
         * 글 등록 버튼 클릭시 유효성 검사 실행하여 성공 여부 반환
         * @returns {boolean}
         */
        function checkForm() {
            let writer = document.getElementById("writer").value.trim();
            let password = document.getElementById("password").value.trim();
            let title = document.getElementById("title").value;
            let content = document.getElementById("content").value;
            // let password = document.getElementById("password").value; 파일

            if (writer === "" || writer.length < 3 || writer.length >= 5 ){
                alert("작성자는 3글자 이상 5글자 미만이어야 합니다.");
                return false;
            }

            if (password === "" || password.length < 4 || password.length >= 16
                || !password.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=]).*$") ){
                alert("비밀번호는 4글자 이상 16글자 미만, 영문/숫자/특수문자(@#$%^&+=) 포함");
                return false;
            }

            if (title === "" || title.length() < 4 || title.length() >= 100){
                alert("제목은 4글자 이상 100글자 미만이어야 합니다.");
                return false;
            }

            if (content === "" || content.length() < 4 || content.length() >= 2000){
                alert("내용은 4글자 이상 2000글자 미만이어야 합니다.");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
<h1>게시글 수정</h1>
<form action="modifyaction?id=${id}" method="post" onsubmit="return checkForm()">
    <span>카테고리:</span>
    <span>${board.categoryName}</span>
    <br>
    <span>등록일시:</span>
    <c:set var="registrationDate">
        <fmt:formatDate value="${board.registrationDate}" pattern="yyyy.MM.dd HH:mm" />
    </c:set>
    <span>${registrationDate}</span>
    <br>
    <span>수정일시:</span>
    <c:set var="modificationDate" value=""/>
    <c:choose>
        <c:when test="${not empty board.modificationDate}">
            <fmt:formatDate value="${board.modificationDate}" pattern="yyyy.MM.dd HH:mm" var="modificationDate" />
        </c:when>
        <c:otherwise>
            <c:set var="modificationDate" value="-" />
        </c:otherwise>
    </c:choose>
    <span>${modificationDate}</span>
    <br>
    <span>조회수:</span>
    <span>${board.viewCount}</span>
    <br>
    <label for="writer">작성자:</label>
    <input type="text" name="writer" id="writer" value="${board.writer}">
    <br>
    <label for="password">비밀번호:</label>
    <input type="password" name="password" id="password" placeholder="비밀번호">
    <br>
    <label for="title">제목:</label>
    <input type="text" name="title" id="title" value="${board.title}">
    <br>
    <label for="content">내용:</label>
    <textarea name="content" id="content" rows="5">${board.content}</textarea>
    <br>
    <label for="file">파일 첨부:</label>
    <input type="file" name="file" id="file">
    <br>
    <button type="button" onclick="location.href='view?id=${id}&pageNum=${pageNum}'">취소</button>
    <input type="submit" id="submitButton" value="수정">
</form>

</body>
</html>
