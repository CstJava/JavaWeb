<%@page import="com.service.user.User"%>
<%@page errorPage="/WEB-INF/error.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>个人主页</title>
<jsp:include page="/pages/common/base.jsp" />
<script type="text/javascript" src="pages/sys/index/js/userIndex.js"></script>
	<%
	String touxiangSrc = ((User)session.getAttribute("id")).getHeadSculptureAdd();
	String address = ((User)session.getAttribute("id")).getAddress();
	String age = ""+((User)session.getAttribute("id")).getAge();
	String name = ((User)session.getAttribute("id")).getName();
	String sex = ((User)session.getAttribute("id")).getSex();
	String email = ((User)session.getAttribute("id")).getEmail();
	String introduction = ((User)session.getAttribute("id")).getIntroduction();
	String phoneNum= ((User)session.getAttribute("id")).getPhoneNum();
	String fans = ""+((User)session.getAttribute("id")).getFans();
	String guanzhu = ""+((User)session.getAttribute("id")).getGuanzhu();
	String userCreateTime = ((User)session.getAttribute("id")).getUserCreateTime();
	%>
</head>
<body>
	<jsp:include page="/pages/sys/index/head.jsp"></jsp:include>
	<div class="ce_body">
		<div class="ce_body_inner">
			<div class="ce_inner_header">
				<div class="icon_wrap">
					<img src="<%=touxiangSrc%>"/>
				</div>
				<div class="inner_header_bottom">
					<div class="">
						<span class="display_user_name"><%=name%></span>
						<button class="go_personal_data"><a href="pages/sys/index/jsp/userModify.jsp">编辑个人资料</a></button>
					</div>
					<span class="display_personal_data">
						<%=introduction%>
					</span>
				</div>
			</div>
			<!--<div class="ce_inner_body"></div>-->
			
			<div class="my_activities">
				<ul class="user_activities">
					<li id="li1" onclick="dongtai()">动态</li>
					<li id="li2" onclick="huida()">回复</li>
					<li id="li3" onclick="tiezi()">帖子</li>
					<li id="li4" onclick="zuijinfangwen()">最近访问</li>
					<li id="li5" onclick="shoucang()">收藏</li>					
				</ul>
				<input id="phoneNum" name="phoneNum" type="hidden" value="<%=phoneNum%>">	
				
				<div class="userActivieIframe_outSize">
						<iframe id="userActivityIframe" class="userActivityIframe" 
					scrolling="auto" src="pages/sys/index/jsp/userActivity/dynamics.jsp"></iframe>
				</div>			
			</div>
			<div class="my_follow">
				<div class="follw_user" onclick="relation()">
					<div class="follow_others" >
						关注<br/>
						<span><%=guanzhu%></span>
					</div>
					<div class="followers" >
						粉丝<br/>
						<span><%=fans%></span>
					</div>
				</div>
				<div class="user_info">
					<ul>
						<li>账号:&nbsp<%=phoneNum%></li>
						<li>姓名:&nbsp<%=name %></li>
						<li>年龄:&nbsp<%=age%></li>
						<li>性别:&nbsp<%=sex%></li>
						<li>邮箱:&nbsp<%=email%></li>
						<li>地址:&nbsp<%=address%></li>
						<li>创建时间:&nbsp<%=userCreateTime%></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>