/**
 * Author: Saravana Ganesh
 * Created on 30-10-2019
*/
window.answer;
var editAnswer="";
$('#question_answer_container').on('click','.answer_button',function(){
	questionId = $(this).attr("data-id");
	checkAnswerExists(questionId);
	if(editAnswer.length>0){
		$(".question_tips").empty();
		$('#myModalLabel').text('Edit Answer');
		$('#submitQuestion').text('Update Answer');
		$("#questiontextarea").val(editAnswer);	
		$("#questiontextarea").attr("placeholder", "Type your answer here");
	}else{
		$(".question_tips").empty();
		$('#myModalLabel').text('Add Answer');
		$('#submitQuestion').text('Add Answer');
		$("#questiontextarea").val("");
		$("#questiontextarea").attr("placeholder", "Type your answer here");
	}	
});

function checkAnswerExists(questionId){
	$.ajax({
	      url:'../addAnswer',
	      data:{
	    	  "questionId":questionId,
	    	  "session_email":sessionStorage.session_email,
	    	  "purpose":"checkAnswerExists"
		  },
	      type:'post',
	      async:false,
	      success: function (data) {
	    	  checkAnswerExistsResponse(data);
	      },
	      error: function (textStatus, errorThrown) {
	    	  checkAnswerExistsResponse(data);
	      }

	   });
}
function checkAnswerExistsResponse(data){
	data = JSON.parse(data);
	if(data.status==1){
		editAnswer = data.answer;
	}else{
		editAnswer="";
	}
}
function addOrUpdateAnswer(answer,purpose){
	closeModal();
	$.ajax({
	      url:'../addAnswer',
	      data:{
	    	  "questionId":questionId,
	    	  "answer":answer,
	    	  "session_email":sessionStorage.session_email,
	    	  "purpose":purpose
		  },
	      type:'post',
	      async:false,
	      success: function (data) {
	    	  submitAnswerResponse(data);
	      },
	      error: function (textStatus, errorThrown) {
	    	  submitAnswerResponse(data);
	      }

	   });
}
function addAnswer(answer){
	addOrUpdateAnswer(answer,"Add")
}
function updateAnswer(answer){
	addOrUpdateAnswer(answer,"Update")
}
function submitAnswerResponse(data){
	
}