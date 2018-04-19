<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<jsp:include page="/pages/common/base.jsp" />
		<jsp:include page="/pages/common/userExist.jsp" />
		<script type="text/javascript" src="pages/sys/login/js/login.js"></script>
		<title>登录</title>
	</head>
	<body>
		<div class="main_body">
			<div class="header">
				<h1 class="logo">Talk</h1>
				<h2 class="logo_text">与大家一起分享你的见闻</h2>
			</div>
			<div class="register">
				<h1>用户登录</h1>
				<a class="sign" href="pages/sys/register/jsp/register.jsp">注册账号</a>
				<form id="login_form" action="" method="post">
					<span id="error_tips" class="error_tips"></span>
					<div class="rg_input">
						<input type="text" id="phoneNum" name="phoneNum" placeholder="用户帐号" />
						<input type="password" id="password" name="password" placeholder="用户密码(不少于6位)"/>
					</div>	
					
				</form>
				<div class="rg_btn">
						<button type="submit" onclick="login()">登录</button>
					</div>
			</div>
			<div class="go_login">
			<span>忘记密码？</span><a href="pages/sys/forget/jsp/pword_number.jsp">点此找回</a>
			</div>
		</div>
	</body>
</html>