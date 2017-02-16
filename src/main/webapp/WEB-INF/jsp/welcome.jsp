<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>WELCOME</title>
</head>
<body>
	Message: ${message}
	test : <spring:message code="test.message" />
</body>

</html>