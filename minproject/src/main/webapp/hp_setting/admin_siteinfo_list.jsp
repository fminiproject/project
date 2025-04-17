<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<ArrayList<Object>> alldata = (ArrayList)request.getAttribute("alldata");
%>

<!DOCTYPE html>
<html lang="ko">

<%
int w = 0;
while(w < alldata.size()){
	
%>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><%=alldata.get(w).get(0) %></title>
    <link rel="stylesheet" type="text/css" href="../common/css/basic.css">
    <link rel="stylesheet" type="text/css" href="../common/css/login.css?v=1">
    <link rel="stylesheet" type="text/css" href="../common/css/main.css">
    <link rel="stylesheet" type="text/css" href="../common/css/subpage.css?v=5">
    <link rel="icon" href="../common/img/logo.png" sizes="128x128">
    <link rel="icon" href="../common/img/logo.png" sizes="64x64">
    <link rel="icon" href="../common/img/logo.png" sizes="32x32">
    <link rel="icon" href="../common/img/logo.png" sizes="16x16">
</head>
<form id="frm" method="post">
<body>
<header class="headercss">
    <div class="header_div">
        <p><img src="../common/img/logo.png" class="logo_sm"> ADMINISTRATOR</p>
        <p>홍길동 관리자 <a href="#">[개인정보 수정]</a> <a href="#">[로그아웃]</a></p>
    </div>
</header>
<nav class="navcss">
    <div class="nav_div">
        <ol>
            <li title="쇼핑몰 관리자 리스트"><a href="../admin/toadminlist.do">쇼핑몰 관리자 리스트</a></li>
            <li title="쇼핑몰 상품관리"><a href="#">쇼핑몰 상품관리</a></li>
            <li title="쇼핑몰 기본설정"><a href="../hp_setting/hp_list.do">쇼핑몰 기본설정</a></li>
            <li title="쇼핑몰 공지사항"><a href="../notice/notice_list.do">쇼핑몰 공지사항</a></li>
        </ol>
    </div>

</nav>
<main class="maincss">

<section>
    <p>홈페이지 가입환경 설정</p>
<div class="subpage_view">
<ul class="info_form">
    <li>홈페이지 제목</li>
    <li>
        <input type="text" value="<%=alldata.get(w).get(0) %>" class="in_form1" name="hp_title"> 
    </li>
</ul>    
<ul class="info_form">
    <li>관리자 메일 주소</li>
    <li>
        <input type="text" value="<%=alldata.get(w).get(1) %>" class="in_form2" name="ad_mail"> ※ 관리자가 보내고 받는 용도로 사용하는 메일 주소를 입력합니다.(회원가입,인증메일,회원메일발송 등에서 사용)
    </li>
</ul> 
<ul class="info_form">
    <li>포인트 사용 유/무</li>
    <li class="checkcss">
        <em><label><input type="radio" value="Y" class="ckclass" name="use_point" <%=("Y".equals(alldata.get(w).get(2)) ? "checked" : "")%>>포인트 사용</label></em> 
        <em><label><input type="radio" value="N" class="ckclass" name="use_point" <%=("N".equals(alldata.get(w).get(2)) ? "checked" : "")%>>포인트 미사용</label></em>
    </li>
</ul>
<ul class="info_form2" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>회원가입시 적립금</li>
    <li>
        <input type="text" value="<%=alldata.get(w).get(3) %>" class="in_form3" maxlength="5" name="join_point"> 점
    </li>
    <li>회원가입시 권한레벨</li>
    <li>
        <input type="text" value="<%=alldata.get(w).get(4) %>" class="in_form3" maxlength="1" name="join_lv"> 레벨
    </li>
</ul> 
</div>
<p>홈페이지 기본환경 설정</p>
<div class="subpage_view">
<ul class="info_form2">
    <li>회사명</li>
    <li>
        <input type="text" value="<%=alldata.get(w).get(5) %>" class="in_form0" name="corp_name"> 
    </li>
    <li>사업자등록번호</li>
    <li>
        <input type="text" value="<%=alldata.get(w).get(6) %>" class="in_form0" name="busi_num"> 
    </li>
</ul> 
<ul class="info_form2">
    <li>대표자명</li>
    <li>
        <input type="text" value="<%=alldata.get(w).get(7) %>" class="in_form0" name="ceo_name"> 
    </li>
    <li>대표전화번호</li>
    <li>
        <input type="text" value="<%=alldata.get(w).get(8) %>" class="in_form0" name="ceo_num"> 
    </li>
</ul>
<ul class="info_form2">
    <li>통신판매업 신고번호</li>
    <li>
        <input type="text" value="<%=alldata.get(w).get(9) %>" class="in_form0" name="busi_report_num"> 
    </li>
    <li>부가통신 사업자번호</li>
    <li>
        <input type="text" value="<%=alldata.get(w).get(10) %>" class="in_form0" name="busi_num_more"> 
    </li>
</ul>
<ul class="info_form2">
    <li>사업장 우편번호</li>
    <li>
        <input type="text" value="<%=alldata.get(w).get(11) %>" class="in_form0" name="corp_addnum"> 
    </li>
    <li>사업장 주소</li>
    <li>
        <input type="text" value="<%=alldata.get(w).get(12) %>" class="in_form2" name="corp_add"> 
    </li>
</ul>
<ul class="info_form2" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>정보관리책임자명</li>
    <li>
        <input type="text" value="<%=alldata.get(w).get(13) %>" class="in_form0" name="info_ad_name"> 
    </li>
    <li>정보책임자 E-mail</li>
    <li>
        <input type="text" value="<%=alldata.get(w).get(14) %>" class="in_form1" name="info_ad_mail"> 
    </li>
</ul>
</div>
<p>결제 기본환경 설정</p>
<div class="subpage_view">  
<ul class="info_form2">
    <li>무통장 은행</li>
    <li>
        <input type="text" value="<%=alldata.get(w).get(15) %>" class="in_form0" name="no_bank"> 
    </li>
    <li>은행계좌번호</li>
    <li>
        <input type="text" value="<%=alldata.get(w).get(16) %>" class="in_form1" name="account_num"> 
    </li>
</ul>
<ul class="info_form">
    <li>신용카드 결제 사용</li>
    <li class="checkcss">
        <em><label><input type="radio" value="Y" class="ckclass" name="card_pay" <%=("Y".equals(alldata.get(w).get(17)) ? "checked" : "")%>> 사용</label></em> 
        <em><label><input type="radio" value="N" class="ckclass" name="card_pay" <%=("N".equals(alldata.get(w).get(17)) ? "checked" : "")%>> 미사용</label></em> ※ 해당 PG사가 있을 경우 사용으로 변경합니다.
    </li>
</ul>
<ul class="info_form">
    <li>휴대폰 결제 사용</li>
    <li class="checkcss">
        <em><label><input type="radio" value="Y" class="ckclass" name="phone_pay" <%=("Y".equals(alldata.get(w).get(18)) ? "checked" : "")%>> 사용</label></em> 
        <em><label><input type="radio" value="N" class="ckclass" name="phone_pay" <%=("N".equals(alldata.get(w).get(18)) ? "checked" : "")%>> 미사용</label></em> ※ 주문시 휴대폰 결제를 가능하게 할 것인지를 설정합니다.
    </li>
</ul>
<ul class="info_form">
    <li>도서상품권 결제사용</li>
    <li class="checkcss">
        <em><label><input type="radio" value="Y" class="ckclass" name="coupon_pay" <%=("Y".equals(alldata.get(w).get(19)) ? "checked" : "")%>> 사용</label></em> 
        <em><label><input type="radio" value="N" class="ckclass" name="coupon_pay" <%=("N".equals(alldata.get(w).get(19)) ? "checked" : "")%>> 미사용</label></em> ※ 도서상품권 결제만 적용이 되며, 그 외에 상품권은 결제 되지 않습니다.
    </li>
</ul>
<ul class="info_form2">
    <li>결제 최소 포인트</li>
    <li>
        <input type="text" value="<%=alldata.get(w).get(20) %>" class="in_form0" maxlength="5" value="1000" name="pay_po_min"> 점
    </li>
    <li>결제 최대 포인트</li>
    <li>
        <input type="text" value="<%=alldata.get(w).get(21) %>" class="in_form0" maxlength="5" name="pay_po_max"> 점
    </li>
</ul>
<ul class="info_form">
    <li>현금 영수증 발급사용</li>
    <li class="checkcss">
        <em><label><input type="radio" value="Y" class="ckclass" name="receipt" <%=("Y".equals(alldata.get(w).get(22)) ? "checked" : "")%>> 사용</label></em> 
        <em><label><input type="radio" value="N" class="ckclass" name="receipt" <%=("N".equals(alldata.get(w).get(22)) ? "checked" : "")%>> 미사용</label></em> ※ 현금영수증 관련 사항은 PG사 가입이 되었을 경우 사용가능 합니다.
    </li>
</ul>
<ul class="info_form2">
    <li>배송업체명</li>
    <li>
        <input type="text" value="<%=alldata.get(w).get(23) %>" class="in_form0" name="deli_corp"> 
    </li>
    <li>배송비 가격</li>
    <li>
        <input type="text" value="<%=alldata.get(w).get(24) %>" class="in_form0" maxlength="7" name="deli_pay"> 원
    </li>
</ul>
<ul class="info_form" style="border-bottom:1px solid rgb(81, 61, 61);">
    <li>희망배송일</li>
    <li class="checkcss">
        <em><label><input type="radio" value="Y" class="ckclass" name="deli_day"> 사용</label></em> 
        <em><label><input type="radio" value="N" class="ckclass" name="deli_day" checked> 미사용</label></em> ※ 희망배송일 사용시 사용자가 직접 설정 할 수 있습니다.
    </li>
</ul>
</div>
<div class="btn_div">
    <button type="button" class="sub_btn1" title="설정 저장" onclick="save_yes()">설정 저장</button>
    <button type="button" class="sub_btn2" title="저장 취소" onclick="save_no()">저장 취소</button>
</div>
</section>
<section></section>
<section></section>

</form>
</main>
<footer class="main_copyright">
    <div>
    	회사명 : <%=alldata.get(w).get(5)%>/
    	대표자 : <%=alldata.get(w).get(7)%>/
    	주소 : <%=alldata.get(w).get(12)%>/
    	E-mail : <%=alldata.get(w).get(14)%>/
    	사업자등록번호 : <%=alldata.get(w).get(6)%>/
    	통신판매업신고번호 : <%=alldata.get(w).get(9)%>/
        Copyright ⓒ 2024 shopbag All rights reserved.
    </div>
</footer>
</body>
<%
break;
}
%>
<script src="../common/js/hp_setting/admin_siteinfo_list.js?v=3"></script>
</html>