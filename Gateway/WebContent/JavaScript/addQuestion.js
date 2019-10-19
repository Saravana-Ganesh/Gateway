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
	submitQuestion();
});

$('#addQuestion').click(function(){
	$("#questiontextarea").val("");
	$("#submitQuestion").attr("disabled", true);
})

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