'use strict';

angular.module('myApp.home', [ 'ngRoute', 'ngResource', 'ui-notification' ])

.config([ '$routeProvider', function($routeProvider) {
	$routeProvider

	.when('/home', {
		templateUrl : 'modules/home/home.jsp',
		controller 	: 'HomeController'
	});
} ])

.controller('HomeController', function($scope, $http, Notification) {
	$scope.message = 'Hello from HomeController';
	$scope.exe = function() {
		$http({
			method 	: 'GET',
			url 	: 'api/exe'
		}).success(function(data, status, headers, config) {
			Notification.info({
				message : 'Exception Occured \nClass Name : '+data.$GLOBAL_ERROR.stackTrace[0].fileName
				+ "\nMethod name : "+data.$GLOBAL_ERROR.stackTrace[0].methodName
				+"\nLine Number : "+data.$GLOBAL_ERROR.stackTrace[0].lineNumber,
				positionY : 'bottom',
				positionX : 'right', delay: 10000});
		}).error(function(data, status, headers, config) {
			alert("failure");
		});
	}
	$scope.sendMail = function() {
		$http({
			method 	: 'POST',
			url 	: 'api/sendmail'
		}).success(function(data, status, headers, config) {
			Notification.info({
				message : 'Exception Occured \nClass Name : '+data,
				positionY : 'bottom',
				positionX : 'right', delay: 10000});
		}).error(function(data, status, headers, config) {
			alert("failure");
		});
	}
	$scope.exception = function(obj){
		$http({
			method 	: 'GET',
			url 	: obj
		}).success(function(data, status, headers, config) {
			$scope.datas = data;
		}).error(function(data, status, headers, config) {
			alert("failure");
		});
		
	}
	$scope.startService = function(obj){
		$http({
			method 	: 'POST',
			url 	: obj
		}).success(function(data, status, headers, config) {
			$scope.datas = data;
		}).error(function(data, status, headers, config) {
			alert("failure");
		});
		
	}
	$scope.stopService = function(obj){
		$http({
			method 	: 'POST',
			url 	: obj
		}).success(function(data, status, headers, config) {
			$scope.datas = data;
		}).error(function(data, status, headers, config) {
			alert("failure");
		});
		
	}

});