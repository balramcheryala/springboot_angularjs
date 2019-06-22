<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Form</title>
</head>
<body>
	<h3>{{message}}</h3>
	<div class="">
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="">
						 <form ng-submit="submit()" ng-controller="FormController">
						 
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
								<input type="text" ng-model="name" placeholder="Name">
								<label for="input1" class="col-lg-3 control-label">Your Name</label> <br />
							</div>
							
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
								<input type="text" ng-model="email" placeholder="Email Id">
								<label for="input1" class="col-lg-3 control-label">Email Id </label> <br />
							</div>
							
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
								<input type="text" ng-model="password" placeholder="Passsword">
								<label for="input1" class="col-lg-3 control-label">PassWord</label> <br />
							</div>
							
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12 form-group">
								<input type="text" ng-model="mobile" placeholder="Mobile">
								<label for="input1" class="col-lg-3 control-label">Mobile </label> <br />
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