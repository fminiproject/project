function join(verified, id) {

	var http;
	http = new XMLHttpRequest();
	http.onreadystatechange = function() {
		if (http.readyState==4 && http.status == 200) {

				if (http.response == "verified") {
					console.log(http.response);
					alert("회원 승인 처리 완료");
				} else {
					console.log(http.response);
					alert("회원 미승인 처리 완료");
				}	
				
				window.location.reload();
				
				}else if(http.status==404){
				console.log("경로오류");
				}else if(http.status==405){
				console.log("통신 규격 오류 발생");// get-post 불일치
			}
			
			};

	http.open("POST", "./toadminlist.do", true);
	http.setRequestHeader("content-type", "application/x-www-form-urlencoded");
	http.send("mid=" + id + "&verified=" + verified);


}
