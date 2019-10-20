/**
 * Author Saravana Ganesh
 * Created on 14-10-2019
 */
window.onload=function(){
	var session_email = sessionStorage.getItem("session_email");
	checkSession(); 	
	function checkSession(){
		//validates the session.If session not exist redirect to login page
		if(session_email==null || session_email==undefined){
			 window.location = '../login.html';
		}
		else{
			loadUserData(session_email);
			getQuestion();
		}
	}
}
	function loadUserData(session_email){
		  $.ajax({
		      url:'../home',
		      data:{
		    	  "session_email":session_email
			  },
		      type:'post',
		      async:false,
		      success: function (data) {
		          userData(data)
		      },
		      error: function (textStatus, errorThrown) {
		    	  userData("Error getting the data")
		      }

		   });		
	}
	function userData(data){
		$("#user-name").html(data);;
	}
	
	function getQuestion(){
		  $.ajax({
		      url:'../viewQuestion',
		      data:{
			  },
		      type:'post',
		      async:false,
		      success: function (data) {
		          drawQuestion(data)
		      },
		      error: function (textStatus, errorThrown) {
		    	  drawQuestion("Error getting the data")
		      }
		   });		
	}
	function drawQuestion(data){
		var question_answer = JSON.parse(data);
		if(question_answer.questionData.length!=0){
			for(var i=0;i<question_answer.questionData.length;i++){
				$('#question_answer_container').append('<div class="container">'+
					'<div class="jumbotron home_middle_content">'+
					'<h3 id="questionContent">'+
					question_answer.questionData[i].name+' Asked <br><b>'+question_answer.questionData[i].question+'</b>'
					+'</h3>'+
					'<p>Your questions and answers will be displayed here</p>'+
					'</div>'+
					'</div>'
				);
			}	
		}else{			 
			$('#question_answer_container').append('<div class="container">'+
				'<div class="jumbotron home_middle_content">'+
				'<h3 id="questionContent">No Questions still asked..</h3>'+
				'<p>Your questions and answers will be displayed here</p>'+
				'</div>'+
				'</div>'
			);
		}		
	}