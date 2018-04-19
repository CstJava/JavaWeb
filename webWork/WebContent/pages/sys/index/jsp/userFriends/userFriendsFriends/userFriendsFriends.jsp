<%@page import="com.service.user.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page errorPage="/WEB-INF/error.jsp" %>
<%
	String phoneNum = request.getParameter("phoneNum");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>朋友</title>
<jsp:include page="/pages/common/base.jsp" />
<script type="text/javascript" src="pages/sys/index/jsp/userFriends/userFriendsFriends/js/userFriendsFriends.js"></script>
</head>
<body>
	<input id="phoneNum" name="phoneNum"  type="hidden" value="<%=phoneNum%>">
	<jsp:include page="/pages/sys/index/head.jsp"></jsp:include>
	<div class="index_body">
		<div class="friends">
			<div class="friends_left">
				<ul>
					<li id="li1"onclick="concern()">她关注的人</li>
					<li id="li2"onclick="fans()">她的粉丝</li>
				</ul>
			</div>		
			<div class="friends_right">			
				<iframe id="friends_iframe" class="userActivityIframe" ></iframe>
			</div>
		</div>
		
	</div>
</body>
</html>