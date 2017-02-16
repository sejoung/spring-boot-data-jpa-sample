
$("#noticeAdd").click(function() {
	if ($("#title").val() == "") {
		alert("제목을 입력하세요")
	} else if ($("#title").val().length > 50) {
		alert("50자 이내로 입력해주세요")
	} else if ($("#contents").val() == "") {
		alert("내용을 입력하세요")
	} else if ($("#contents").val().length > 1000) {
		alert("1000자 이내로 입력해주세요")
	} else {
		$("#noticeForm").submit();
	}
});

$("#noticeUp").click(function() {
	var id = $("#delId").val();
	location.href = "/homepage/notice/noticeUpForm.do?id=" + id;
});

$("#deleteNotice").click(function() {
	var id = $("#delId").val();
	if (confirm("삭제하시겠습니까?")) {
		location.href = "/homepage/notice/noticeDelete.do?id=" + id;
	}

});
$("#updateNotice").click(function() {
	var id = $("#upId").val();
	if ($("#title").val() == "") {
		alert("제목을 입력하세요")
	} else if ($("#title").val().length > 50) {
		alert("50자 이내로 입력해주세요")
	} else if ($("#contents").val() == "") {
		alert("내용을 입력하세요")
	} else if ($("#contents").val().length > 1000) {
		alert("1000자 이내로 입력해주세요")
	} else {
		if (confirm("수정하시겠습니까?")) {
			$("#noticeUpForm").submit();
		}
	}
});

$("#replyAdd").click(
		function() {
			if ($("#commentContents").val() == ""
					|| $("#commentContents").val().length > 1000) {
				alert("1자 이상 1000자 미만으로 입력해주세요")
			} else {
				$("#replyAddForm").submit();
			}
		});

function goPage(page) {
	$("#page").val(page);
	$("#frm").submit();
}
