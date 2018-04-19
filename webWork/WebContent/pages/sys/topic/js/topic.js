$(function(){		    
	
	$("#createTopicComment").focus(function(){
		$("#createTopicComment").css("color","black");		
	});
});

function createTopicComment(){
	var val = $("#createTopicComment").val();  
	$("#createTopicComment").val(val.replace(new RegExp("\n", "gm"), "<br>"));  
	if($("#createTopicComment").val()==""||$("#createTopicComment").val().length>1000||$("#createTopicComment").val()=="内容不能为空或多于1000字"){
		$("#createTopicComment").css("color","red");
		$("#createTopicComment").val("内容不能为空或多于1000字");
		return;
	}	
	requset("TopicServlet?method=createTopicComment","createTopicComment="+$("#createTopicComment").val()+"&topicNum="+$("#topicNum").val(),function(msg){
			alert(msg.tips);
	});
	setTimeout(function(){
		location.reload(true);
	}, 300);
}