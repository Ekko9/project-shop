<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>商品</title>
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

		

		<div class="container">
			<div class="row">

				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<strong style="font-size:16px;margin:5px 0;">商品详情</strong>
					<table class="table table-bordered">
						<tbody>
							<tr class="warning">
								<th>商品图片</th>
								<th>商品名称</th>
								<th>商场价格</th>
								<th>市场价格</th>
								<th>商品描述</th>
								<th>操作</th>
							</tr>
							
							<c:forEach items="${productList}" var="li">
							<tr class="active">
								<td width="60" width="40%">
									<input type="hidden" name="id" value="22">
									<img src="${pageContext.request.contextPath}/${li.pimage }" width="70" height="60">
									
								</td>
								<td width="30%">
									<a target="_blank"> ${li.pname}</a>
								</td>
								<td width="20%">
									￥${li.shop_price}
								</td>
								<td width="10%">
									￥${li.market_price}
								</td>
								<td width="15%">
									${li.pdesc}
								</td>
								<td>
									<a href="${pageContext.request.contextPath}/ProductServlet?method=delete&pid=${li.pid }" class="delete">下架</a>&nbsp&nbsp
									<%-- <a href="${pageContext.request.contextPath}/ProductServlet?method=update&pid=${li.pid }" class="delete">编辑</a> --%>
								</td>
							</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

	
	
		<div style="margin-top:50px;">
			
		</div>


		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 叶子商城 版权所有
		</div>

	</body>

</html>