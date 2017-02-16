<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<section id="content">
	<div class="container">
		<div class="row">

			<div class="col-lg-12">
				<img src="/img/page_19_01.jpg">
				<br/><br/><br/>
				<form method="post" id="noticeForm" action="noticeAdd.do">
				<table class="table table-bordered">
					<colgroup>
						<col width="30%" />
						<col width="70%" />
					</colgroup>
					<tr>
						<th>제목</th>
						<td><input type="text" id="title" name="title" class="form-control"></td>
						
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea  id="contents" name="contents" class="form-control" style="height:300px">${bd.contents}</textarea></td>
					</tr>
				</table>
				</form>
				<input type="button" class="btn btn-primary" id="noticeAdd" value="등록">
			</div>
		</div>
	</div>
</section>