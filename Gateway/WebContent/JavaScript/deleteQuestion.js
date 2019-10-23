/**
 * Author: Saravana Ganesh
 * Date:23-10-2019
 * Purpose:For deleting the question which asked already.
 */

//JQuery click event for dynamically loaded contents
$('#question_answer_container' ).on( 'click', '.questiondeleteIcon', function () { 
	alert($(this).attr("data-id"));	
});