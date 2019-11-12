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
		var answer_count;
		if(question_answer.questionData.length!=0){
			for(var i=0;i<question_answer.questionData.length;i++){
				if(question_answer.questionData[i].answer_count==0){
					answer_count = "No Answers yet..";
				}
				else if(question_answer.questionData[i].answer_count==1){
					answer_count = "1 Answer";
				}
				else if(question_answer.questionData[i].answer_count>1){
					answer_count = question_answer.questionData[i].answer_count+" Answers";
				}
				if(question_answer.questionData[i].email==sessionStorage.session_email){
					question_answer.questionData[i].name = "You";
				$('#question_answer_container').append('<div class="container">'+
					'<div class="jumbotron home_middle_content">'+
					'<h4 id="questionContent">'+
					question_answer.questionData[i].name+
					" Asked <i class='fa fa-trash questiondeleteIcon' " +
					"data-id="+question_answer.questionData[i].questionId+" "+
					"aria-hidden='true'></i></h4><div><h4>"+
					"<i class='fa fa-pencil-square-o questionEditIcon question'" +
					" aria-hidden='true'"+
					"data-id='"+question_answer.questionData[i].questionId+"'>"+
					"<b> <a class='answer' data-id='"+question_answer.questionData[i].questionId+"'>"+
					question_answer.questionData[i].question+'</a></b></h4></i>'+					
					'</div>'+
					'</div>'
				);
			}else{
				$('#question_answer_container').append('<div class="container">'+
						'<div class="jumbotron home_middle_content">'+
						'<h4 id="questionContent">'+
						question_answer.questionData[i].name+
						' Asked <button class="btn btn-primary a-btn-slide-text answer_button"'+
						'data-toggle="modal" data-target="#modalHorizontal"'+' '+
						'data-id="'+question_answer.questionData[i].questionId+'">'+
				        '<span class="glyphicon glyphicon-edit" aria-hidden="true"></span>'+
				        '<span><strong>Answer</strong></span> </button></h4><br>'+answer_count+''+
						"<div class='question'><h4><b><a class='answer' data-id='"+question_answer.questionData[i].questionId+"'>"+
						question_answer.questionData[i].question+'</a></b></h4>'+
						'</div>'+					   				
						'</div>'+
						'</div>'
				);
			}
			}	
		}else{			 
			$('#question_answer_container').append('<div class="container">'+
				'<div class="jumbotron home_middle_content">'+
				'<h4 id="questionContent">No Questions still asked..</h4>'+
				'<p>Your questions and answers will be displayed here</p>'+
				'</div>'+
				'</div>'
			);
		}		
	}
	function closeModal(){
		var close_modal=$(function(){
			//For closing the pop-up modal
		   $('#modalHorizontal').modal('toggle');
		});
	}