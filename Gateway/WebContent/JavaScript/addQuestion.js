/**
 * Author: Saravana Ganesh
 * Created on 17-10-2019
 */
$('#submitQuestion').click(function(){	
	submitQuestion();
	
});

function submitQuestion(){
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
	}else{
		alert("Invalid question");
	}
}
function responseData(data){
	alert("response data");
}