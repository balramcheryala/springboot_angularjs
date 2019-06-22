<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About</title>
</head>
<body>
	<h3>{{message}}</h3>
	<div class="">
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="">
						 <form ng-submit="submit()" ng-controller="AboutController">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
								<input type="text" ng-model="userName" placeholder="User Name">
								<label for="input1" class="col-lg-3 control-label">Enter text userName</label> <br />
							</div>
							
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
								<input type="text" ng-model="password" placeholder="Password">
								<label for="input1" class="col-lg-3 control-label">Choose your password</label> <br />
							</div>
							
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
								<input type="text" ng-model="firstName" placeholder="First Name">
								<label for="input1" class="col-lg-3 control-label">Enter your first name</label> <br />
							</div>
							
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
								<input type="text" ng-model="lastName" placeholder="Last Name">
								<label for="input1" class="col-lg-3 control-label">Enter your last name</label> <br />
							</div>
							
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
								<input type="text" ng-model="emailAddress" placeholder="Email Address">
								<label for="input1" class="col-lg-3 control-label">Enter your email address</label> <br />
							</div>
													
							<br /> <br /> <input type="submit" value="Send">

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>