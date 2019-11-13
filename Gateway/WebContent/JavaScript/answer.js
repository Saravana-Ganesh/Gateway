/**
 * Author: Saravana Ganesh
 * Created date:07-11-2019
 * Purpose:To show answers in the dashboard
 */
/*$('#question_answer_container').on('click','.answer b a',function(){
	console.log("wdnwjd");
});*/
var question;
$('#question_answer_container').on('click','.answer',function(e){
	e.stopPropagation();
	var questionId = $(this).attr("data-id");
	question = $(this).text();
	viewAnswer(questionId);
});
function viewAnswer(questionId){
	$.ajax({
	      url:'../answer',
	      data:{
	    	  "questionId":questionId		    
		  },
	      type:'post',
	      async:false,
	      success: function (data) {
	    	  drawAnswer(data);
	      },
	      error: function (textStatus, errorThrown) {
	    	  drawAnswer(data);
	      }

	   });
}
function drawAnswer(data){
	data = JSON.parse(data);
	var name;
	if(data.AnswerData.length!=0){
		var answerCount = data.AnswerData.length;
		if(answerCount==1){
			answerCount = answerCount+" Answer";
		}else{
			answerCount = answerCount+" Answers";
		}
		$("#question_answer_container").empty();
		$('#question_answer_container').append('<div class="container">'+
				'<div class="jumbotron home_middle_content">'+
				'<h2 id="questionContent"><b>'+question+'</b></h2>'+
				'<h4 class="question">'+answerCount+'</h4>');
		for(var i=0;i<data.AnswerData.length;i++){
			if(data.AnswerData[i].email==sessionStorage.session_email){
				name = "You";
			}else{
				name = data.AnswerData[i].name;
			}
			$('#question_answer_container').append('<div class="container">'+
					'<div class="jumbotron home_middle_content">'+
					'<h4 id="questionContent">'+
					name+' Answered</h4>'+
					'<h3 class="question">'+data.AnswerData[i].answer+'</h3>');
		}
	}else{
		alert("No answer yet");
	}
	

}