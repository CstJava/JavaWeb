<%@page import="java.util.*"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="com.service.topic.Topic"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page errorPage="/WEB-INF/error.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<jsp:include page="/pages/common/base.jsp" />

<title>最近访问</title>
</head>
<body>
	<%
		
			Object[][]  obj=(Object[][])session.getAttribute("userRecentlyVisitTopic");
			
			for(int i=0;i<obj.length;i++){
			out.print("<input id="+'"'+"topicNum"+i+'"'+" name="+'"'+"i"+'"'+"type="+'"'+"hidden"+'"'+" value="+((Topic)obj[i][0]).getTopicNum()+">	");
			out.print("<div onclick="+'"'+"topic("+((Topic)obj[i][0]).getTopicNum()+")"+'"'+" class="+'"'+"topic_link"+'"'+">");
			out.print("<div class="+'"'+"topic_link_head"+'"'+">");
			out.print("<span>"+((Topic)obj[i][0]).getTopicName()+"</span>");
			out.print("</div>");
			out.print("<div class="+'"'+"topic_link_body"+'"'+">");
			out.print("<span>"+((Topic)obj[i][0]).getTopicContent()+"</span>");
			out.print("</div>");
			out.print("<div class="+'"'+"topic_link_foot"+'"'+">");
			out.print("<span>"+(String)obj[i][2]+"</span>");
			out.print("<span style="+'"'+"float:right"+'"'+">"+(String)obj[i][1]+"</span>");
			out.print("</div>");
			out.print("</div>");
		}
		
	%>
</body>
</html>