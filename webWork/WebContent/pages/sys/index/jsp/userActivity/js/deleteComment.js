$(function(){
	
	$("button").click(function(){		
		var id = ($(this).attr("id")).substring(3);
		var commentNumId = "#commentNum"+id;
		var commentNum = $(commentNumId).val();
		requset("TopicServlet?method=deleteComment","commentNum="+commentNum,function(msg){
			alert(msg.tips);
		});
		setTimeout(function(){
			location.reload(true);      			
		}, 200);
		
	});
	
});