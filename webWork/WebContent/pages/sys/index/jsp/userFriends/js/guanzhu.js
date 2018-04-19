$(function(){
	
	$("span").click(function(){		
		if($(this).attr("id").indexOf("btn")==-1){
			return;
		}
		var id = ($(this).attr("id")).substring(3);
		var beConcernerId = "#beConcerner"+id;
		var beConcerner = $(beConcernerId).val();
		requset("UserServlet?method=deleteUserConcernUser","beConcerner="+beConcerner+"&phoneNum="+$("#phoneNum").val(),function(msg){
			alert(msg.tips);
		});
	});
	
	$("img").click(function(){		
		var id = ($(this).attr("id")).substring(6);
		var beConcernerId = "#beConcerner"+id;
		var beConcerner = $(beConcernerId).val();
		openOthersIndex(beConcerner);
	});
	
});