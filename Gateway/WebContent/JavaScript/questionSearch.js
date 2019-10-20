/**
 * Author:Saravana Ganesh V 
 * Created date: 20-10-2019
 * Purpose: To implement the search functionality for questions 
 */

$("#search").keyup(function(){
	var search_array = $("#search").val().trim().split(" ");	
	search_array = search_array.map(toUpper);
	if((search_array.length==1)&&(search_array[0].length==0)){
		$("#question_answer_container").empty();
		getQuestion();
	}else if($("#search").val().length>2){
		callSearch(search_array);
	}	
});
//Service call for searching question
function callSearch(search_array){
	$.ajax({
	    url:'../search',
	    dataType:'json',
	    data:{
	  	  "search_array":search_array
		  },
	    type:'post',
	    async:false,
	    success: function (data) {
	        drawSearchResponse(data)
	    },
	    error: function (textStatus, errorThrown) {
	    	drawSearchResponse("Error getting the data")
	    }

	 });	
}

function drawSearchResponse(data){	
	if(data.length!=0){
		$("#question_answer_container").empty();
		var search_answer = data;
		if(search_answer.searchData.length!=0){
			for(var i=0;i<search_answer.searchData.length;i++){
				$('#question_answer_container').append('<div class="container">'+
					'<div class="jumbotron home_middle_content">'+
					'<h3 id="questionContent">'+
					search_answer.searchData[i].name+' Asked <br><b>'+search_answer.searchData[i].question+'</b>'
					+'</h3>'+
					'<p>Your questions and answers will be displayed here</p>'+
					'</div>'+
					'</div>'
				);
			}	
		}else{			 
			$('#question_answer_container').append('<div class="container">'+
				'<div class="jumbotron home_middle_content">'+
				'<h3 id="questionContent">No results found</h3>'+
				'<p>Your questions and answers will be displayed here</p>'+
				'</div>'+
				'</div>'
			);
		}		

	}
}