﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>叶子商城</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
	    <style>
	       .navbar-inverse{
	           background-color: #400d0d;
	       }
	    </style>
	</head>
	<body>
		
	<%@ include file="/jsp/head.jsp" %>
			<!--
            	描述：轮播条
            -->
			<div class="container-fluid">
				<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
						<li data-target="#carousel-example-generic" data-slide-to="1"></li>
						<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner" role="listbox">
						<div class="item active">
							<img src="${pageContext.request.contextPath}/img/ad/1.jpg">
							<div class="carousel-caption">

							</div>
						</div>
						<div class="item">
							<img src="${pageContext.request.contextPath}/img/ad/2.jpg">
							<div class="carousel-caption">

							</div>
						</div>
						<div class="item">
							<img src="${pageContext.request.contextPath}/img/ad/3.jpg">
							<div class="carousel-caption">

							</div>
						</div>
					</div>

					<!-- Controls -->
					<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
						<span class="sr-only">Previous</span>
					</a>
					<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
						<span class="sr-only">Next</span>
					</a>
				</div>
			</div>
			<!--

            	描述：商品显示
            -->
			 <div class="container-fluid">
				<div class="col-md-12" style="text-align:center">
					<h2>商品展示&nbsp;&nbsp;</h2>
				</div>
				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
					<img src="products/hao/big01.jpg" width="205" height="404" style="display: inline-block;"/>
				</div>
				<div class="col-md-10">
					<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
						<a>
							<img src="products/hao/middle1.jpg" width="516px" height="200px" style="display: inline-block;">
						</a>
					</div>
				<c:forEach items="${fhs }" var="li">
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="${pageContext.request.contextPath }/ProductServlet?method=findBypid&pid=${li.pid}">
							<img src="${pageContext.request.contextPath }/${li.pimage}" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="${pageContext.request.contextPath }/ProductServlet?method=findBypid&pid=${li.pid}" style='color:#666'>${li.pname }</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;${li.shop_price }</font></p>
					</div>
	 			</c:forEach>
					
				</div>
			</div>
			<!--

            	描述：广告部分
            -->
            <div class="container-fluid" style="text-align:center">
				<h2>最新商品&nbsp;&nbsp;</h2>
			</div>
			<!--

            	描述：商品显示
            -->
			<div class="container-fluid">
				<div class="col-md-12" >
					<h2>&nbsp;&nbsp;</h2>
				</div>
				<div class="col-md-2" style="border:1px solid #E7E7E7;border-right:0;padding:0;">
					<img src="products/hao/big02.jpg" width="205" height="404" style="display: inline-block;"/>
				</div>
				<div class="col-md-10">
					<div class="col-md-6" style="text-align:center;height:200px;padding:0px;">
						<a>
							<img src="products/hao/middle2.jpg" width="516px" height="200px" style="display: inline-block;">
						</a>
					</div>
				
					<c:forEach items="${fns }" var="li">
					<div class="col-md-2" style="text-align:center;height:200px;padding:10px 0px;">
						<a href="${pageContext.request.contextPath }/ProductServlet?method=findBypid&pid=${li.pid}">
							<img src="${pageContext.request.contextPath }/${li.pimage}" width="130" height="130" style="display: inline-block;">
						</a>
						<p><a href="${pageContext.request.contextPath }/ProductServlet?method=findBypid&pid=${li.pid}" style='color:#666'>${li.pname }</a></p>
						<p><font color="#E4393C" style="font-size:16px">&yen;${li.shop_price }</font></p>
					</div>
	 			</c:forEach>
	
					
				</div>
			</div>			
			<!--
            	描述：页脚部分
            -->
			<div class="container-fluid">
				<div style="margin-top:50px;">
					
				</div>
		

				<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
					Copyright &copy; 叶子商城 版权所有
				</div>
			</div>
		</div>
	</body>

</html>