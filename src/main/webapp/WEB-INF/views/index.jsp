<!doctype html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html ng-app="myApp">

<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<script src="vendors/angular.min.js"></script>
<script src="vendors/angular-route.min.js"></script>
<script src="vendors/angular-resource.js"></script>


<link rel="shortcut icon" href="images/favicon.png" />
<link href="css/bootstrap-united.css" rel="stylesheet" />
<link href="css/style.css" rel="stylesheet" />
<link href="css/alerts.css" rel="stylesheet" />

</head>
<body ng-app="myApp">
	<div class="container">
	<header ng-include="'modules/header/header.jsp'"></header>
	
      <div class="container-fluid">
  			<div class="container-bgwraper"> 
      			<div class="col-md-12">
      				<div ng-view></div>
      			</div>
      		</div>
     </div>
     
	<footer ng-include="'modules/footer/footer.jsp'"></footer>
	<script src="app.js"></script>
	<script src="jQuery/jquery-3.4.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
	<script src="modules/home/home.js"></script>
	<script src="modules/blog/blog.js"></script>
	<script src="modules/about/about.js"></script>
	<script src="modules/form/form.js"></script>
	<script src="modules/upload/upload.js"></script>
	<script src="modules/mails/mails.js"></script>
	<script src="modules/alerts/alerts.js"></script>
	</div>
</body>

</html>