<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>
	<head></head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>会员注册</title>
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
 <script type="text/javascript">
 $(function(){
	   $("#username").blur(function(){
		 
		   var str = this.value;
		   if(str == null || $.trim(str) == ""){
			   return ;
		   }
		   
		   $.post("${pageContext.request.contextPath}/UserServlet?method=registerUname",{uname:str}, function(data){
		          
			   if(data=="1"){
        		 $("#span2").hide();
        		 $("#span1").show();
        		 
        	 }else{
        		 $("#span1").hide();
        		 $("#span2").show();
        	 }
			   
		  });
	   })
	   
	  
 })
 </script>
  
</head>
<body>
			<!--
            	描述：菜单栏
            -->
			<%@ include file="/jsp/head.jsp" %>




<div class="container" style="width:100%;background:url('${pageContext.request.contextPath}/img/regist_bg.jpg');">
<div class="row"> 

	<div class="col-md-2"></div>
	
	


	<div class="col-md-8" style="background:#d0d0d0 url('${pageContext.request.contextPath}/img/loginbg.jpg');padding:40px 80px;margin:30px;border:7px solid #ccc;">
		<font>用户注册</font>USER REGISTER
		<form id="forms" class="form-horizontal" style="margin-top:5px;" action="${pageContext.request.contextPath }/UserServlet" method="post">
			 
			 <input type="hidden"  name="method"  value="register">
			 <div class="form-group">
			    <label for="username" class="col-sm-2 control-label">用户名</label>
			     <span id="span1" style="display: none;" class="label label-success">用户名可用</span>
					<span id="span2" style="display: none;" class="label label-danger">用户名不可用</span>
			    <div class="col-sm-6">
			      <input type="text" name="username" class="form-control" id="username" placeholder="请输入用户名">
			    </div>
			    
			  </div>
			   <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
			    <div class="col-sm-6">
			      <input type="password" name="password" class="form-control" id="inputPassword3" placeholder="请输入密码">
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
			    <div class="col-sm-6">
			      <input type="password" name="repassword" class="form-control" id="confirmpwd" placeholder="请输入确认密码">
			    </div>
			  </div>
			  
			 	 
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <input type="submit"  width="100" value="注册" name="submit" border="0"
				    style="background: url('${pageContext.request.contextPath}/img/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
				    height:35px;width:100px;color:white;">
			    </div>
			  </div>
			</form>
	</div>
	
	<div class="col-md-2"></div>
  
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
			   },
			   repassword:{
				   equalTo:"#inputPassword3"
			   }
			}
		})
	})

</script>
</html>



