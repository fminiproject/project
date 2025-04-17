var n_subject = frm.n_subject;
var n_content = frm.n_content;

function go_list(){
	location.href='./notice_list.do';
}


function notice_modify(){
	if(n_subject.value==""){
		alert("공지 제목을 입력하세요.");
	}else if(n_content.value==""){
		alert("공지 내용을 입력하세요.");
	}else {
		frm.submit();
	}
}


$(()=>{
	
	
	$("#attach_f").click(()=>{
		
		var $formdata = new FormData();
		$formdata.append("attach_f", $("#attach_f")[0].files[0]);
		console.log($formdata.get("attach_f"));
	
		$.ajax({
			url : "./notice_modify_view.do",  
			type : "post",  
			cache : false, 
			dataType:"HTML",
			data : $formdata,
			success : function(response){
				console.log(response);
			},			
			error : function(error){
				console.log("오류발생 : "+ error);
			}
		});
	})
})