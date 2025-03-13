<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<section>
	<form id="frm" method="post" action="../notice/notice_write.do" enctype="multipart/form-data">
		<p>공지사항 등록페이지</p>
		<div class="write_view">
			<ul>
				<li>공지사항 여부</li>
				<li><label class="label_notice"><em class="cbox">
				<input type="checkbox" name="n_yn"></em> 공지 출력</label> ※ 공지출력을 체크할 시 해당 글 내용은 최상단에 노출 되어 집니다.</li>
			</ul>
			<ul>
				<li>공지사항 제목</li>
				<li><input type="text" class="notice_input1" name="n_subject"> ※ 최대 150자까지 입력이 가능</li>
			</ul>
			<ul>
				<li>글쓴이</li>
				<li><input type="text" class="notice_input2" readonly name="n_writer" value="관리자"> ※ 관리자 이름이 노출 됩니다.</li>
			</ul>
			<ul>
				<li>첨부파일</li>
				<li><input type="file" name="n_filenm"> ※ 첨부파일 최대 용량은 2MB 입니다.</li>
			</ul>
			<ul class="ul_height">
				<li>공지내용</li>
				<li><textarea class="notice_input3" placeholder="공지내용을 입력하세요!" name="n_content"></textarea></li>
			</ul>
		</div>
	</form>
	<div class="board_btn">
		<button class="border_del" onclick="#">공지목록</button>
		<button class="border_add" onclick="notice_write();">공지등록</button>
	</div>
	
</section>

<script src="../admin/js/notice/notice_write.js?v=2"></script>