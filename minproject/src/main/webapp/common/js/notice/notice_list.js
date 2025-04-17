var ob = document.getElementsByName("n_ch"); //name이 n_ch인 쳌박
var ea = ob.length;  //name이 n_ch인 박스 전체 개수
//var count=0;

//최상단 박스 체크시 모든 체크박스 선택
function ck_all(v){
	for(var f=0; f<ea; f++){  //전체선택 클릭시 아래 체크박스 모두 선택되도록 작동 
		ob[f].checked = v ;  //같은 이름의 name값은 배열로 순차적으로 처리됨 
	}
}


//체크박스 하나라도 해제되었을 경우 최상단박스의 체크를 해제 
function choice_ck(){
	var all = document.getElementById("all_ck");
	var count=0;
	for(var f=0; f<ea; f++){
		if(ob[f].checked == true){
			count++;
		}
	}
	if(ea==count){  //
		all.checked = true;
	}else{
		all.checked = false;
	}
}


//해당 게시물의 내용 확인
function notice_view(no){
	location.href='./notice_view.do?nidx='+no;
}


//공지 삭제 버튼 클릭시 작동
function notice_delete(){
	var count=0;
	
	for(var n =0; n<ea; n++){
		if(ob[n].checked==true){
			count++;
		}
		/* 버튼을 누를 때 함수 내용이 작동되므로 
		체크를 하고 풀어도 버튼 누른 시점에 체크박스 체크된게 있는지 아닌지 확인함
		그래서 체크했다가 풀어도 count가 0이 되는거임*/
	}
	console.log(count);
	if(count<=0){
		alert("삭제할 공지를 선택하세요");
	}
	else if(confirm("해당 내용을 삭제시 데이터는 복구 되지 않습니다.")){
//		location.href='./notice_delete.do?nidx='+nidx;
		frm.submit();
	};
}


function go_search(){
	if(frm2.n_search.value==""){
		alert("검색할 단어를 입력해주세요");
	}else {
		frm2.submit();
	}
}
