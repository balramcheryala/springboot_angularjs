<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Mails</title>
</head>
<body>
	<h1>Mails</h1>
	<h3>{{message}}</h3>
	<h2>${msgstatus}</h2>
	<div class="col-lg-6 col-lg-offset-3">
		<div class="well">
			<div class="container">
				<div class="row">
					<div class="col-lg-6">

						<form action="sendmail" commandName="mail" method="post" enctype="multipart/form-data" ng-controller="MailController">
							
							<div class="form-group">
								<input type="text" name="to" placeholder="To address here!">
								<label for="input1" class="col-lg-3 control-label">To
									Mail</label> <br />
							</div>
							<div class="form-group">
								<input type="text" name="subject"
									placeholder="Subject something here!"> <label
									for="input1" class="col-lg-3 control-label">subject
									Mail</label> <br />
							</div>
							<div class="form-group">
								<input type="text" name="text" placeholder="message here!">
								<label for="input1" class="col-lg-3 control-label">message</label>
								<br /> <br /> <!-- <input type="file" ng-file="attachFile" multiple> -->
							</div>
							<br /> <br /> 
							Select File[s]: <input type="file" name="attachFiles" multiple="multiple"/> <input type="submit" value="Submit" />
						</form>


						<!-- <form ng-submit="submit()" ng-controller="MailController" enctype="multipart/form-data> ">
							<div class="form-group">
								<input type="text" ng-model="to" placeholder="To address here!">
								<label for="input1" class="col-lg-3 control-label">To
									Mail</label> <br />
							</div>
							<div class="form-group">
								<input type="text" ng-model="subject"
									placeholder="Subject something here!"> <label
									for="input1" class="col-lg-3 control-label">subject
									Mail</label> <br />
							</div>
							<div class="form-group">
								<input type="text" ng-model="message" placeholder="message here!">
								<label for="input1" class="col-lg-3 control-label">message</label>
								<br /> <br /> <input type="file" ng-file="attachFile" multiple>
							</div>
							<br /> <br /> <input type="submit" value="Send">

						</form> -->
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>