$(function(){
	
	$("span").click(function(){		
		if($(this).attr("id").indexOf("btn")==-1){
			return;
		}
		var id = ($(this).attr("id")).substring(3);
		var concernerId = "#concerner"+id;
		var concerner = $(concernerId).val();
		requset("UserServlet?method=deleteUserFans","concerner="+concerner+"&phoneNum="+$("#phoneNum").val(),function(msg){
			alert(msg.tips);
		});
	});
	
	$("img").click(function(){
		var id = ($(this).attr("id")).substring(6);
		var concernerId = "#concerner"+id;
		var concerner = $(concernerId).val();
		openOthersIndex(concerner);
	});
});