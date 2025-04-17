<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 등록 페이지</title>
    <link rel="stylesheet" type="text/css" href="../common/css/basic.css">
    <link rel="stylesheet" type="text/css" href="../common/css/login.css?v=1">
    <link rel="stylesheet" type="text/css" href="../common/css/main.css?v=1">
    <link rel="icon" href="../common/img/logo.png" sizes="128x128">
    <link rel="icon" href="../common/img/logo.png" sizes="64x64">
    <link rel="icon" href="../common/img/logo.png" sizes="32x32">
    <link rel="icon" href="../common/img/logo.png" sizes="16x16">
</head>
<body>
<!-- top 시작 -->
<%@include file="../common/top.jsp" %>
<!-- top 끝 -->


<main class="maincss">
<!-- view 시작 -->
<%@include file="./admin_list_view.jsp" %>
<!-- view 끝 -->
</main>


<!-- 푸터부분 -->
<%@ include file="../common/footer.jsp" %>
<!-- 푸터부분 -->

</body>
<script src="../common/js/admin/toadminlist.js?v=2"></script>
</html>