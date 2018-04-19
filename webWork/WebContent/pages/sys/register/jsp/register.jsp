<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page errorPage="/WEB-INF/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<jsp:include page="/pages/common/base.jsp" />
		<jsp:include page="/pages/common/userExist.jsp" />
		<script type="text/javascript" src="pages/sys/register/js/register.js"></script>
		<title>注册</title>
	</head>
	<body>
		<div class="main_body">
			<div class="header">
				<h1 class="logo">Talk</h1>
				<h2 class="logo_text">与大家一起分享你的见闻</h2>
			</div>
			<div class="register">
				<h1>注册帐号</h1>
				
				<form id="register" method="post">
					<div id="error_tips" class="error_tips"></div>
					<div class="rg_input">
						<input type="text" id="phoneNum"name="phoneNum" placeholder="请输入账号号" />
						<input type="text" id="name"name="name" placeholder="用户名" onfocus="test()"/>
						<input type="password" id="password"name="password" placeholder="用户密码(不少于6位)" onfocus="test()" />
						<input type="password" id="passwordRepeat"name="passwordRepeat" placeholder="再次输入密码" onfocus="test()"/>
						<input type="text" id="email"name="email" class="email" placeholder="邮箱" onfocus="test()"/>
						<select name="email_hz">   
                            <option >@qq.com</option>   
                            <option >@163.com</option> 
                         </select>
                         <button type="button"onclick="sentEmail()">获取验证码</button>
                         <input type="text" id="emailcode" name="emailcode" placeholder="请输入验证码"/>
					</div>	
				</form>
				<div class="rg_btn">
					<button onclick="register()">确定注册</button>
				</div>
			</div>
			<div class="go_login">
				<span>已有帐号？</span><a href="/webWork/pages/sys/login/jsp/login.jsp">点此进行登陆</a>
			</div>
		</div>
	</body>
</html>
