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
<title>帖子</title>
</head>
<body>
	<%
		String phoneNum= request.getParameter("phoneNum");
		ArrayList<Topic> list=(ArrayList<Topic>)session.getAttribute(phoneNum+"TopicList");		
		for(int i=0;i<list.size();i++){
			out.print("<input id="+'"'+"topicNum"+i+'"'+" name="+'"'+"i"+'"'+"type="+'"'+"hidden"+'"'+" value="+list.get(i).getTopicNum()+">	");
			out.print("<div onclick="+'"'+"topic("+list.get(i).getTopicNum()+")"+'"'+" class="+'"'+"topic_link"+'"'+">");
			out.print("<div class="+'"'+"topic_link_head"+'"'+">");
			out.print("<span>"+list.get(i).getTopicName()+"</span>");
			out.print("</div>");
			out.print("<div class="+'"'+"topic_link_body"+'"'+">");
			out.print("<span>"+list.get(i).getTopicContent()+"</span>");
			out.print("</div>");
			out.print("<div class="+'"'+"topic_link_foot"+'"'+">");
			out.print("<span style="+'"'+"float:right"+'"'+">"+list.get(i).getTopicCreateTime()+"</span>");
			out.print("</div>");
			out.print("</div>");
		}
		
	%>
</body>
</html>