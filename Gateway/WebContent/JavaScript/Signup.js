$(document).ready(function()
	{ 
	$('#submit').click(function(e){
		e.preventDefault();
		var error = false;
		var username = $('#username').val();
		var email = $('#email').val();
		var p1=$('#psw1').val();
		var p2=$('#psw2').val();
		var phoneNumber = $("#phoneNumber").val();
		// Initializing Variables With Regular Expressions
		var name_regex = /^[a-zA-Z]+$/;
		var formatNumber = /\d/;//string contains number
		var formatSymbol = /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/;//string contains symbol
		var email_regex = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;
		var add_regex = /^[0-9a-zA-Z]+$/;
		var zip_regex = /^[0-9]+$/;
		var phoneCheck=new RegExp('[0-9]{10}');
		
		//Validating Name Field
		if((formatNumber.test(username)) || (formatSymbol.test(username)) ){
			$('#error_username').text("Name should not contains numbers or symbols");
			error = true;
		}else{
			$('#error_username').text("");
		}
		
		//Validating Email Field.
		if (!email.match(email_regex) || email.length == 0) 
		{
			$('#error_email').text("Invalid email id"); // This Segment Displays The Validation Rule For Email
			$("#email").focus();
			error = true;
		}else{
			$('#error_email').text("");
		}
		
		//Validating password.
		if(p1.length==0 || p2.length==0){
			$('#confirm_password').text("Password is empty");//This displays password are not matched.
			$("#psw1").focus();
			$("#psw2").focus();
			error = true;
		}
		if(!p1.match(p2))
		{
			$('#confirm_password').text("Passwords didn't match");//This displays password are not matched.
			$("#psw1").focus();
			error = true;
		}else{
			$('#confirm_password').text("");
		}
			
		//Validate Mobile number
		 if($('#phoneNumber').val().length!=10){
			$('#errorPhoneNumber').text("Incorrect mobile number");
			$("#phoneNumber").focus();
			error = true;
		}else{
			$('#errorPhoneNumber').text("");
		}
		if(error){
			return false;
		}
		  $.ajax({
		      url:'../signup',
		      data :{
					email:email,
					password:p1,
					userName:username,
					phoneNumber:phoneNumber,
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
		    	 window.location = '../JSP/Welcome.jsp';
		     }else{
		    	 $("#errorPhoneNumber").text("User Already Exists");
		     }  
		  }
	
	});	
});
