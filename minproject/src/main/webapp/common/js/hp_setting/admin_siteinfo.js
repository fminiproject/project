function save_yes(){
	if(frm.hp_title.value == ""){
		alert("홈페이지 제목을 입력해주세요.");
	}else if(frm.ad_mail.value == ""){
		alert("관리자 메일 주소를 입력해주세요.");
	}else if(frm.join_point.value == ""){
		alert("회원가입 시 적립금을 입력해주세요.");
	}else if(isNaN(frm.join_point.value)){
		alert("숫자만 입력해주세요.");
	}else if(frm.join_lv.value == ""){
		alert("회원가입 시 권한레벨을 입력해주세요.");
	}else if(isNaN(frm.join_lv.value)){
		alert("숫자만 입력해주세요.");
	}else if(frm.corp_name.value == ""){
		alert("회사명을 입력해주세요.");
	}else if(frm.busi_num.value == ""){
		alert("사업자등록번호를 입력해주세요.");
	}else if(frm.ceo_name.value == ""){
		alert("대표자명을 입력해주세요.");
	}else if(frm.ceo_num.value == ""){
		alert("대표전화번호를 입력해주세요.");
	}else if(frm.busi_report_num.value == ""){
		alert("통신판매업 신고번호를 입력해주세요.");
	}else if(frm.busi_num_more.value == ""){
		alert("부가통신 사업자번호를 입력해주세요.");
	}else if(frm.corp_addnum.value == ""){
		alert("사업장 우편번호를 입력해주세요.");
	}else if(frm.corp_add.value == ""){
		alert("사업장 주소를 입력해주세요.");
	}else if(frm.info_ad_name.value == ""){
		alert("정보관리책임자명을 입력해주세요.");
	}else if(frm.info_ad_mail.value == ""){
		alert("정보책임자 E-mail을 입력해주세요.");
	}else if(frm.no_bank.value == ""){
		alert("무통장 은행을 입력해주세요.");
	}else if(frm.account_num.value == ""){
		alert("은행계좌번호를 입력해주세요.");
	}else if(isNaN(frm.account_num.value)){
		alert("숫자만 입력해주세요.");
	}else if(frm.pay_po_min.value == ""){
		alert("결제 최소 포인트를 입력해주세요.");
	}else if(isNaN(frm.pay_po_min.value)){
		alert("숫자만 입력해주세요.");
	}else if(frm.pay_po_max.value == ""){
		alert("결제 최대 포인트를 입력해주세요.");
	}else if(isNaN(frm.pay_po_max.value)){
		alert("숫자만 입력해주세요.");
	}else if(frm.deli_corp.value == ""){
		alert("배송업체명을 입력해주세요.");
	}else if(frm.deli_pay.value == ""){
		alert("배송비 가격을 입력해주세요.");
	}else if(isNaN(frm.deli_pay.value)){
		alert("숫자만 입력해주세요.");
	}else{
		alert("해당 정보를 사이트에 반영하시겠습니까?");
		frm.action = "./hp_joinok.do";
		frm.submit();
	}
};

function save_no(){
	alert("해당 정보를 반영하지 않겠습니까?");
	frm.action = "";
	location.href="./admin_siteinfo.jsp";
}