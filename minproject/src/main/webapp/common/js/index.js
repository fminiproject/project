function login(){
	
	var mid = document.getElementById("mid").value;
	var mpass = document.getElementById("mpass").value;
	
	if(mid == ""){
		alert("아이디를 입력하세요")
	} else if (mpass == ""){
		alert("비밀번호를 입력하세요")
	} else {
		this.login_submit(mid,mpass);
	}

}

//ajax
function login_submit(mid,mpass){
	var http,result;
	
	http = new XMLHttpRequest();
	http.onreadystatechange = function(){
		if(http.readyState==4 && http.status == 200 ){
		
		if(this.response == "ok"){
						 console.log(this.response);
			alert("로그인 성공");
			 console.log("페이지 이동 시작");
			window.location.href = "./admin/toadminlist.do";
			
		}else if(this.response == "disapproval") {
			alert("승인된 회원만 로그인이 가능합니다.")
		}else {
			alert("아이디 및 비밀번호를 확인해주세요")	
		}
		
	}else if(http.status==404){
		console.log("경로오류");
	}else if(http.status==405){
		console.log("통신 규격 오류 발생");// get-post 불일치
	}
}

	http.open("POST","./admin/loginout.do", true);
	http.setRequestHeader("content-type","application/x-www-form-urlencoded");
	http.send("mid="+mid+"&mpass="+mpass);

}