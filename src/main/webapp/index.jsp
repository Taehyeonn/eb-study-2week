<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br>
<h2><a href="board/free/list">리스트로 이동</a></h2>
<h2><a href="board/free/list?boardId=1">리스트로 이동 파라미터</a></h2>
<h2><a href="board/free/view">view로 이동</a></h2>
<h2><a href="board/free/view?boardId=1">view로 이동 파라미터</a></h2>

</body>
</html>
