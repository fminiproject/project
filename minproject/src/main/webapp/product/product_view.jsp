<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Date"%>
<%
	Date today = new Date();
%>
<%
ArrayList<ArrayList<String>> pv = (ArrayList<ArrayList<String>>)request.getAttribute("result");
/* 
페이징 생성방법
1. 한 페이지당 몇개씩 데이터를 출력할 것인지를 설정합니다.
2. 데이터베이스에 있는 데이터의 총 갯수 / 한페이지당 갯수 (소수점)
3. Math.ceil 사용하는 이유는 1.1 1.6 => 반올림으로 페이지가 추가 되도록 합니다.
*/
String total_page = null; // 초기화
if (pv != null && !pv.isEmpty() && pv.get(0) != null && pv.get(0).size() > 11) {
    total_page = pv.get(0).get(11);
}
int aa = 5;
int pg = 1;
if(total_page != null && !total_page.equals(null)){
	String nocom = total_page.replace(",", "");
	float pg2 = Integer.parseInt(nocom) / (float) aa;
	pg = (int)Math.ceil(pg2); 
	System.out.println("이거 출력됨?"+pg);
}

/*
get page번호를 가져오는 방식
최초 공지사항 리스트 페이지에 접근시 페이지 번호가 없을 수 있음 또는 
페이지번호가 1을 클릭했을 경우
*/
String pno = request.getParameter("pageno");
/* if(pno == null || pno.equals("1")){
	pno = "1";
} */
int pageNo = 1; // 기본 페이지 번호

if (pno == null || pno.isEmpty()) {
	pno = "1";
    pageNo = 1;
    request.setAttribute("hw_s_word", "");
} else {
    try {
        pageNo = Integer.parseInt(pno);
    } catch (NumberFormatException e) {
        // 페이지 번호가 숫자가 아닌 경우, 기본값 1로 설정
        pageNo = 1;
    }
}




%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 등록 페이지</title>
    <link rel="stylesheet" type="text/css" href="../common/css/basic.css?v=<%=today%>">
    <link rel="stylesheet" type="text/css" href="../common/css/login.css?v=<%=today%>">
    <link rel="stylesheet" type="text/css" href="../common/css/main.css?v=<%=today%>">
    <link rel="stylesheet" type="text/css" href="../common/css/product.css?v=<%=today%>">
    <link rel="icon" href="../common/img/logo.png" sizes="128x128">
    <link rel="icon" href="../common/img/logo.png" sizes="64x64">
    <link rel="icon" href="../common/img/logo.png" sizes="32x32">
    <link rel="icon" href="../common/img/logo.png" sizes="16x16">
</head>
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
            <li title="쇼핑몰 상품관리"><a href="../product/a_product_listok.do">쇼핑몰 상품관리</a></li>
            <li title="쇼핑몰 기본설정"><a href="../hp_setting/hp_list.do">쇼핑몰 기본설정</a></li>
            <li title="쇼핑몰 공지사항"><a href="../notice/notice_list.do">쇼핑몰 공지사항</a></li>
        </ol>
    </div>

</nav>
<main class="maincss">
<section>
<p>상품관리 페이지</p>
<div class="subpage_view">
    <span>등록된 상품 <%= (pv != null ? pv.size() : 999)%>건</span>
    <span>
        <form id="frm" method="get" action="/product/a_product_listok.do">
        <select class="p_select1" name="hw_select">
			<option value="selname" <%= "selname".equals(request.getParameter("hw_select")) ? "selected" : "" %>>상품명</option>
			<option value="selcode" <%= "selcode".equals(request.getParameter("hw_select")) ? "selected" : "" %>>상품코드</option>
        </select>
        <input type="text" class="p_input1" name="hw_s_word" placeholder="검색어를 입력해 주세요">
        <input type="submit" value="검색" title="상품검색" class="p_submit">
        </form>
    </span>
