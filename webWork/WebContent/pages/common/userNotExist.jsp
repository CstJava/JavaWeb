<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 

if(session.getAttribute("id")==null){
%>
	<script>
		$(function(){
			location.href="pages/sys/login/jsp/login.jsp";
		});
	</script>
<% 
}
%> 