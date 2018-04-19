<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
		String topicName= new String(request.getParameter("topicName").getBytes("ISO-8859-1"),"utf-8"); 
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>搜索</title>
<jsp:include page="/pages/common/base.jsp" />
<script type="text/javascript" src="pages/sys/select/js/select.js"></script>
</head>
<body>
	<jsp:include page="/pages/sys/index/head.jsp"></jsp:include>
	<div class="select">
	<input type="hidden" id="topicName" value="<%=topicName%>">
		<div class="select_top">
			<input type="text" id="selectTopic" >
			<img onclick="selectTopicUser()"  src="pages/img/select.png">
		</div>
		<div class="select_bottom">
			<div class="select_left">
				<div>相关话题</div>
				<div class="moreTopic" onclick="moreTopic()">加载更多...</div>	 
			</div>
			<div class="select_right">
				<div>相关用户</div>
				<div class="moreUser" onclick="moreUser()">加载更多...</div>
			</div>
		</div>
	</div>
</body>
</html>