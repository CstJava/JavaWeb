function show(){
	if($(".head_show").css("visibility")=="hidden"){
		$(".head_show").css("visibility","visible");			
	}else{
		$(".head_show").css("visibility","hidden");	
	}
	
}
function selectTopic(){
	var topicName =$("#select").val();
	select(topicName);
}