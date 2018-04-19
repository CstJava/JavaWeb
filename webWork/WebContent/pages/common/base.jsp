<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String port = (request.getServerPort() == 80 || request.getServerPort() == 443) ? "" : ":" + String.valueOf(request.getServerPort());
    String basePath = request.getScheme() + "://" + request.getServerName() + port + path + "/";
    request.setAttribute("_basePath", basePath);
%>
<base href="${_basePath}"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>

<!-- JavaScript插件引入 -->
<script type="text/javascript" src="pages/js/jquery.js"></script>
<script type="text/javascript" src="pages/js/index.js"></script>
<!-- CSS样式引入 -->
<link rel="stylesheet" type="text/css" href="pages/css/css.css">
