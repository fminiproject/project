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
	
	//get page번호를 가져오는 방식 
	String pno = request.getParameter("pageNo");  
	//밑의 페이징에서 숫자를 클릭시 do가 작동하면서 동시에 jsp가 작동 => 컨트롤러를 안통하고 바로 pageNo값을 받을 수 있음(JSP도 하나의 언어이기 때문에)
			
	if(pno == null || pno.equals("1")){  
	//최초 게시판리스트에 접근시 페이지 번호가 없거나 1페이지를 클릭한 경우 
		pno = "1";
	}
	
%>

<main class="maincss">
	<section>
		<p>공지사항 관리페이지</p>
		<div class="subpage_view">
			<ul>
				<li><input type="checkbox"></li>
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
				<li><input type="checkbox" name="" value=""></li>
				<li><%= total %></li>  <!-- 글번호 -->
				<li onclick="notice_view(<%=notice.get(w).get(0)%>)"><%= notice.get(w).get(1)%></li>  <!-- 글제목 -->
				<li><%= notice.get(w).get(2)%></li>  <!-- 작성자 -->
				<li><%= notice.get(w).get(4)%></li>  <!-- 등록일 -->
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
			<button class="border_del">공지삭제</button>
			<button class="border_add" onclick="notice_write();">공지등록</button>
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

<script src="../admin/js/notice/notice_list.js?v=2"></script>