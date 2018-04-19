<%@page import="com.service.user.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta 	 http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>修改资料</title>
<jsp:include page="/pages/common/base.jsp" />
<%
	String touxiangSrc = ((User)session.getAttribute("id")).getHeadSculptureAdd();
	String phoneNum =((User) session.getAttribute("id")).getPhoneNum();
	String name = ((User) session.getAttribute("id")).getName();
	String sex = ((User) session.getAttribute("id")).getSex();
	String email = ((User) session.getAttribute("id")).getEmail().substring(0,((User) session.getAttribute("id")).getEmail().indexOf("@"));
	String address = ((User) session.getAttribute("id")).getAddress();
	String introduction = ((User) session.getAttribute("id")).getIntroduction();
	int age=  ((User) session.getAttribute("id")).getAge();

%>

<script type="text/javascript" src="pages/sys/index/js/userModify.js"></script>
</head>
<body>
	<jsp:include page="/pages/sys/index/head.jsp"></jsp:include>
	<div class="dt_body">
		<div class="body_inner">
			<form enctype="multipart/form-data" id="userModify" method="post" >
					<div class="inner_left">
						<img src="<%=touxiangSrc%>" />
						<input type="file" id="touxiang"name="touxiang" class="upload_userIcon" value="点此上传头像"/>
						<div class="upload_cover">
							点此上传头像
						</div>				
					</div>
					<div class="inner_right">
						<a class="return" href="pages/sys/index/jsp/userIndex.jsp">返回我的主页     ></a>
						<div>账号：<%=phoneNum %></div>
						<input type="hidden" id="phoneNum" name="phoneNum" value="<%=phoneNum%>">
						<div class="name_wrap">
							<div class="name_left">
								用户名
							</div>
							<div class="name_right">
								<input type="text" name="name" id="name" placeholder="不能超过10字" value="<%=name%>" />
							</div>
						</div>
						<hr/>
						<div class="name_wrap">
							<div class="name_left">
								年龄
							</div>
							<div class="name_right">
								<input type="text" id="age" name="age" placeholder="0-999" value="<%=age%>" />
							</div>
						</div>
						<hr/>
						<div class="sex_wrap">
							<div class="sex">
								<span>性别</span>
							</div>
							<div class="sex_select">
								男<input type="radio" name="sex" id="sex" value="男" checked="checked"/>
								&nbsp;&nbsp;&nbsp;&nbsp;
								女<input type="radio" name="sex" id="sex" value="女" />
							</div>
						</div>
						<hr/>
						<div class="label_wrap">
							<div class="label_left">
								邮箱
							</div>
							<div class="label_right">
								<input type="text" name="email" id="email" placeholder="不能超过20字" value="<%=email%>" />
							</div>
							<select id="email_hz" name="email_hz">
								<option>@qq.com</option>
								<option>@163.com</option>
							</select>
						</div>
						<hr/>
						<div class="place_wrap">
							<div class="place_left">
							居住地
							</div>
						<div class="place_right">
							<input type="text" name="address" id="address" placeholder="不能超过50字" value="<%=address%>"  />
						</div>
					</div>
					<hr />
					<div class="place_wrap">
						<div class="place_left">
							个人简介
						</div>
						<div class="place_right">
							<input type="text" name="introduction" id="introduction" placeholder="不能超过100字" value="<%=introduction%>"  />
						</div>
					</div>
					<hr/>
					<div class="button_wrap">
						<button type="reset" class="reset_profile">重置资料</button>
						<button onclick="test()" class="reserve_profile">确定修改</button>
					</div>
		
				</div>
			</form>
		</div>
	</div>
</body>
</html>