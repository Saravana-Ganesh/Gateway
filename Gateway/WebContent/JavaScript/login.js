/**
 * Author Saravana Ganesh V
 * Created on 13-10-2019
 */
$(document).ready(function() {
  $('#login_page').submit(function(e) {
	debugger;
	e.preventDefault();
    var email = $('#email').val();
    var password = $('#password').val();
	var method_name = "login";
	if(!validateEmail(email)){
		$("#validation").text("Invalid email format");
		return false;
	}
	function validateEmail(email) {
		var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
		return emailReg.test(email);
	}
	
	/*var myRequest = new XMLHttpRequest();
	myRequest.open('post','login');
	myRequest.onload = function(){
		alert(myRequest.responseText);
		var data = JSON.parse(myRequest.responseText);
		alert(data);
	}
	myRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	myRequest.send("email="+email+"&password="+password);*/
   /* $.post('login',{
    	"email" : email,
    	"password":password
    }, function(responseText) {
            $('#validation').text(responseText);
    });*/
	
  $.ajax({
      url:'login',
      data:{
    	  "email":email,
    	  "password":password
	  },
      type:'post',
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
     if(data=="1"){
    	 window.location = 'JSP/Welcome.jsp';
     }else{
    	 $("#validation").text("Invalid email or password");
     }  
  }
  });

});