<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Blog</title>
</head>
<body ng-app="myApp" ng-controller="UploadController">
	<div class="row">
		<h1>Upload</h1>
		<h3>{{message}}</h3>
			<input type = "file" file-model = "myFile" multiple onchange="angular.element(this).scope().getFileDetails(this)"/>
        	<button ng-click = "uploadFile()">upload me</button>
        	
        	<!--ADD A PROGRESS BAR ELEMENT.-->
        	<!-- <p><progress id="pro" value="0"></progress></p> -->
	</div>
</body>
</html>