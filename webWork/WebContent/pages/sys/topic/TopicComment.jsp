<%@page import="com.service.comment.Comment"%>
<%@page import="com.service.user.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

	<!-- <div class="index_topic">
		<div class="index_topic_head">
			<img src="images/e245dd3eb1d0d15bceaf9e5718460011.jpg">
			<span class="index_topic_head_name"></span>
			<span class="index_topic_head_jiesao">哈哈哈哈</span>
		</div>
		
		<div class="index_topic_body">
			<div class="index_topic_name">无聊</div>
			<div class="index_topic_content">哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈<span>点击进入 ></span></div>
		</div>
		
		<div class="index_topic_foot">
			<img onclick="" src="images/zan.png">
		</div>
	</div>  -->
<%
	String zan="#zan";
	String topicNum = request.getParameter("topicNum");
	ArrayList<User> userList = (ArrayList<User>)session.getAttribute(topicNum+"UserList");	
	ArrayList<Comment> commentList = (ArrayList<Comment>)session.getAttribute(topicNum+"CommentList");	
	int lie=Integer.parseInt(request.getParameter("currentCommentPage")); 
	for(int i=lie*5;i<userList.size();i++){
		if(i>=(lie+1)*5){
			break;
		}
		out.print("<div class="+'"'+"index_topic"+'"'+">");
		out.print("<div onclick="+'"'+"openOthersIndex("+userList.get(i).getPhoneNum()+")"+'"'+"  class="+'"'+"index_topic_head"+'"'+">");
		out.print("<img src="+'"'+userList.get(i).getHeadSculptureAdd()+'"'+">");
		out.print("<span id="+'"'+"userName"+i+'"'+"class="+'"'+"index_topic_head_name"+'"'+">"+userList.get(i).getName()+"</span>");
		out.print("<span class="+'"'+"index_topic_head_jiesao"+'"'+">"+userList.get(i).getIntroduction()+"</span>");
		out.print("</div>");
		out.print("<div class="+'"'+"index_topic_body"+'"'+">");
		out.print("<div class="+'"'+"index_topic_content"+'"'+">"+commentList.get(i).getCommentContent()+"</div>");
		out.print("</div>");
		out.print("<div class="+'"'+"index_topic_foot"+'"'+">");
		out.print("<img onclick="+'"'+"commentZan('"+(zan+i)+"',"+commentList.get(i).getCommentNum()+")"+'"'+"id="+'"'+"zan"+i+'"'+"src="+'"'+"images/zan.png"+'"'+">"); 
		out.print("<span>"+commentList.get(i).getZan()+"</span>");
		out.print("<span style="+'"'+"color:#f9a114;"+'"'+">"+commentList.get(i).getCommentTime()+"</span>");
		out.print("</div>");
		out.print("</div>");
	} 				
%>