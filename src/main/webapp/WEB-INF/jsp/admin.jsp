<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
<title> admin </title>
</head>
<body>
<sec:authentication property="principal.username"/>님 안녕하세요 !<br>
<sec:authentication property="principal.nick"/>님 안녕하세요 !<br>

 <sec:authorize access="isAnonymous()">
 	<br> 로그아웃 중입니다.
 </sec:authorize>
 <sec:authorize access="isAuthenticated()">
 	<br> 로그인 중입니다. 
 </sec:authorize>

<form action="/logout" method="post">
	<input type="submit" value="로그아웃">
</form>

</body>
</html>