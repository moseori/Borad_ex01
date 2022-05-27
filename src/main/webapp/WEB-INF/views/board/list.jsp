<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
모든 회원 조회
<table>
<tr>
<th>번호</th>
<th>제목</th>
<th>작성자</th>
<th>등록일</th>
</tr>
<c:forEach items="${list}" var="b">
<tr>
<td>${b.bno}</td>
<td><a href="get?bno=${b.bno}">${b.title}</a></td>
<td>${b.writer}</td>
<td>${b.regDate }</td>
</tr>
</c:forEach>
</table>
<c:if test="${not empty message }">
${message}
</c:if>
</body>
</html>