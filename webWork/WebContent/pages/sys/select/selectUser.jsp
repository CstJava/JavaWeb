<%@page import="java.util.HashMap"%>
<%@page import="com.service.topic.Topic"%>
<%@page import="com.service.user.User"%>
<%@ page import="java.util.ArrayList" %> 
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	ArrayList<User> selectUserList = (ArrayList<User>)session.getAttribute("selectUserList");	
	int lie=Integer.parseInt(request.getParameter("selectUserpage")); 
	for(int i=lie*10;i<selectUserList.size();i++){
		if(i>=(lie+1)*10){
			break;
		}
		out.print("<div class="+'"'+"select_user"+'"'+">");
		out.print("<img onclick="+'"'+"openOthersIndex("+selectUserList.get(i).getPhoneNum()+")"+'"'+" src="+'"'+selectUserList.get(i).getHeadSculptureAdd()+'"'+">");
		out.print("<div class="+'"'+"select_user_name"+'"'+">"+selectUserList.get(i).getName()+"</div>");
		out.print("<span>介绍："+selectUserList.get(i).getIntroduction()+"</span>");
		out.print("<span>性别："+selectUserList.get(i).getSex()+"</span>");
		out.print("<span>年龄："+selectUserList.get(i).getAge()+"</span>");
		out.print("<span>地址："+selectUserList.get(i).getAddress()+"</span>");
		out.print("</div>");
	} 				
%>
