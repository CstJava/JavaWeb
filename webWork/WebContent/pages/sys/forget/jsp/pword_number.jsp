<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
    <title>填写账号·</title>
    <jsp:include page="/pages/common/base.jsp" />
    <jsp:include page="/pages/common/userExist.jsp" />  
    <script type="text/javascript" src="pages/sys/forget/js/forget.js"></script>
</head>
<body>
	<div class="main_body">
		<div class="header">
			<h1 class="logo">Talk</h1>
			<h2 class="logo_text">与大家一起分享你的见闻</h2>
		</div>
		<div class="register">
			<h1>验证账号</h1>
			<form action="" method="post" id="pword_number">
			<div id="error_tips" class="error_tips"></div>
				<div class="rg_input">
					<input type="text" id="phoneNum" name="phoneNum" placeholder="请输入帐号" />		
					<input type="text" id="email" name="email" class="email" placeholder="请输入邮箱"/>
                        <button onclick="testEmail()" type="button">获取验证码</button>
                        <input type="text" id="emailcode" name="emailcode" placeholder="请输入验证码"/>
				</div>	
				<div class="rg_btn">
					<button type="button" onclick="next()">下一步</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>