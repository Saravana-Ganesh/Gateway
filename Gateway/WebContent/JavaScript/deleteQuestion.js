/**
 * Author: Saravana Ganesh
 * Date:23-10-2019
 * Purpose:For deleting the question which asked already.
 */
window.operation; 
window.questiontextarea
window.questionId;;
//JQuery click event for dynamically loaded contents
$('#question_answer_container').on('click','.questiondeleteIcon',function(){ 
	var questionId = $(this).attr("data-id");
	var operation  = "delete";
	deleteOrEditQuestion(questionId,operation);	
	$("#question_answer_container").empty();
	getQuestion();
});
function deleteOrEditQuestion(questionId,operation){
	if(operation=="delete"){
		$.ajax({
		      url:'../editOrDelete',
		      data:{
		    	  "questionId":questionId,
		    	  "operation":operation,
		    	  "question":"null"
			  },
		      type:'post',
		      async:false,
		      success: function (data) {
		    	  //drawQuestion();
		      },
		      error: function (textStatus, errorThrown) {
		    	  //drawQuestion();
		      }

		   });
	}else if(operation=="edit"){	
		var close_modal=$(function(){
			//For closing the pop-up modal
		   $('#modalHorizontal').modal('toggle');
		});
		var question = $('#questiontextarea').val();
		if(question!="" && question!=null && typeof question != "undefined"){
			 $.ajax({
			      url:'../editOrDelete',
			      data:{			  
			    	  "question":question,
			    	  "questionId":questionId,
			    	  "operation":operation
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
	
}

$('#question_answer_container').on('click', '.questionEditIcon', function(e) {	
		questionTips();
		$('#myModalLabel').text('Edit Question');
		$('#modalHorizontal').modal('show');
		$('#submitQuestion').text('Update');
		$("#questiontextarea").val($(this).text());	
		$("#questiontextarea").attr("placeholder", "Edit your question..");
		operation  = "edit";
		questionId = $(this).attr("data-id");			
});