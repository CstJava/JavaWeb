function testEmail(){
	
	var datas = $("#pword_number").serialize();	
	if($("#phoneNum")==""||$("#email")==""){
		$("#error_tips").html("账号邮箱不能为空");
		return;
	}
	requset("UserServlet?method=pword_number",datas,function(msg){
	       if(msg.tips == "账号不存在或邮箱错误"){	  
	    	   $("#error_tips").html(msg.tips);	 
	    	   return;
	       }else{
	    	   requset("UserServlet?method=sentemail",datas,function(msg){
	    		   $("#error_tips").html(msg.tips);
	    	   });
		   };
	       
	    });
	
	
}

function next(){
	var datas = $("#pword_number").serialize();
	if($("#phoneNum")==""||$("#email")==""){
		$("#error_tips").html("账号邮箱不能为空");
		return;
	}
	requset("UserServlet?method=pword_number",datas,function(msg){
	       if(msg.tips == "账号不存在或邮箱错误"){	  
	    	   $("#error_tips").html(msg.tips);	 
	    	   return;
	       }
	    });
	if($("#emailcode")==""){
		$("#error_tips").html("验证码不能为空");
		return;
	}	
	requset("UserServlet?method=pword_number_emailCode",datas,function(msg){
		  if(msg.tips=="验证码错误"){
			  $("#error_tips").html(msg.tips);
			  return;
		  }
		  location.href="pages/sys/forget/jsp/pword_complete.jsp?phoneNum="+$("#phoneNum").val();	    
	});
}
function changePassword(){
	var password = $("#password").val();
	var passwordRepeat =$("#passwordRepeat").val();
	if(password==""||password.length()<6){
		$("#error_tips").html("密码长度不能小于6");
		return;
	}
	if(password!=passwordRepeat){
		$("#error_tips").html("两次密码不一致，请重新输入");
		return;
	}
	
	var datas = $("#pword_complete").serialize();
	requset("UserServlet?method=changePassword",datas,function(msg){
		  if(msg.tips=="修改失败"){
			  $("#error_tips").html(msg.tips);
			  return;
		  }else{
			  alert("修改密码成功!");
			  location.href="pages/sys/login/jsp/login.jsp";	    
		  }
	});
}
