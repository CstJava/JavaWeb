<%@page import="com.service.user.User"%>
<%@page errorPage="/WEB-INF/error.jsp" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%
		String userFriends = request.getParameter("phoneNum");	
    	String myPhoneNum =((User)session.getAttribute("id")).getPhoneNum();
    	if(userFriends.equals(myPhoneNum)){
    		response.sendRedirect("userIndex.jsp");   
    	}
    	String touxiangSrc = ((User)session.getAttribute(userFriends)).getHeadSculptureAdd();
		String address = ((User)session.getAttribute(userFriends)).getAddress();
		String age = ""+((User)session.getAttribute(userFriends)).getAge();
		String othersName = ((User)session.getAttribute(userFriends)).getName();
		String sex = ((User)session.getAttribute(userFriends)).getSex();
		String email = ((User)session.getAttribute(userFriends)).getEmail();
		String introduction = ((User)session.getAttribute(userFriends)).getIntroduction();
		String phoneNum= ((User)session.getAttribute(userFriends)).getPhoneNum();
		String fans = ""+((User)session.getAttribute(userFriends)).getFans();
		String guanzhu = ""+((User)session.getAttribute(userFriends)).getGuanzhu();
		String userCreateTime = ((User)session.getAttribute(userFriends)).getUserCreateTime();
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title><%=othersName%>主页</title>
<jsp:include page="/pages/common/base.jsp" />
<script type="text/javascript" src="pages/sys/index/js/othersIndex.js"></script>
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
						<span class="display_user_name"><%=othersName%></span>
						<button onclick="setRelation(<%=phoneNum%>,'.go_personal_data')" class="go_personal_data" ></button>			
					</div>
					<span class="display_personal_data">
						<%=introduction%>
					</span>
				</div>
			</div>
			<div class="my_activities">
				<ul style="-webkit-padding-start: 0;"class="user_activities">					
					<li style="width:100%;color:rgb(15,136,235);font-weight: bold;text-align: center;border-bottom:3px solid rgb(15,136,235);margin:0;"><%=othersName%>的帖子</li>									
				</ul>
				<input id="phoneNum" name="phoneNum" type="hidden" value="<%=phoneNum%>">	
				
				<div class="userActivieIframe_outSize">
						<iframe id="userActivityIframe" class="userActivityIframe" 
					scrolling="auto" src="pages/sys/index/jsp/userFriends/othersTopic.jsp?phoneNum=<%=phoneNum%>"></iframe>
				</div>			
			</div>
			<div class="my_follow">
				<div class="follw_user" onclick="relation(<%=phoneNum%>)">
					<div class="follow_others">
						关注<br/>
						<span><%=guanzhu%></span>
					</div>
					<div class="followers">
						粉丝<br/>
						<span><%=fans%></span>
					</div>
				</div>
				<div class="user_info">
					<ul>
						<li>姓名:&nbsp<%=othersName %></li>
						<li>年龄:&nbsp<%=age%></li>
						<li>性别:&nbsp<%=sex%></li>
						<li>邮箱:&nbsp<%=email%></li>
						<li>创建时间:&nbsp<%=userCreateTime%></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>