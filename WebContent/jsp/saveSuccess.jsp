<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head></head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>上传成功</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>

<style>
  body{
   margin-top:20px;
   margin:0 auto;
 }
 .carousel-inner .item img{
	 width:100%;
	 height:300px;
 }
.navbar-inverse{
	           background-color: #400d0d;
	       }
 
font {
    color: #3164af;
    font-size: 18px;
    font-weight: normal;
    padding: 0 10px;
}
.error{
  color:red;
}

 </style>

</head>
<body>
	<%@ include file="/jsp/head.jsp" %>
    <img style="text-align:center" id="imgShop" src="${pageContext.request.contextPath }/image/success.jpg">
</body>
<script src="${pageContext.request.contextPath}/js/jquery.validate.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/messages_zh.js" type="text/javascript"></script>

</html>