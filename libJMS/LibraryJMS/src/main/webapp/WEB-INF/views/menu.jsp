<!DOCTYPE html>
<!-- saved from url=(0050)http://getbootstrap.com/examples/navbar-fixed-top/ -->
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="http://getbootstrap.com/favicon.ico">

<title>Library Management System</title>

<!-- Bootstrap core CSS -->
<link href="http://getbootstrap.com/dist/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link
	href="http://getbootstrap.com/examples/navbar-fixed-top/navbar-fixed-top.css"
	rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
<script src="./scripts/ie-emulation-modes-warning.js"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<!-- Fixed navbar -->
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Library Management System</a>
			</div>
			<div id="navbar" class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Authors<span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a
								href="showAddAuthor">Create</a></li>
							<li><a
								href="showAuthorsList">Manage</a></li>
							<li><a
								href="uploadAuthor">Bulk Add Authors</a></li>
							</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Publishers<span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a
								href="showAddPublisher">Create</a></li>
							<li><a
								href="showPublisherList">Manage</a></li>
							<li><a
								href="uploadPub">Bulk Add Pubs</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Books<span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a
								href="showAddBook">Create</a></li>
							<li><a
								href="showBookList">Manage</a></li>
							<li><a
								href="uploadBook">Bulk Add Books</a></li>
						</ul></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Branch
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="showAddBranch">Create</a></li>
							<li><a href="showBranchList">Manage Branch</a></li>
							<li><a href="uploadBranch">Bulk Add Branch</a></li>
						</ul></li>

					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">Borrower
							<span class="caret"></span>
					</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="showAddBorrower">Create</a></li>
							<li><a href="showBorrowerList">Manage Borrower</a></li>
							<li><a href="uploadBorrower">Bulk Add Borrower</a></li>
						</ul></li>
						
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<!-- /container -->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="./scripts/jquery.min.js"></script>
	<script src="./scripts/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="./scripts/ie10-viewport-bug-workaround.js"></script>

</body>
</html>