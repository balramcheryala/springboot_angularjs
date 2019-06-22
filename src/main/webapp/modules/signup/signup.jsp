<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Signup</title>
</head>
<body>
	 <h1>SignupController</h1>
        <h3>{{message}}</h3>
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
	        <form ng-submit="submit()" ng-controller="SignupController">
	            Enter text userName
	            <input type="text" ng-model="userName" name="text" />
	            <br>Enter text password
	            <input type="text" ng-model="password" name="text" />
	            <br>Enter text firstName
	            <input type="text" ng-model="firstName" name="text" />
	            <br>
	            <br>Enter text lastName
	            <input type="text" ng-model="lastName" name="text" />
	            <br>
	            <br>Enter text emailAddress
	            <input type="text" ng-model="emailAddress" name="text" />
	            <br>
	            <input type="submit" id="submit" value="Submit" />
	        </form>
        </div>
</body>
</html>