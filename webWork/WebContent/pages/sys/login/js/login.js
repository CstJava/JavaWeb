$(function(){
	document.onkeydown = function(e){ 
		var ev = document.all ? window.event : e;
		if(ev.keyCode==13) {
			login();
		}
	};	
});

/**
 * 登录
 */
function login(){
	
	var phone = $("#phoneNum").val();
	var password =$("#password").val();
	
	if(phone.trim()==""){
		$("#error_tips").html("账号不能为空!");
		return;
	}
	if(password.trim()==""){
		$("#error_tips").html("密码不能为空!");
		return;
	}
	
	var datas = $("#login_form").serialize();
	   
    //注册接口请求
    requset("UserServlet?method=userExistPassword",datas,function(msg){
       if(msg.tips != "输入正确"){
    	   $("#error_tips").html(msg.tips);	
       }else{
    	   indexTopic();    	   
       }
    });  
}