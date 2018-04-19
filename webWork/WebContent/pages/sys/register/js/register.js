function test(){
	var phone = $("#phoneNum").val();
	var name = $("#name").val();
	var datas = $("#register").serialize();
	
	if(phone.trim()==""){
		$("#error_tips").html("账号不能为空");
		return;
	}
	
	requset("UserServlet?method=userExist",datas,function(msg){
	       console.log(msg);    
	       if(msg.tips == "账号存在"){
	    	   $("#error_tips").html(msg.tips);	 
	    	   return;
	       }
	    });
	if(name.trim()==""){
		$("#error_tips").html("名称不能为空");
		return;
	}
	if($("#password").val().length<6){
		$("#error_tips").html("密码不能小于6位");
		return;
	}
	
	if($("#password").val()!=$("#passwordRepeat").val()){
		$("#error_tips").html("两次密码不同，请重新输入");
		return;
	}
	
}
/**
 * 发送验证码到邮箱
 */
function sentEmail(){
	test();
	var datas = $("#register").serialize();
	requset("UserServlet?method=sentemail",datas,function(msg){ 	      
	    	   $("#error_tips").html(msg.tips);	 		   
	    });
}
/**
 * 注册
 */
function register(){
	test();
	var datas = $("#register").serialize();
	requset("UserServlet?method=register",datas,function(msg){
	    if(msg.tips=="验证码正确"){
	    	alert("注册成功");	
	    	location.href="/webWork/pages/sys/login/jsp/login.jsp";
	    }else{
	    	$("#error_tips").html(msg.tips);	
	    }
	});
}

