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
			loadUserData();
			getQuestion();
		}
	}	
	function loadUserData(){
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
		alert(data);
	}
}