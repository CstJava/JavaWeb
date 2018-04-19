<%@page import="com.service.topic.Topic"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.servlet.TopicServlet"%>
<%@page import="com.service.user.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page errorPage="/WEB-INF/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta 	 http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>
<jsp:include page="/pages/common/base.jsp" />
<script type="text/javascript" src="pages/sys/index/js/index.js"></script>
<script>
</script>
	<%
	ArrayList<Object> indexFriendsTopiclist = (ArrayList<Object>)session.getAttribute("indexFriendsTopicList");
	%>
</head>
<body>
	<jsp:include page="/pages/sys/index/head.jsp"></jsp:include>	
	<div class="index_body">
		<div class="index_left">
			<div class="index_function">
				<ul>
					<li onclick="publishQuestion()">发起提问</li>
					<li onclick="publishPost()">写文章</li>
				</ul>
					<jsp:include page="/pages/sys/index/jsp/createTopic.jsp"></jsp:include>
			</div>
			
		<div class="more" onclick="more()">加载更多...</div>	 
	
		<div class="index_right">
			<div class="concern">
				<div style="color:#76a513">好友动态</div>
			<%
			for(int i=0;i<indexFriendsTopiclist.size();i+=2){
				out.print("<div class="+'"'+"concern_activity"+'"'+">");
				out.print("<input id="+'"'+"friendsTopicNum"+i+'"'+"type="+'"'+"hidden"+'"'+" value="+((Topic)indexFriendsTopiclist.get(i)).getTopicNum()+">");
				out.print("<input id="+'"'+"friendsPhoneNum"+i+'"'+"type="+'"'+"hidden"+'"'+" value="+((User)indexFriendsTopiclist.get(i+1)).getPhoneNum()+">");
				out.print("<div onclick="+'"'+"openOthersIndex("+((User)indexFriendsTopiclist.get(i+1)).getPhoneNum()+")"+'"'+"class="+'"'+"concern_activity_head"+'"'+">");
				out.print("<img src="+'"'+((User)indexFriendsTopiclist.get(i+1)).getHeadSculptureAdd()+'"'+">");
				out.print("<span id="+'"'+"friendsName"+i+'"'+">"+((User)indexFriendsTopiclist.get(i+1)).getName()+"</span>");
				out.print("</div>");
				out.print("<div class="+'"'+"concern_activity_body"+'"'+">");
				out.print("<div class="+'"'+"concern_activity_body_name"+'"'+">"+((Topic)indexFriendsTopiclist.get(i)).getName()+"<span>"+((Topic)indexFriendsTopiclist.get(i)).getTopicCreateTime()+"</span></div>");
				out.print("<div onclick="+'"'+"topic("+((Topic)indexFriendsTopiclist.get(i)).getTopicNum()+")"+'"'+" class="+'"'+"concern_activity_body_content"+'"'+">"+((Topic)indexFriendsTopiclist.get(i)).getTopicContent()+"<span>...点击进入  ></span></div>");
				out.print("</div>");
				out.print("</div>");
				if(i>=10)break;
			} 				
			%>
				<!--  <div class="concern_activity">
					<div class="concern_activity_head">
						<img src="images/528254.jpg">
						<span>姓名</span>
					</div>
					<div class="concern_activity_body">
						<div class="concern_activity_body_name">无聊<span>时间</span></div>
						<div class="concern_activity_body_content">哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈<span>...点击进入 ></span></div>
					</div>
				</div>  -->
			</div>
		</div>	
	</div>
</body>
</html>