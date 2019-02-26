<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<title>김세중 테스트</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<meta name="description" content="test"/>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="imagetoolbar" content="no" />
<!-- css -->
<link href="/static/css/bootstrap.min.css" rel="stylesheet" />
</head>
<body>
<div id="wrapper">
	<!-- start header -->
	<tiles:insertAttribute name="header" />
	<!-- end header -->
	<tiles:insertAttribute name="body" />

	<tiles:insertAttribute name="footer" />
</div>
<a href="#" class="scrollup"><i class="fa fa-angle-up active"></i></a>
<!-- javascript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="/static/js/jquery.js"></script>
<script src="/static/js/board.js"></script>
</body>
</html>
