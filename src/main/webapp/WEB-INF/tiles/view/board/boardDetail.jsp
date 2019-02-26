<section id="inner-headline">
	<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
	<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
				<img src="/img/page_19_01.jpg"> <br />
				<br />
				<br />
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
						<td>${bd.title}</td>
						<td>${fn:substring(bd.createDate,0,10)}</td>
						<td>${fn:substring(bd.updateDate,0,10)}</td>
					</tr>
					<tr>
						<td colspan="3">${bd.contents}</td>
					</tr>

				</table>
				<c:if test="${bd.writer eq 'admin' }">
					<input type="button" class="btn btn-primary" value="삭제"
						id="deleteNotice">
				</c:if>
				<input type="button" class="btn btn-primary" value="목록으로"
					id="noticeList"> <input type="button"
					class="btn btn-primary" value="수정" id="noticeUp"> <input
					type="button" class="btn btn-primary" value="답글" id="reply">
				<input type="hidden" id="delId" value="${bd.id}"> <br />
				<br />
				<div class="col-lg-12" id="replyArea">
					<form method="post" action="replyAdd.do" id="replyAddForm">
						<input type="hidden" id="boardId" name="boardId" value="${bd.id}">

						<table class="table table-striped" style="display: block">
							<colgroup>
								<col width="50%" />
								<col width="15%" />
								<col width="15%" />
								<col width="10%" />
								<col width="10%" />
							</colgroup>
							<tr>
								<th>내용</th>
								<th>작성일</th>
								<th>수정일</th>
								<th>삭제</th>
							</tr>
							<c:if test="${fn:length(coList) eq 0}">
								<tr>
									<td colspan="3">답글이 없습니다.</td>
								</tr>
							</c:if>

							<c:if test="${fn:length(coList) ne 0}">
								<c:forEach items="${coList}" var="cList" varStatus="status">
									<tr>
										<td>${cList.contents}</td>
										<td>${fn:substring(cList.createDate,0,10)}</td>
										<td>${fn:substring(cList.updateDate,0,10)}</td>
										<c:if test="${cList.writer eq 'admin'}">
											<td><input type="button" class="btn btn-primary delete"
												id="${cList.id}" value="삭제"
												onClick="javascript:location.href='/homepage/notice/noticeReplyDelete.do?replyId=${cList.id}&boardId=${bd.id}'"></td>
										</c:if>
										<c:if test="${cList.writer ne 'admin'}">
											<td></td>
										</c:if>

									</tr>
								</c:forEach>
							</c:if>


							<tr>
								<td><input type="text" id="commentContents"
									name="commentContents" class="form-control"></td>
								<td><input type="button" id="replyAdd"
									class="btn btn-primary" value="답글추가"></td>
							</tr>
						</table>
					</form>
				</div>
			</div>
			<br />
			<br />


		</div>
	</div>


</section>