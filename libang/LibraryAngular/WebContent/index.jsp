<!DOCTYPE html>
<!-- saved from url=(0050)http://getbootstrap.com/examples/navbar-fixed-top/ -->
<html lang="en" ng-app="libraryApp">
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
    
<script type="text/javascript" src="./scripts/bootstrap-multiselect.js"></script>
<link rel="stylesheet" href="./css/bootstrap-multiselect.css" type="text/css"/>

<script data-require="angular.js@*" data-semver="1.2.13"
	src="http://code.angularjs.org/1.2.13/angular.js"></script>
<script data-require="angular-route.js@*" data-semver="1.2.13"
	src="http://code.angularjs.org/1.2.13/angular-route.js"></script>
<script data-require="angular-route.js@*" data-semver="1.2.13"
	src="http://code.angularjs.org/1.2.13/angular-cookies.js"></script>
<script src="./scripts/app.js"></script>

</head>


<body>

	<!-- Fixed navbar -->
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<section ng-include=" 'menu.html' " id="header"
				class="top-header"></section>
			<!--/.nav-collapse -->
		</div>
	</nav>

	<!-- /container -->
	<div class="view-container">
		<section ng-view id="content" class="animate-fade-up"></section>
	</div>

</body>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="./scripts/jquery.min.js"></script>
	<script src="./scripts/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="./scripts/ie10-viewport-bug-workaround.js"></script>

</html>