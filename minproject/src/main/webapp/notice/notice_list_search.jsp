<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항 리스트 페이지</title>
    <link rel="stylesheet" type="text/css" href="../common/css/basic.css?v=3">
    <link rel="stylesheet" type="text/css" href="../common/css/login.css?v=12">
    <link rel="stylesheet" type="text/css" href="../common/css/main.css?v=12">
    <link rel="stylesheet" type="text/css" href="../common/css/notice.css?v=14">
    <link rel="icon" href="../common/img/logo.png" sizes="128x128">
    <link rel="icon" href="../common/img/logo.png" sizes="64x64">
    <link rel="icon" href="../common/img/logo.png" sizes="32x32">
    <link rel="icon" href="../common/img/logo.png" sizes="16x16">
</head>
<body>
	<!-- 헤더부분 -->
	<%@ include file="../common/top.jsp" %>
	<!-- 헤더부분 -->
	
	<!-- 메인부분 -->
	<%@ include file="./notice_list_search_view.jsp" %>
	<!-- 메인부분 -->
	
	<!-- 푸터부분 -->
	<%@ include file="../common/footer.jsp" %>
	<!-- 푸터부분 -->
</body>
</html>