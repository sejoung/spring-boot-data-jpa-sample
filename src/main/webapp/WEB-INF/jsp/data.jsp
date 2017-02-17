<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="navi" uri="http://github.com/sejoung/navigator-jsp-taglib-bootstrap" %>
<!DOCTYPE html>
<html>
<head>
<link rel="icon" type="image/x-icon" href="/static/favicon.ico">
<link href="/css/bootstrap.min.css" rel="stylesheet" />
<script type="text/javascript">
function goPage(page){
	
	document.getElementById('page').value = page;
	document.frm.submit();
	
}
</script>
</head>
<body>
<form name="frm"  method="post" action="findTestAll">
	<input type="hidden" id="page" name="page" value="">
	<input type="hidden" id="pagesize" name="pagesize" value="10">
</form>

<div>time : <c:out value="${time}"/></div> 
<div>totalPages : <c:out value="${datas.totalPages}"/></div>
<div>totalElements : <c:out value="${datas.totalElements}"/></div>
<div>size  : <c:out value="${datas.size}"/></div>
<div>number  : <c:out value="${datas.number}"/></div>
<div>getNumberOfElements  : <c:out value="${datas.numberOfElements}"/></div>
<div style="display: table; margin-left: auto; margin-right: auto;">
<table class="table" style="width: 600px;">
<thead>
	<tr>
		<th width="10%">#</th>
		<th width="10%">id</th>
		<th>name</th>
	</tr>
</thead>
<tbody>
	<c:forEach items="${datas.content}" var="data" varStatus="status">
    	<tr>
    		<td>${status.count}</td>
    		<td><c:out value="${data.id}"/></td>
    		<td><c:out value="${data.name}"/></td>
    	</tr>
    </c:forEach>
</tbody>
</table>
<navi:navigator currentPage="${datas.number}" countPerPage="${datas.size}" pagePerBlock="10" totalRecordCount="${datas.totalElements}" />
</div>
</body>
</html>
