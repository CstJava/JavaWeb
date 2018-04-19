<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@page errorPage="/WEB-INF/error.jsp" %>
    
<%
		String phoneNum = request.getParameter("phoneNum");
		if(phoneNum==null||phoneNum.equals("")){
			response.sendRedirect("../../login/jsp/login.jsp");
		}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
    <title>重置密码 </title>
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
				<h1>请设置您的密码</h1>
				<form id="pword_complete" action="" method="post">
				<div id="error_tips" class="error_tips"></div>
					<input type="hidden" id="phoneNum" name="phoneNum" value="<%=phoneNum%>"/>
					<div class="rg_input">
						<input type="password" name="password" placeholder="新密码(不少于6位)" />
						<input type="password" name="passwordRepeat" placeholder="再次输入密码"/>
					</div>	
					<div class="rg_btn">
						<button type="button" onclick="changePassword()">确认</button>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>