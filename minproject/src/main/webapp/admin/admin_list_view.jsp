<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ArrayList<ArrayList<String>> mlist = (ArrayList)request.getAttribute("mlist");
%>

    
<section>
    <p>신규등록 관리자</p>
    <ol class="new_admin_title2">
        <li>NO</li>
        <li>관리자명</li>
        <li>아이디</li>
        <li>전화번호</li>
        <li>이메일</li>
        <li>담당부서</li>
        <li>담당직책</li>
        <li>가입일자</li>
        <li>승인여부</li>
    </ol>
     <%
    if(mlist.size() == 0 || mlist == null){
    %>
    <ol class="new_admin_none">

        <li>신규 등록된 관리자가 없습니다.</li>
    </ol>
   <%
   }else {
	%>
   
    <%
    
    int i = 0;
    int count = mlist.size();
    while(i < mlist.size()){
    	
    String id = mlist.get(i).get(1);
    %>
    <ol class="new_admin_lists2">
 

    
        <li><%=count--%></li>
        <li><%=mlist.get(i).get(3) %></li>
        <li><%=mlist.get(i).get(1) %></li>
        <li><%=mlist.get(i).get(5) %></li>
        <li><%=mlist.get(i).get(4) %></li>
        <li><%=mlist.get(i).get(6) %></li>
        <li><%=mlist.get(i).get(7) %></li>
        <li><%=mlist.get(i).get(8) %></li>
        <li> <%=mlist.get(i).get(9) %>
        
        <%
         if(mlist.get(i).get(9).equals("N")){
         %>
            <input type="button" value="승인" class="new_addbtn1" title="승인" onclick="join('Y','<%=id%>')">
            <%
            } else {
            %>
            <input type="button" value="미승인" class="new_addbtn2" title="미승인" onclick="join('N','<%=id%>')">
            <%} %>
        </li>
    </ol>
    <%
     i++;
    };
    %>
    <% } %>
</section>
<section></section>
<section></section>