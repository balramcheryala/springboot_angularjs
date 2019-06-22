<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Blog</title>
</head>
<body ng-app="myApp.blog" ng-controller="BlogController">
<div class="row">
	<h1>Blog</h1>
	<h3>{{message}}</h3>
	<button class="btn btn-warning" ng-click="myIP()">ip</button>
	<div ng-if="data">
		<div class="table-responsive list">
		<table class="table table-bordered table-responsive">
			<thead>
				<tr>
					<th>Ip Address</th>
					<th>MacAddress</th>
					<th>ASN</th>
					<th>CITY Name</th>
					<th>Country Name</th>
					<th>Latitude</th>
					<th>Longitude</th>
					<th>Organization</th>
					<th>Postal</th>
					<th>Region</th>
					<th>Region_code</th>
					<th>TimeZone</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>{{data.ip}}</td>
					<td>{{data.macAddress}}</td>
					<td>{{data.asn}}</td>
					<td>{{data.city}}</td>
					<td>{{data.country_name}}</td>
					<td>{{data.latitude}}</td>
					<td>{{data.longitude}}</td>
					<td>{{data.org}}</td>
					<td>{{data.postal}}</td>
					<td>{{data.region}}</td>
					<td>{{data.region_code}}</td>
					<td>{{data.timezone}}</td>
			</tbody>
		</table>
	</div>
	</div>
	</div>
	<div ng-if="error">
	</div>
</body>
</html>