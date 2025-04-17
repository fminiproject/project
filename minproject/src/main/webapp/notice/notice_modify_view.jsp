<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<String> n_view = (ArrayList<String>)request.getAttribute("n_view");
%>
<form id="frm" method="post" action="./notice_modify.do" enctype="multipart/form-data">
<main class="maincss">
	<section>
		<p>공지사항 수정 페이지</p>
		<div class="write_view">
			<ul>
				<li>공지사항 여부</li>
				<li><label class="label_notice"><em class="cbox">
				<% if (n_view.get(1).equals("Y")) { %> 
					<input type="checkbox" name="n_yn" value="Y" checked> 
				<% } else { %> 
					<input type="checkbox" name="n_yn" value="Y"> 
				<% } %>
				</em> 공지 출력</label> ※ 공지출력을 체크할 시 해당 글 내용은 최상단에 노출 되어 집니다.</li>
			</ul>
			<ul>
				<li>공지사항 제목</li>
				<li>
					<input type="text" class="notice_input1" name="n_subject" value="<%=n_view.get(2)%>" maxlength="150"> 
					※ 최대 150자까지 입력이 가능
				</li>
			</ul>
			<ul>
				<li>글쓴이</li>
				<li>
					<input type="text" class="notice_input2" readonly name="n_writer" value="<%=n_view.get(3)%>"> 
					※ 관리자 이름이 노출 됩니다.
				</li>
			</ul>
			<ul>
				<li>첨부파일</li>
				<li id="af">
				<% if(n_view.get(4)!=null){ %>
					<%=n_view.get(4)%> &nbsp; <input type="button" value="첨부파일삭제"> &nbsp;
					<input type="hidden" name="current_f" value="<%=n_view.get(4)%>">
				<% } %>
					<input type="file" name="n_filenm" id="attach_f"> 
					※ 첨부파일 최대 용량은 2MB 입니다.
				</li>
			</ul>
			<ul class="ul_height">
				<li>공지내용</li>
				<li>
					<textarea class="notice_input3" placeholder="공지내용을 입력하세요!" name="n_content"><%=n_view.get(5)%></textarea>
				</li>
			</ul>
		</div>
		<input type="hidden" name="nidx" value="<%=n_view.get(0)%>">
		<div class="board_btn">
			<button type="button" class="border_del" onclick="go_list();">공지목록</button>
			<button type="button" class="border_add" onclick="notice_modify();">공지수정</button>
		</div>

	</section>
</main>
</form>
<script src="../common/js/notice/notice_modify.js?v=1"></script>