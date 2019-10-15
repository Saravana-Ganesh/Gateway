/**
 * Author Saravana Ganesh
 * Created on 14-10-2019
 */
window.onload=function(){
	window.sessionStorage;
	$.ajax({
		      url:'../login',
		      data:{
		    	  "session":"email"
			  },
		      type:'GET',
		      async:false,
		      success: function (data) {
		          callbackfn(data)
		      },
		      error: function (textStatus, errorThrown) {
		          callbackfn("Error getting the data")
		      }
   		 });
	function callbackfn(data)
	  {
	     if(data=="0"){
	    	 window.location = '../login.html';
	     }else{ 
	    	 session_email=data;	    	 
	    	 sessionStorage.setItem("session_email",session_email);
	     }
	  }
}