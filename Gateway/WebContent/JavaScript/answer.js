/**
 * Author: Saravana Ganesh
 * Created date:07-11-2019
 * Purpose:To show answers in the dashboard
 */
/*$('#question_answer_container').on('click','.answer b a',function(){
	console.log("wdnwjd");
});*/
$('#question_answer_container').on('click','.answer',function(e){
	e.stopPropagation();
	var questionId = $(this).attr("data-id");
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
	
}