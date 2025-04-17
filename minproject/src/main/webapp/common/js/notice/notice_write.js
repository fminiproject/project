var n_subject = frm.n_subject;
var n_content = frm.n_content;

function go_list(){
	location.href='./notice_list.do';
}

function go_notice(){
	if(n_subject.value==""){
		alert("공지 제목을 입력하세요.");
	}else if(n_content.value.length>150){
		alert("제목은 150자까지만 쓸 수 있습니다.");
	}else if(n_content.value==""){
		alert("공지 내용을 입력하세요.");
	}else {
		frm.submit();
	}
}
