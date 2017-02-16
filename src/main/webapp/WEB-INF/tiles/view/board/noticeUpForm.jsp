<section id="inner-headline">
	<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
	<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
		<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<ul class="breadcrumb">
					<li><a href="#"><i class="fa fa-home"></i></a><i
						class="icon-angle-right"></i></li>
					<li><a href="#">공지사항</a><i class="icon-angle-right"></i></li>
				</ul>
			</div>
		</div>
	</div>
</section>
<section id="content">
	<div class="container">
		<div class="row">

			<div class="col-lg-12">
				<img src="/img/page_19_01.jpg">
				<br/><br/><br/>
				<form method="post" id="noticeUpForm" action="noticeUpdate.do">
					<table class="table table-bordered">
					<colgroup>
						<col width="60%" />
						<col width="20%" />
						<col width="20%" />
					</colgroup>
					<tr>
						<th>제목</th>
						<th>작성일</th>
						<th>수정일</th>
					</tr>
					<tr>
						<td><input type="text" id="title" name="boardTitle" value="${bd.title}" class="form-control"></td>
						<td>${fn:substring(bd.createDate,0,10)}</td>
						<td>${fn:substring(bd.updateDate,0,10)}</td>
					</tr>
					<tr><td colspan="3"><textarea  id="contents" name="boardContents" class="form-control" style="height:300px">${bd.contents}</textarea></td></tr>
						
				</table>
				
				
				<input type="hidden" value="${bd.id}" id="upId" name="boardId">
				</form>
				<input type="button" class="btn btn-primary" id="updateNotice" value="수정">
			</div>
		</div>
	</div>


</section>