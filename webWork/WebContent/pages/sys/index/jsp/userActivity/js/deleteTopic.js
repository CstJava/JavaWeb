
$(function(){
	
	$("button").click(function(){		
		var id = ($(this).attr("id")).substring(3);
		var topicNumId = "#topicNum"+id;
		var topicNum = $(topicNumId).val();
		requset("TopicServlet?method=topicDelete","topicNum="+topicNum,function(msg){
			alert(msg.tips);
		});
		setTimeout(function(){
			location.reload(true); 			
		}, 200);
	});
	
});
