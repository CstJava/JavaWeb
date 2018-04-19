function test(){
	
	var name =$("#name").val();
	if(name.trim()==""){
		alert("名称不能为空");
		return;
	}
	if(name.length>10){
		alert("名字不能超过10字");
		return;
	}
	
	var age =$("#age").val();
	if(age>1000){
		alert("请输入合法年龄");
		return;
	}
	var email =$("#email").val();
	if(email.trim()==""){
		alert("邮箱不能为空");
		return;
	}
	var address =$("#address").val();
	if(address.length>100){
		alert("地区不能超过100字");
		return;
	}
	var introduction =$("#introduction").val();
	if(introduction.length>100){
		alert("个人介绍不能超过100字");
		return;
	}
	var datas = $("#userModify").serialize();

	     
	requset("UserServlet?method=updataUser",datas,function(msg){
		if(msg.tips=="修改成功"){
			alert("修改成功");
		}else{
			alert("修改失败");
		}
		
	});
     var formData = new FormData($( "#userModify" )[0]);    
     $.ajax({    
          url: 'UserServlet?method=updataTouxiang' ,  /*这是处理文件上传的servlet*/  
          type: 'POST',    
          data: formData,    
          async: false,    
          cache: false,    
          contentType: false,    
          processData: false
     });    
		   
	
}
$(function(){
	$("#touxiang").click(function(){
		$(".upload_cover").css("background-color","rgb(15,136,235)");
		$(".upload_cover").css("color","white");
	});
});