</div>
<div class="subpage_view2">
    <ul>
        <li><input type="checkbox"></li>
        <li>코드</li>
        <li>이미지</li>
        <li>상품명</li>
        <li>카테고리 분류</li>
        <li>판매가격</li>
        <li>할인가격</li>
        <li>할인율</li>
        <li>재고현황</li>
        <li>판매유/무</li>
        <li>품절</li>
        <li>관리</li>
    </ul>
        <%
    int i;
    int j = (pv != null ? pv.size() : 0);
    if(j == 0){
    	out.println("<ul><li style='width: 100%;'>등록된 상품이 없습니다.</li></ul>");
    }else{
    	for(i =0;i<pv.size();i++){
    %>
    <ul>

        <li><input type="checkbox"></li>
        <!-- 상품코드 -->
        <li><%= (pv != null ? pv.get(i).get(1) : 0) %></li>
        <!-- 이미지 -->
        <li><%= (pv != null ? pv.get(i).get(2) : "") %></li>
        <!-- 상품명 -->
        <li><%= (pv != null ? pv.get(i).get(3) : 0) %></li>
        <!-- 카테고리 -->
        <li><%= (pv != null ? pv.get(i).get(4) : 0) %>
        	<%= (pv != null ? pv.get(i).get(5) : "") %>
        </li>
        <!-- 판매가격 -->
        <li>30,000</li>
        <!-- 할인가격 -->
        <li><%= (pv != null ? pv.get(i).get(6) : 0) %></li>
        <!-- 할인율 -->
        <li><%= (pv != null ? pv.get(i).get(7) : 0) %></li>
        <!-- 재고현황 -->
        <li><%= (pv != null ? pv.get(i).get(8) : 0) %></li>
        <!-- 판매 유/무 -->
        <li><%= (pv != null ? pv.get(i).get(9) : 0) %></li>
        <!-- 품절 유/무 -->
        <li><%= (pv != null ? pv.get(i).get(10) : 0) %></li>
        <li>관리</li>

    </ul>
            <%
    	j--;
    	}
    }
    %>
</div>
<%
int nowp = pageNo; // 현재 페이지
%>
<div class="subpage_view3">
    <ul class="pageing">
        <!-- 맨 처음 페이지로 -->
        <li><a href="/product/a_product_listok.do?pageno=1&hw_select=<%= request.getParameter("hw_select") %>&hw_s_word=<%= request.getParameter("hw_s_word") %>">
            <img src="../common/ico/double_left.svg"></a></li>

        <!-- 이전 페이지 -->
        <li>
            <a href="/product/a_product_listok.do?pageno=<%= (nowp > 1 ? nowp - 1 : 1) %>&hw_select=<%= request.getParameter("hw_select") %>&hw_s_word=<%= request.getParameter("hw_s_word") %>">
                <img src="../common/ico/left.svg"></a></li>

        <% for (int w = 1; w <= pg; w++) { %>
    		<li class="<%= (w == nowp) ? "active-page" : "" %>">
                <a href="/product/a_product_listok.do?pageno=<%= w %>&hw_select=<%= request.getParameter("hw_select") %>&hw_s_word=<%= request.getParameter("hw_s_word") != null ? request.getParameter("hw_s_word") : "" %>">
                    <%= w %>
                </a>
            </li>
        <% } %>

        <!-- 다음 페이지 -->
        <li>
            <a href="/product/a_product_listok.do?pageno=<%= (nowp < pg ? nowp + 1 : pg) %>&hw_select=<%= request.getParameter("hw_select") %>&hw_s_word=<%= request.getParameter("hw_s_word") != null ? request.getParameter("hw_s_word") : "" %>">
                <img src="../common/ico/right.svg"></a></li>

        <!-- 마지막 페이지로 -->
        <li>
            <a href="/product/a_product_listok.do?pageno=<%= pg %>&hw_select=<%= request.getParameter("hw_select") %>&hw_s_word=<%= request.getParameter("hw_s_word") != null ? request.getParameter("hw_s_word") : "" %>">
                <img src="../common/ico/double_right.svg"></a></li>
    </ul>
</div>
<div class="subpage_view4">
    <input type="button" value="선택상품 삭제" title="선택상품 삭제" class="p_button">
    <span style="float: right;">
    <input type="button" value="신규상품 등록" title="신규상품 등록" class="p_button p_button_color1" onclick="location.href='./product_write.html'" >
    <!-- <input type="button" value="카테고리 등록" title="카테고리 등록" class="p_button p_button_color2"> -->
    </span>
</div>
</section>
</main>
<footer class="main_copyright">
    <div>
        Copyright ⓒ 2024 shopbag All rights reserved.
    </div>
</footer>
</body>
</html>