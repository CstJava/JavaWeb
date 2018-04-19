<%@page import="com.service.user.User"%>
<%@page import="com.service.topic.Topic"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
	<%
		String topicNum=request.getParameter("topicNum");
		Topic topic= (Topic)session.getAttribute(topicNum+"Topic");
		User user =(User)session.getAttribute(topicNum+"TopicUser");
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include page="/pages/common/base.jsp" />
<script type="text/javascript" src="pages/sys/topic/js/topic.js"></script>
<script type="text/javascript">
		var currentCommentPage = -1; //默认话题评论第一页
	
		$(function(){
			requsetGetList("TopicServlet?method=topicComment","topicNum="+<%=topicNum%>);
			moreComment();
		    $('.moreComment').click(function () {
		    	requsetGetList("TopicServlet?method=topicComment","topicNum="+<%=topicNum%>);
		    	moreComment();
		    });			
			isCollect(<%=topicNum%>,"#collect");
			isConcern(<%=user.getPhoneNum()%>,".Concern_topicUser_span");
		});
		function moreComment(){
			 $.ajax({ url: 'pages/sys/topic/TopicComment.jsp', type: 'POST', data: { currentCommentPage: currentCommentPage+1,topicNum:<%=topicNum%>}, complete: function (xhr) {               
		         if (200==xhr.status) {//成功返回
		             if(currentCommentPage!=1)
		             $(xhr.responseText).insertBefore('.moreComment');//将返回内容插入容器中
		         }
		         else alert('动态页出错，返回内容：'+xhr.responseText);
		     }
		     });
			 currentCommentPage++;
		     return false;
		}
	
</script>
<title><%=topic.getTopicName()%></title>
</head>
<body>
	<jsp:include page="/pages/sys/index/head.jsp"></jsp:include>
	<div class="topic">
		<div class="topic_top">
			<div class="topic_top_left">
				<div class="index_topic_type" style="float:none;" ><%=topic.getTopicType()%></div>
				<div class="topicName"><%=topic.getTopicName()%></div>	
				<div class="topicInfo">
					<span><img onclick="zanView('#zan',<%=topic.getTopicNum()%>)" id="zan" src="images/zan.png"><%=topic.getZan()%></span>
					<span><%=topic.getTopicCommentNum()%>条评论</span>
					<span><%=topic.getTopicClickNum()%>点击次数</span>
					<span><%=topic.getCollectionNum()%><span onclick="updateCollect(<%=topicNum%>,'#collect')" style="margin-left:0;" id="collect"></span></span>
					<span>创建时间:<%=topic.getTopicCreateTime()%></span>
				</div>
				<div class="topicContent"><%=topic.getTopicContent()%></div>
			</div>
			<div class="topic_top_right">
				<div>关于作者</div>
				<div onclick="openOthersIndex(<%=user.getPhoneNum()%>)" class="topicUser_info">
					<img src="<%=user.getHeadSculptureAdd()%>">
					<div style="float:right;">
						<span style="font-weight: 600;font-size: 25px;"><%=user.getName() %></span>
						<span><%=user.getIntroduction() %></span>
					</div>
				</div>
				<div class="topicUser_follw_user" onclick="relation(<%=user.getPhoneNum()%>)">
					<div>
						<div style="color:#8590a6">粉丝</div>
						<div><%=user.getFans() %></div>
					</div>
					<div>
						<div style="color:#8590a6">关注</div>
						<div><%=user.getGuanzhu()%></div>
					</div>
				</div>
				<div class="Concern_topicUser"><button class="Concern_topicUser_span" onclick="setRelation(<%=user.getPhoneNum()%>,'.Concern_topicUser_span')"></button></div>
			</div>
		</div>
		<div class="topic_bottom">
			<div>评论区
				<input id="topicNum" type="hidden" value="<%=topic.getTopicNum()%>">
				<textarea id="createTopicComment" name="createTopicComment"></textarea>
				<button onclick="createTopicComment()">评论</button>
			</div>
			<div class="moreComment" onclick="moreComment()">加载更多...</div>	 
		</div>
	</div>
</body>
</html>