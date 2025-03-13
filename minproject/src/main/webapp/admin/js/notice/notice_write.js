var n_subject = frm.n_subject;
var n_content = frm.n_content;



function notice_write(){
	if(n_subject.value==""){
		alert("공지 제목을 입력하세요.");
	}else if(n_content.value==""){
		alert("공지 내용을 입력하세요.");
	}else {
		frm.submit();
	}
	
	
}