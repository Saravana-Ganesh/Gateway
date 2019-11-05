<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Home</title>
		<script src="../JavaScript/home.js"></script>
		<link href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round|Raleway" rel="stylesheet">
		<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		
		<!-- <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css"> -->
		<link rel="stylesheet" href="../CSS/home.css">
	</head> 
<body>
	<nav class="navbar navbar-default navbar-expand-lg navbar-light">
		<div class="navbar-header d-flex col">
			<a class="navbar-brand" href="#">Ask<b>Me</b></a>  		
			<button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle navbar-toggler ml-auto" "buttonStyle">
				<span class="navbar-toggler-icon"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
		</div>
		<!-- Collection of nav links, forms, and other content for toggling -->
		<div id="navbarCollapse" class="collapse navbar-collapse justify-content-start">
			<ul class="nav navbar-nav">
				<li class="nav-item"><a href="#"  class="nav-link">Home</a></li>
				<li class="nav-item"><a href="#" class="nav-link">Answer</a></li>			
				<li class="nav-item"><a href="#" class="nav-link">Notifications</a></li>
				<!-- <li class="nav-item active"><a href="#" class="nav-link">Add Question</a></li> -->
				<!-- Button trigger modal -->
				<button id="addQuestion" class="btn btn-danger  btn-lg" data-toggle="modal" data-target="#modalHorizontal">
					Add Question
				</button>
<!-- Modal starts-->
				<div class="modal fade" id="modalHorizontal" tabindex="-1" role="dialog" 
					 aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<!-- Modal Header -->
							<div class="modal-header">
								<button type="button" class="close" 
								   data-dismiss="modal">
									   <span aria-hidden="true">&times;</span>
									   <span class="sr-only">Close</span>
								</button>
								<h4 class="modal-title" id="myModalLabel">
								   Add Question
								</h4>
							</div>
							
							<!-- Modal Body -->
							<div class="modal-body">                
								<form class="form-horizontal" role="form">
									<div class="question_tips">                                              																
									</div> 
										 <div class="form-group">
											<label for="questiontextarea" class="bmd-label-floating" ></label>
											<b><textarea id="questiontextarea" class="form-control "  rows="3"
											 placeholder="Ask me anything........"></textarea></b>
										</div>									
								</form>
							</div>
							
							<!-- Modal Footer -->
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
										data-dismiss="modal">
											Cancel
								</button>
								<button type="button" class="btn btn-primary" class = "updateQuestion" id="submitQuestion">
									Add Question
								</button>
							</div>
						</div>
					</div>
				</div>
<!-- Modal Ends-->
				<li class="nav-item"><a href="#" class="nav-link" id="user-name"></a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right ml-auto">
				<li class="navbar-form-wrapper">
					<form class="navbar-form form-inline navbar-right">
						<div class="input-group search-box">								
							<input type="text" id="search" class="form-control" placeholder="Search Here...">
							<span class="input-group-addon"><i class="material-icons">&#xE8B6;</i></span>
						</div>
					</form>
				</li>
				<li class="nav-item"><a href="#" class="nav-link"><i class="fa fa-facebook"></i></a></li>
				<li class="nav-item"><a href="#" class="nav-link"><i class="fa fa-twitter"></i></a></li>
				<li class="nav-item"><a href="#" class="nav-link"><i class="fa fa-google-plus"></i></a></li>
				<li class="nav-item"><a href="#" class="nav-link"><i class="fa fa-pinterest-p"></i></a></li>
			</ul>			
		</div>		
	</nav>
	<div id ="question_answer_container">
	</div>
</body>
<script src="../JavaScript/addQuestion.js"></script>
<script src="../JavaScript/questionSearch.js"></script>
<script src="../JavaScript/utils.js"></script>
<script src="../JavaScript/deleteQuestion.js"></script>
<script src="../JavaScript/addAnswer.js"></script>
</html>                                                        