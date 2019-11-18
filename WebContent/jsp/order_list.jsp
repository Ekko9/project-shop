﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>会员登录</title>
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
		</style>
	</head>

	<body>

			<!--
            	描述：菜单栏
            -->
			<%@ include file="/jsp/head.jsp" %>

		

		<div class="container">
			<div class="row">

				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<table style="width:100%" > 
					   <tr>
					     <td><strong><h2>我的订单</h2></strong></td>
					   </tr>
					</table>
				<!-- 	<strong><h2>已购买商品</h2></strong>
					<strong><h2>继续购物</h2></strong> -->
					<table class="table table-bordered">
						 <c:forEach  items="${list }" var="order">
						<tbody>
							<tr class="success">
								<th colspan="2">订单编号:${order.oid } </th>
								<th colspan="3">
								      <c:if test="${order.state==0 }">
								          <a href="${pageContext.request.contextPath }/OrderServlet?method=findByoid&oid=${order.oid }"> 未支付</a>
                                       </c:if>
								      <c:if test="${order.state==1 }">已支付</c:if>
								      <c:if test="${order.state==2 }">已发货</c:if>
								      <c:if test="${order.state==3 }">交易完成</c:if>
								</th>
							</tr>
							<tr class="warning">
								<th>图片</th>
								<th>商品</th>
								<th>价格</th>
								<th>数量</th>
								<th>小计</th>
							</tr>
							<c:forEach items="${order.list }" var="item">
								<tr class="active">
									<td width="60" width="40%">
										<input type="hidden" name="id" value="22">
										<img src="${pageContext.request.contextPath}/${item.product.pimage}" width="70" height="60">
									</td>
									<td width="30%">
										<a target="_blank">${item.product.pname}</a>
									</td>
									<td width="20%">
										￥${item.product.shop_price}
									</td>
									<td width="10%">
										${item.count}
									</td>
									<td width="15%">
										<span class="subtotal">￥${item.subtotal}</span>
									</td>
								</tr>
							</c:forEach>
						</tbody>
						</c:forEach>
					</table>
				</div>
			</div>
		</div>

		<div style="margin-top:50px;">
			
		</div>

		<div style="text-align: center;margin-top: 5px;">
			<ul class="list-inline">
				
			
				
			</ul>
		</div>
		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 叶子商城 版权所有
		</div>
	</body>

</html>