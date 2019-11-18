<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>管理员登录</title>
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
   .navbar-inverse{
	           background-color: #400d0d;
	       }
 .carousel-inner .item img{
	 width:100%;
	 height:300px;
 } 
 
font {
    color: #666;
    font-size: 22px;
    font-weight: normal;
    padding-right:17px;
}
.error{
  color:white;
}
 </style>
 <script type="text/javascript">
 	function func(){
 		$("#span1").text("");
 	}
 	
 	
 </script>
 
</head>
<body>
			<!--
            	描述：菜单栏
            -->
			<%@ include file="/jsp/head.jsp" %>
	
	
	
	
	
	
<div class="container"  style="width:100%;height:460px;background:#d0d0d0 url('${pageContext.request.contextPath}/img/loginbg.jpg') no-repeat;">
<div class="row"> 
	<div class="col-md-7">
		<!--<img src="image/login.jpg" width="500" height="330" alt="会员登录" title="会员登录">-->
	</div>
	
	<div class="col-md-5">
				<div style="width:440px;border:1px solid #E7E7E7;padding:20px 0 20px 30px;border-radius:5px;margin-top:60px;background:#fff;">
				<font>管理员登录</font>USER LOGIN

				<div>&nbsp;</div>
<form id="forms" class="form-horizontal" action="${pageContext.request.contextPath }/UserServlet" method="post">
  <input type="hidden" name="method" value="adminLogin">
 <div class="form-group">
    <label for="username" class="col-sm-2 control-label">用户名</label>
    <span   id = "span1"  style="color: red">${message }</span>
    <div class="col-sm-6">
      <input type="text" onfocus="func()" name="username" value="${cookie.username.value }" class="form-control" id="username" placeholder="请输入用户名">
    </div>
  </div>
   <div class="form-group">
    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
    <div class="col-sm-6">
      <input type="password" name="password" class="form-control" id="inputPassword3" placeholder="请输入密码">
    </div>
  </div>
   <div class="form-group">
    <div class="col-sm-3">
    </div>
    <div class="col-sm-3">
    </div>
    
  </div>
   <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <div class="checkbox">
        <label>
        
          <input type="checkbox" name="rememberName" <c:if test="${cookie.username.value != null }">checked="checked"</c:if> value="1"> 记住用户名
        </label>
      </div>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
    <input type="submit"  width="100" value="登录" name="submit" border="0"
  style="background: url('${pageContext.request.contextPath}/img/login.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
    height:35px;width:100px;color:white;" >
    </div>
  </div>
</form>
</div>			
	</div>
</div>
</div>	

	<div style="margin-top:50px;">
			
		</div>

		
		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy;  叶子商城 版权所有
		</div>
</body>
<script src="${pageContext.request.contextPath}/js/jquery.validate.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/js/messages_zh.js" type="text/javascript"></script>
<script type="text/javascript">

$(function(){
		$("#forms").validate({
			rules:{
				username:{
				   required:true
			   },
			   password:{
				   required:true
			   }
			}
		})
	})
</script>
</html>