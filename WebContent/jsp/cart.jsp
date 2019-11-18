<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>购物车</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>
		<style>
		  
			

			body {
				margin-top: 20px;
				margin: 0 auto;
			}
			.navbar-inverse{
	           background-color: #400d0d;
	             }
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
			
			.container .row div {
				/* position:relative;
	 float:left; */
			}
			
			font {
				color: #3164af;
				font-size: 18px;
				font-weight: normal;
				padding: 0 10px;
			}
			#imgShop{
			width:1160px;
			height:360px;
			}
		</style>
	</head>

	<body>

		
			<!--
            	描述：菜单栏
            -->
			<%@ include file="/jsp/head.jsp" %>

		
		<c:if test="${empty cart.item }">
		<div class="container">
			<div class="row">
				<a href="${pageContext.request.contextPath }/index.jsp">
					<img id="imgShop" src="${pageContext.request.contextPath }/image/timg.png">
				</a>
			</div>
		</div>

		</c:if>
		<c:if test="${not empty cart.item }">
		<div class="container">
			<div class="row">

				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<strong style="font-size:16px;margin:5px 0;">购物车详情</strong>
					<table class="table table-bordered">
						<tbody>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
								<th>操作</th>
							</tr>
							
							<c:forEach items="${cart.item }" var="li">
							<tr class="active">
								<td width="60" width="40%">
									<input type="hidden" name="id" value="22">
									<img src="${pageContext.request.contextPath}/${li.product.pimage }" width="70" height="60">
								</td>
								<td width="30%">
									<a target="_blank"> ${li.product.pname }</a>
								</td>
								<td width="20%">
									￥${li.product.shop_price}
								</td>
								<td width="10%">
									<input type="text" disabled="disabled" name="quantity" value="${li.count }" maxlength="4" size="10">
								</td>
								<td width="15%">
									<span class="subtotal">￥${li.subprice}</span>
								</td>
								<td>
									<a href="${pageContext.request.contextPath}/CartServlet?method=delete&pid=${li.product.pid }" class="delete">删除</a>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>

			<div style="margin-right:130px;">
				<div style="text-align:right;">
					<em style="color:#ff6600;">
				 商品金额: <strong style="color:#ff6600;">￥${cart.totalCount }元</strong>
				</div>
				<div style="text-align:right;margin-top:10px;margin-bottom:10px;">
					<a href="${pageContext.request.contextPath}/CartServlet?method=clearCart" id="clear" class="clear">清空购物车</a>
					<%-- <a href="${pageContext.request.contextPath}/jsp/order_info.jsp"> --%>
						<%--提交表单 --%>
						<form action="${pageContext.request.contextPath }/OrderServlet" method="post">
						<input type="hidden" name="method" value="addOrder">
						
						<input type="submit" width="100" value="提交订单" name="submit" border="0" style="background: url('${pageContext.request.contextPath}/img/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
						height:35px;width:100px;color:white;">
						</form>
					<!-- </a> -->
				</div>
			</div>

		</div>
		</c:if>
		<div style="margin-top:50px;">
			
		</div>


		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 叶子商城 版权所有
		</div>

	</body>

</html>