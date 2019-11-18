<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>商品列表</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>

		<style>
		    
			body {
				margin-top: 20px;
				margin: 0 auto;
				width: 100%;
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



		<div class="row" style="width:1210px;margin:0 auto;">
			<div class="col-md-12">
				<ol class="breadcrumb">
				</ol>
			</div>
		 <c:forEach  items="${pb.list }"  var="li">
				<div class="col-md-2">
					<a href="${pageContext.request.contextPath }/ProductServlet?method=findBypid&pid=${li.pid}">
						<img src="${pageContext.request.contextPath}/${li.pimage}" width="170" height="170" style="display: inline-block;">
					</a>
					<p><a href="${pageContext.request.contextPath }/ProductServlet?method=findBypid&pid=${li.pid}" style='color:green'>${fn:substring(li.pname,0,8) }</a></p>
					<p><font color="#FF0000">商城价：&yen;${li.shop_price }</font></p>  
				</div>
            </c:forEach>
		</div>

		<!--分页 -->
		<div style="width:380px;margin:0 auto;margin-top:50px;">
			<ul class="pagination" style="text-align:center; margin-top:10px;">
			
			  <c:if test="${pb.pageNumber>1 }">
			      <li><a href="${pageContext.request.contextPath}/ProductServlet?method=findBycid&pageNumber=${pb.pageNumber-1 }&cid=${param.cid}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
			  </c:if>
			  <c:if test="${pb.pageNumber<=1 }">
			      <li class="disabled"><a aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
			  </c:if>	
				
			  <c:forEach begin="1" end="${pb.totalPage }" var="i">
			     <c:if test="${pb.pageNumber==i }">
			         <li class="active"><a>${i }</a></li>
			     </c:if>
			     <c:if test="${pb.pageNumber!=i }">
			          <li><a href="${pageContext.request.contextPath}/ProductServlet?method=findBycid&pageNumber=${i }&cid=${param.cid}">${i }</a></li>
			     </c:if>
			  </c:forEach>
				
				
		     <c:if test="${pb.pageNumber<pb.totalPage }">
		         <li><a href="${pageContext.request.contextPath}/ProductServlet?method=findBycid&pageNumber=${pb.pageNumber+1 }&cid=${param.cid}" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
		     </c:if>		
			 <c:if test="${pb.pageNumber>=pb.totalPage }">
		         <li class="disabled" ><a  aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
		     </c:if>	
			</ul>
		</div>
		<!-- 分页结束=======================        -->

		
		<div style="margin-top:50px;">
			
		</div>

		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 叶子商城 版权所有
		</div>

	</body>

</html>