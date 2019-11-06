/**
 * Author: Saravana Ganesh
 * Created on 17-10-2019
*/
$("#questiontextarea").keyup(function() {
    if (!this.value) {
    	$("#submitQuestion").attr("disabled", true);
    }else{
    	$("#submitQuestion").attr("disabled", false);
    }
});


$('#submitQuestion').click(function(){
	if($("#submitQuestion").text()=='Add Question'){
		submitQuestion();
	}else if($('#submitQuestion').text()=='Update'){
		deleteOrEditQuestion(questionId,operation);
	}else if($("#submitQuestion").text()=='Add Answer'){
		answer = $("#questiontextarea").val();
		addAnswer(answer);
	}else if($("#submitQuestion").text()=='Update Answer'){
		answer = $("#questiontextarea").val();
		updateAnswer(answer);
	}	
	$("#question_answer_container").empty();
	getQuestion();
});

$('#addQuestion').click(function(){	
	questionTips();
	$('#myModalLabel').text('Add Question');
	$('#submitQuestion').text('Add Question');
	$("#questiontextarea").val("");
	$("#questiontextarea").attr("placeholder", "Ask me anything........");
	//$("#submitQuestion").attr("disabled", true);
})
function questionTips(){
	$(".question_tips").empty();
	$('.question_tips').append('<h4 class="mb-3">Tips on '+
			'getting good answers quickly</h4>'+
			'<ul style="list-style-type:none;">'+
			'<li>'+
				'<div>'+
				'<i class="fa fa-hand-o-right fa-2x" aria-hidden="true"></i>'+
			'</div>'+
			'<div class="add-question-box-font-awesome">Make sure your question'+
				'hasn\'t been asked already</div>'+
				'</li>'+
			'<li>'+
			'<div>'+
				'<i class="fa fa-hand-o-right fa-2x" aria-hidden="true"></i>'+
			'</div>'+
			'<div class="add-question-box-font-awesome">Keep your question short and to the point</div>'+
			'</li>'+
			'<li>'+
			'<div>'+
			'<i class="fa fa-hand-o-right fa-2x" aria-hidden="true"></i>'+
			'</div>'+
			'<div class="add-question-box-font-awesome">Double-check grammar and spelling</div>'+
			'</li>'+
			'</ul>');
}
function submitQuestion(){
	var close_modal=$(function(){
			//For closing the pop-up modal
		   $('#modalHorizontal').modal('toggle');
	});
	var question = $('#questiontextarea').val();
	var email = sessionStorage.getItem("session_email");
	if(question!="" && question!=null && typeof question != "undefined"){
	  $.ajax({
	      url:'../addQuestion',
	      data:{
	    	  "session_email":email,
	    	  "question":question
		  },
	      type:'post',
	      async:false,
	      success: function (data) {
	          responseData(data)
	      },
	      error: function (textStatus, errorThrown) {
	    	  responseData("Error getting the data")
	      }

	   });
	}
}
function responseData(data){
	//alert(data);
}