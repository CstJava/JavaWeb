$(function(){		    
	
	$("#createTopicName").focus(function(){
		$("#createTopicName").css("color","black");		
	});
	$("#createTopicContent").focus(function(){
		$("#createTopicContent").css("color","black");		
	});
});
function createTopic(){
	var val = $("#createTopicContent").val();  
	$("#createTopicContent").val(val.replace(new RegExp("\n", "gm"), "<br>"));  
	if($("#createTopicName").val()==""||$("#createTopicName").val()=="标题不能为空"){
		$("#createTopicName").css("color","red");
		$("#createTopicName").text("标题不能为空");
		return;
	}
	if($("#createTopicContent").val()==""||$("#createTopicContent").val().length>500||$("#createTopicContent").val()=="内容不能为空或多于500字"){
		$("#createTopicContent").css("color","red");
		$("#createTopicContent").val("内容不能为空或多于500字");
		return;
	}	
	var datas = $("#createTopicForm").serialize();
	requset("TopicServlet?method=createTopic",datas,function(msg){
			alert(msg.tips);
	});
	setTimeout(function(){
		location.reload(true);
	}, 300);
}