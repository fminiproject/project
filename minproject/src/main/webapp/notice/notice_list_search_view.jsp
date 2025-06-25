<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<ArrayList<String>> s_notice = (ArrayList<ArrayList<String>>) request.getAttribute("s_result");
	ArrayList<ArrayList<String>> notice_top = (ArrayList<ArrayList<String>>) request.getAttribute("result_top");
	String keyword = (String)request.getAttribute("keyword");
	String total_page = "1"; 
// 	out.print(notice);
	if (s_notice != null && !s_notice.isEmpty() && s_notice.get(0).size() > 6) {  //전체게시글 첫번째글의 컬럼수가 6이상일때를 체크 
		total_page = s_notice.get(0).get(6);  //total_page = 전체게시글 수 
	} 
	
	int pg = 1;
	if (total_page != null || !total_page.equals("1")) { //게시물이 하나라도 있을때
		float pg2 = Integer.parseInt(total_page) / 5f;  //전체 게시글 수를 한페이지에 표시할 게시글 수로 나눔 
		pg = (int) Math.ceil(pg2);  //올림해서 +1함 
	}
	
	String pageNo = request.getParameter("pageNo");  //클릭한 페이징 넘버 가져옴
	
	if (pageNo == null || pageNo.equals("1")) { //최초 게시판리스트에 접근시 페이지 번호가 없거나 1페이지를 클릭한 경우 
		pageNo = "1";
	}
%>


<main class="maincss">
	<form id="frm" method="get" action="./notice_delete.do">  <!-- 체크한 게시글의 nidx 전달 위해 form 사용 -->
		<section class="list_section1">
			<p>공지사항 관리 페이지</p>
			<div class="subpage_view">
				<ul>
					<li><input type="checkbox" id="all_ck" onclick="ck_all(this.checked);"></li>
					<li>NO</li>
					<li></li> <!-- 첨부파일표시 -->
					<li>제목</li>
					<li>글쓴이</li>
					<li>날짜</li>
					<li>조회</li>
				</ul>

				<% if(s_notice == null || s_notice.isEmpty()){ %>
				
				<ol class="none_text">
					<li>검색된 공지 내용이 없습니다.</li>
				</ol>
				
				<% }else{ 
					int t = 0;
					int maxCount = Math.min(3, notice_top.size()); //3과 notice_top.size() 중 작은 값 사용
					/*t<3일 때 에러난 이유 : notice_top의 크기가 3보다 작을 때,
					  t = 0부터 2까지 접근하려 하면 인덱스 초과 오류 (IndexOutOfBoundsException)가 발생
					  t = 2일 때 notice_top.get(2)을 호출하면 에러 발생 (존재하지 않는 인덱스)*/
					while (t < maxCount) {
				%>
				<!-- 최상단공지목록 -->
				<ol style="background-color:grey;">
					<li><input type="checkbox" name="n_ch" value="<%=notice_top.get(t).get(0)%>" onclick="choice_ck();"></li>
					<li>  <!-- 글번호 -->
						<img src="../admin/ico/fire.svg" class="fileicon">
					</li> 
					
					<li> <!-- 첨부파일표시 -->
					<% 	if(notice_top.get(t).get(7) != null){%>  <!-- 첨부파일 있으면 -->
						<img src="../admin/ico/paperclip.svg" class="fileicon">
					<% 	} %>
					</li>  
					<li onclick="notice_view(<%=notice_top.get(t).get(0)%>)" title="<%=notice_top.get(t).get(2)%>" class="cc">
						<%=notice_top.get(t).get(2)%>
					</li> <!-- 글제목 -->
					<li><%=notice_top.get(t).get(3)%></li> <!-- 작성자 -->
					<li><%=notice_top.get(t).get(5).substring(0, 10)%></li> <!-- 등록일 -->
					<li><%=notice_top.get(t).get(4)%></li> <!-- 조회수 -->
				</ol>
				<%
						t++;
					}

					//리스트 출력 번호를 통 데이터 개수로 처리 
					int total = Integer.parseInt(total_page) - ((Integer.parseInt(pageNo) - 1) * 5);
					//총 데이터개수 - ((페이지번호 -1)*한페이지당 출력개수)	
	
					int w = 0;
					while (w < s_notice.size()) {
				%>
				<ol>
					<li><input type="checkbox" name="n_ch" value="<%=s_notice.get(w).get(0)%>" onclick="choice_ck();"></li>
					<li><%=total%></li> <!-- 글번호 -->
					<li> <!-- 첨부파일표시 -->
					<% 	if(s_notice.get(w).get(7) != null){%>  <!-- 첨부파일 있으면 -->
						<img src="../admin/ico/paperclip.svg" class="fileicon">
					<% 	} %>
					</li> 
					<li onclick="notice_view(<%=s_notice.get(w).get(0)%>)" title="<%=s_notice.get(w).get(2)%>">
						<%=s_notice.get(w).get(2)%>
					</li> <!-- 글제목 -->
					<li><%=s_notice.get(w).get(3)%></li> <!-- 작성자 -->
					<li><%=s_notice.get(w).get(5).substring(0, 10)%></li> <!-- 등록일 -->
					<li><%=s_notice.get(w).get(4)%></li> <!-- 조회수 -->
				</ol>
				<%
						total--;
						w++;
					}
				}
				%>
			</div>
		</section>
	</form>
	<form id="frm2" method="get" action="./notice_search.do">
		<section>
			<div class="bottom_div">
				<div class="search_div">
					<input type="text" name="n_search" value="<%=keyword%>">
					<img src="../common/ico/search.svg" onclick="go_search();">
				</div>
				<div class="board_btn">
					<button type="button" class="border_del" onclick="notice_delete();">공지삭제</button>
					<button type="button" class="border_add" id="notice_write" onclick="location.href='./notice_write_view.do';">공지등록</button>
				</div>
			</div>
			
	
			<div class="border_page">
				<ul class="pageing">
					<a href="./notice_search.do?n_search=<%=keyword%>&pageNo=1"><li><img src="../common/ico/double_left.svg"></li></a>
					<a href="#"><li><img src="../common/ico/left.svg"></li></a>
					<%
					int ww = 1;
					while (ww <= pg) {
					%>
						<a href="./notice_search.do?n_search=<%=keyword%>&pageNo=<%=ww%>"><li><%=ww%></li></a>
					<%
						ww++;
					}
					%>
					<a href="#"><li><img src="../common/ico/right.svg"></li></a>
					<a href="./notice_search.do?n_search=<%=keyword%>&pageNo=<%=pg%>"><li><img src="../common/ico/double_right.svg"></li></a>
				</ul>
			</div>
		</section>
	</form>
</main>

<script src="../common/js/notice/notice_list.js?v=1"></script>