<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head></head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>上传商品</title>
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
	<div class="col-md-2"></div>
<div class="col-md-8" style="background:#d0d0d0 url('${pageContext.request.contextPath}/img/loginbg.jpg');padding:40px 80px;margin:30px;border:7px solid #ccc;">
		<font>商品详情</font>
<form id="forms" class="form-horizontal" style="margin-top:5px;" action="${pageContext.request.contextPath }/SaveProductServlet" method="post">
	<input type="hidden"  name="pid" value="${product.pid}">
	
	<input type="hidden"  name="method"  value="saveProduct">
	请输入商品名称：<input type="text" name="pname" value="${product.pname}" placeholder="请输入商品名称" /><br /><br />
	请输入商场价格：<input type="number" name="market_price" value="${product.market_price}" placeholder="请输入商场价格" /><br /><br />
	请输入市场价格：<input type="number" name="shop_price" value="${product.shop_price}" placeholder="请输入市场价格" /><br /><br />
	
	请输入商品描述：<textarea name="pdesc" value="${product.pdesc}">${product.pdesc}</textarea><br /><br />
	请输入商品类别：<input type="text" name="cid" value="${product.cid}" placeholder="1为手机/2为电脑/3为电器" /><br /><br />
	
	请输入图片名称：<input type="text" name="pimage" value="${product.pimage}" placeholder="fileName" /><br /><br />
	
		<input type="submit" value="提交" />	

	
</form>
</div>
<div class="col-md-2"></div>


	
</body>
<script src="${pageContext.request.contextPath}/js/jquery.validate.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/messages_zh.js" type="text/javascript"></script>

</html>