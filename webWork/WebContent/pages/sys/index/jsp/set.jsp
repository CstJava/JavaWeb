<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta 	 http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>设置</title>
<jsp:include page="/pages/common/base.jsp" />
</head>
<body>
	<jsp:include page="/pages/sys/index/head.jsp"></jsp:include>
	<div class="set_body">
		<div class="set_left">
			<lu>
				<li>设置主题</li>
				<li></li>
				<li></li>
			</lu>
		</div>
		<div class="set_right">
			<jsp:include page="/pages/sys/index/jsp/set/theme.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>