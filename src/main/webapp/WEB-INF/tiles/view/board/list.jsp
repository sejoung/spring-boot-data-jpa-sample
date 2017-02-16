<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="navi" uri="http://github.com/sejoung/navigator-jsp-taglib-bootstrap" %>
<section>
	<div class="container">
		<table class="table table-bordered">
			<colgroup>
				<col width="10%" />
				<col width="50%" />
				<col width="10%" />
				<col width="15%" />
				<col width="15%" />
			</colgroup>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>조회수</th>
				<th>작성일</th>
				<th>수정일</th>
			</tr>
			<c:forEach items="${datas.content}" var="data" varStatus="status">
				<tr>
					<td>${datas.totalElements-(datas.number)*10-status.index}</td>
					<td><a href="noticeDetail.do?id=${data.id}">${data.title}</a></td>
					<td>${data.hit}</td>
					<td>${fn:substring(data.createDate,0,10)}</td>
					<td>${fn:substring(data.updateDate,0,10)}</td>
				</tr>
			</c:forEach>
		</table>
	 	<input	type="button" class="btn btn-primary" id="noticeAddForm" value="공지사항 등록">
		<navi:navigator currentPage="${datas.number}" countPerPage="${datas.size}" pagePerBlock="10" totalRecordCount="${datas.totalElements}" />
	</div>
<form method="post" id="frm" action="list.do">
	<input type="hidden" id="page" name="page" value="">
	<input type="hidden" id="pagesize" name="pagesize" value="10">
</form>
</section>

<script type="text/javascript">
function goPage(page){
	document.getElementById('page').value = page;
	document.frm.submit();
}
</script>