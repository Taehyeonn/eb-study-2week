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
        let password = document.getElementById("password").value.trim();

        if (password === "" || password.length < 4 || password.length >= 16
                || !password.matches("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@#$%^&+=]).*$") ){
          alert("비밀번호는 4글자 이상 16글자 미만, 영문/숫자/특수문자(@#$%^&+=) 포함");
          return false;
        }

        return true;
      }
    </script>
</head>
<body>
<h2>게시글 삭제 - 비밀번호 확인</h2>
<form action="deleteaction?id=${id}" method="post" onsubmit="return checkForm()">
  <label for="password">비밀번호:</label>
  <input type="password" name="password" id="password" placeholder="비밀번호를 입력해주세요.">
  <input type="submit" value="확인">
</form>
</body>
</html>