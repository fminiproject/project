<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<ArrayList<String>> notice = (ArrayList<ArrayList<String>>)request.getAttribute("result");

	String total_page = notice.get(0).get(5);
	int pg = 1;
	if(total_page != null || !total_page.equals("1")){  //게시물이 하나라도 있을때
		float pg2 = Integer.parseInt(total_page)/5f;
		pg = (int)Math.ceil(pg2);
	}
	
	String pno = request.getParameter("pageNo");  
			
	if(pno == null || pno.equals("1")){  
	//최초 게시판리스트에 접근시 페이지 번호가 없거나 1페이지를 클릭한 경우 
		pno = "1";
	}
%>

<form id="frm" method="get" action="./notice_delete.do">
<main class="maincss">
	<section>
		<p>공지사항 관리페이지</p>
		<div class="subpage_view">
			<ul>
				<li><input type="checkbox" id="all_ck" onclick="ck_all(this.checked);"></li>
				<li>NO</li>
				<li>제목</li>
				<li>글쓴이</li>
				<li>날짜</li>
				<li>조회</li>
			</ul>
			
		<% if(notice.size()==0){ %>
			<ol class="none_text">
				<li>등록된 공지 내용이 없습니다.</li>
			</ol>
		<% } else {
		
			//리스트 출력 번호를 통 데이터 개수로 처리 
			int total = Integer.parseInt(total_page) - ((Integer.parseInt(pno)-1)*5);
			//총 데이터개수 - ((페이지번호 -1)*한페이지당 출력개수)	
		
			int w= 0;
		   	while(w<notice.size()){ 
		%>
			<ol>
				<li><input type="checkbox" name="n_ch" value="<%=notice.get(w).get(0)%>" onclick="choice_ck();"></li>
				<li><%= total %></li>  <!-- 글번호 -->
				<li onclick="notice_view(<%=notice.get(w).get(0)%>)" title="<%= notice.get(w).get(1)%>"><%= notice.get(w).get(1)%></li>  <!-- 글제목 -->
				<li><%= notice.get(w).get(2)%></li>  <!-- 작성자 -->
				<li><%= notice.get(w).get(4).substring(0,10)%></li>  <!-- 등록일 -->
				<li><%= notice.get(w).get(3)%></li>  <!-- 조회수 -->
			</ol>
		<%
			total--;
			w++;
		   	} 
		}
		%>
		</div>
		<div class="board_btn">
			<button type="button" class="border_del" onclick="notice_delete();">공지삭제</button>
			<button type="button" class="border_add" id="notice_write" onclick="location.href='./notice_write.jsp';">공지등록</button>
			<!-- <button> : type을 안넣으면 submit이 되어 form이 작동됨. type="button"꼭 써줄것 -->
		</div>
	
		<div class="border_page">
		
			<ul class="pageing">
				<li><img src="./ico/double_left.svg"></li>
				<li><img src="./ico/left.svg"></li>
				<% 
					int ww =1;
					while(ww<=pg){
				%>
				<li><a href="./notice_list.do?pageNo=<%=ww %>"><%=ww %></a></li>
				<%
					ww++;
					}
				%>
				<li><img src="./ico/right.svg"></li>
				<li><img src="./ico/double_right.svg"></li>
			</ul>
		
		</div>
	</section>
</main>
</form>
<script src="../admin/js/notice/notice_list.js?v=4"></script>