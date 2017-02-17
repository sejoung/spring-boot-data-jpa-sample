<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
	<title>WELCOME</title>
</head>
<body>
	Message: ${message}
	test : <spring:message code="test.message" />
	 <sec:authorize access="isAnonymous()">
 	 <br>
   </sec:authorize>
</body>

</html>