<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
            let category = document.getElementById("category").value.trim();
            let writer = document.getElementById("writer").value.trim();
            let password = document.getElementById("password").value.trim();
            let confirmPassword = document.getElementById("confirmPassword").value.trim();
            let title = document.getElementById("title").value;
            let content = document.getElementById("content").value;
            // let password = document.getElementById("password").value; 파일

            if (category === ""){
                alert("카테고리를 선택해주세요.");
                return false;
            }

            if (writer === "" || writer.length < 3 || writer.length >= 5 ){
                alert("작성자는 3글자 이상 5글자 미만이어야 합니다.");
                return false;
            }

            if (password === "" || password.length < 4 || password.length >= 16 || !password.equals(confirmPassword)
                || !password.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=]).*$") ){
                alert("비밀번호는 4글자 이상 16글자 미만, 영문/숫자/특수문자(@#$%^&+=) 포함, 비밀번호 확인과 일치해야 합니다. ");
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
<h1>게시판 - 등록</h1>
<form action="writeaction" method="post" name="writeform" onsubmit="return checkForm()">
    <label for="category">카테고리:</label>
    <select name="categoryId" id="category">
        <option value="" disabled selected>카테고리 선택</option>
        <c:forEach var="ca" items="${categoryList}">
         <option value=${ca.id}>${ca.name}</option>
        </c:forEach>
    </select>
    <br>
    <label for="writer">작성자:</label>
    <input type="text" name="writer" id="writer">
    <br>
    <label for="password">비밀번호:</label>
    <input type="password" name="password" id="password" placeholder="비밀번호">
    <br>
    <label for="confirmPassword">비밀번호 확인:</label>
    <input type="password" name="confirmPassword" id="confirmPassword" placeholder="비밀번호 확인">
    <br>
    <label for="title">제목:</label>
    <input type="text" name="title" id="title">
    <br>
    <label for="content">내용:</label>
    <textarea name="content" id="content" rows="5"></textarea>
    <br>
    <label for="file">파일 첨부:</label>
    <input type="file" name="file" id="file">
    <br>
    <button type="button" onclick="location.href='list?pageNum=${pageNum}'">취소</button>
    <input type="submit" id="submitButton" value="글쓰기">
</form>
</body>
</html>
