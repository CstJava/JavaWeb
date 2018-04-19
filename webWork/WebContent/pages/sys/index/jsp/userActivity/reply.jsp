<%@page import="java.util.HashMap"%>
<%@page import="com.service.topic.Topic"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.service.user.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page errorPage="/WEB-INF/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include page="/pages/common/base.jsp" />

<title>回复</title>
</head>
<body>
	<%
		ArrayList<HashMap<String,String>> list=(ArrayList<HashMap<String,String>>)session.getAttribute("userCommentTopicList");
		
		for(int i=0;i<list.size();i++){
			out.print("<input id="+'"'+"topicNum"+i+'"'+" name="+'"'+"i"+'"'+"type="+'"'+"hidden"+'"'+" value="+list.get(i).get("topicNum")+">	");
			out.print("<div onclick="+'"'+"topic("+list.get(i).get("topicNum")+")"+'"'+" class="+'"'+"topicComment_link"+'"'+">");
			out.print("<div class="+'"'+"topicComment_link_head"+'"'+">");
			out.print("<span>"+list.get(i).get("commentContent")+"</span>");
			out.print("</div>");
			out.print("<div class="+'"'+"topicComment_link_foot"+'"'+">");
			out.print("<span>"+list.get(i).get("commentName")+"</span>");
			out.print("<span>"+"       话题："+list.get(i).get("topicName")+"</span>");
			out.print("<span style="+'"'+"float:right"+'"'+">"+list.get(i).get("commentTime")+"</span>");
			out.print("</div>");
			out.print("</div>");
		}
		
	%>
</body>
</html>