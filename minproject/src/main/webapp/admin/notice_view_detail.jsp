<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<String> n_view = (ArrayList<String>)request.getAttribute("n_view");
%>
<form id="frm" method="post" action="./notice_modify_view.do">
<main class="maincss">
	<section>
		<p>공지사항 확인 페이지</p>
		<div class="write_view">
			<ul>
				<li>공지사항 제목</li>
				<li><%=n_view.get(2)%></li>
				
			</ul>
			<ul>
				<li>글쓴이</li>
				<li><%=n_view.get(3)%></li>
				
			</ul>
			<ul>
				<li>첨부파일</li>
				<%if(n_view.get(4)!= null){ %>
				<li><a href="<%=n_view.get(5)%><%=n_view.get(4)%>" target="_blank" ><%=n_view.get(4)%></a></li>
				<% }else{ %>
				<li></li>
				<% } %>
			</ul>
			<ul class="ul_height">
				<li>공지내용</li>
				<li>
					<div class="notice_input3" style="overflow-y: auto;">
					<%=n_view.get(6)%>
					</div>
				</li>
			</ul>
			<input type="hidden" name="nidx" value="<%=n_view.get(0)%>">
			<input type="hidden" name="n_yn" value="<%=n_view.get(1)%>">
			<input type="hidden" name="n_subject" value="<%=n_view.get(2)%>">
			<input type="hidden" name="n_writer" value="<%=n_view.get(3)%>">
			<input type="hidden" name="n_filenm" value="<%=n_view.get(4)%>">
			<input type="hidden" name="n_content" value="<%=n_view.get(6)%>">
		</div>
		<div class="board_btn">
			<button type="button" class="border_del" onclick="notice_list();">공지목록</button>
			<button type="button" class="border_add" onclick="notice_modify_view();">공지수정</button>
			<button type="button" class="border_modify" style="margin-left: 8px;" onclick="notice_delete('<%=n_view.get(0)%>');">공지삭제</button>
		</div>
	</section>
</main>
</form>
<script src="../admin/js/notice/notice_view.js?v=2"></script>