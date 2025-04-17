<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<section class="admin_bgcolor">
	<div class="admin_login">
		<span>
			<div class="left_div">
				<ul>
					<li><input type="text" id="mid" class="input_text1"
						placeholder="관리자 아이디를 입력하세요"></li>
					<li><input type="password" id="mpass" class="input_text1"
						placeholder="관리자 패스워드를 입력하세요"></li>
				</ul>
			</div>
			<div class="right_div">
				<button type="submit" class="btn_submit" title="MASTER LOGIN"
					onclick="login()">MASTER LOGIN</button>
			</div> 
			<em class="alert_msg">※ 본 사이트는 관리자 외에는 접근을 금합니다. 페이지 접근에 대한 접속 정보는 모두 기록 됩니다.</em>
		</span> 
		<span>
			<ol class="admin_info">
				<li title="신규 관리자 등록요청"><a href="./admin/join.do">신규 관리자 등록요청</a></li>
				<li title="아이디/패스워드 찾기">아이디/패스워드 찾기</li>
			</ol>
		</span>
	</div>
</section>
<script src="./common/js/index.js?v=2"></script>