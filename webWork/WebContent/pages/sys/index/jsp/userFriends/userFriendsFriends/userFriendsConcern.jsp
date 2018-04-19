<%@page import="java.util.ArrayList"%>
<%@page import="com.service.user.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page errorPage="/WEB-INF/error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/pages/common/base.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="pages/sys/index/jsp/userFriends/js/guanzhu.js"></script>
<title>关注</title>
</head>
<body>
<%
	String phoneNum = request.getParameter("phoneNum");
	ArrayList<User> list=(ArrayList<User>)session.getAttribute(phoneNum+"ConcernUserList");

	for(int i=0;i<list.size();i++){
		out.print("<input id="+'"'+"beConcerner"+i+'"'+"type="+'"'+"hidden"+'"'+" value="+list.get(i).getPhoneNum()+">	");
		out.print("<div class="+'"'+"person_card"+'"'+">");
		out.print("<img id="+'"'+"person"+i+'"'+" src="+'"'+list.get(i).getHeadSculptureAdd()+'"'+">");
		out.print("<div class="+'"'+"person_card_info"+'"'+">");
		out.print("<span  class="+'"'+"person_card_info_name"+'"'+">"+list.get(i).getName()+"</span>");
		out.print("<span  class="+'"'+"person_card_info_jiesao"+'"'+">"+list.get(i).getIntroduction()+"</span>");
		out.print("</div>");
		out.print("</div>");
	}
%>
<input id="phoneNum" type="hidden" value=<%=phoneNum%>>
</body>
</html>