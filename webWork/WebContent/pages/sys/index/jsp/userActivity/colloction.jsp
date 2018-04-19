<%@page import="com.service.user.User"%>
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

<title>收藏</title>
</head>
<body>
	<%
		
		String phoneNum=((User)session.getAttribute("id")).getPhoneNum();		
		ArrayList<Topic> list=(ArrayList<Topic>)session.getAttribute("userCollectionTopic");
		String btn ="#btn";
		for(int i=0;i<list.size();i++){
			out.print("<div class="+'"'+"topic_link"+'"'+">");
			out.print("<div class="+'"'+"topic_link_head"+'"'+">");
			out.print("<span>"+list.get(i).getTopicName()+"</span>");
			out.print("<button id="+'"'+"btn"+i+'"'+"onclick="+'"'+"updateCollect("+list.get(i).getTopicNum()+",'"+(btn+i)+"')"+'"'+" class="+'"'+"delete_btn"+'"'+">取消收藏</button>");
			out.print("</div>");
			out.print("<div class="+'"'+"topic_link_body"+'"'+">");
			out.print("<span onclick="+'"'+"topic("+((Topic)list.get(i)).getTopicNum()+")"+'"'+" >"+list.get(i).getTopicContent()+"</span>");
			out.print("</div>");
			out.print("<div class="+'"'+"topic_link_foot"+'"'+">");
			out.print("<span>"+list.get(i).getName()+"</span>");
			out.print("<span style="+'"'+"float:right"+'"'+">"+list.get(i).getTopicCreateTime()+"</span>");
			out.print("</div>");
			out.print("</div>");
		}
		
	%>
	
	<input type="hidden" id="phoneNum" name="phoneNum" value="<%=phoneNum%>">
</body>
</html>