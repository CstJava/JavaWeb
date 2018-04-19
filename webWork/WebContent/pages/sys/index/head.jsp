<%@page import="com.service.user.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<script type="text/javascript" src="pages/sys/index/js/head.js"></script>
<% 
	String touxiangSrc = ((User)session.getAttribute("id")).getHeadSculptureAdd();
%>

<div class="ce_header">
	<div class="hd_inner">
		<div class="inner_logo">
			<span>Talk</span>
		</div>
		<a href="pages/sys/index/jsp/index.jsp" class="nav">首页</a>
		<div class="select_input">
			<input id="select" name ="select" placeholder="搜索"><img onclick="selectTopic();" src="pages/img/select.png"/>
		</div>
		<div class="info" onclick="show()">
			<img src="<%=touxiangSrc%>"/>
			<div class="head_show" onclick="head_show()">
				<a href="pages/sys/index/jsp/userIndex.jsp">我的主页</a>
				<a href="pages/sys/index/jsp/set.jsp">设置</a>
				<a href="pages/common/zhuxiao.jsp">退出</a>
			</div>
		</div>
		<div class="msg">
			<a href="pages/sys/index/jsp/index.jsp"><img src="pages/img/msg.png"/></a>
		</div>
		<div class="msg">
			<a href="pages/sys/index/jsp/index.jsp"><img src="pages/img/msg.png"/></a>
		</div>
	</div>
</div>

