'use strict';

angular.module('myApp.blog', [ 'ngRoute', 'ngResource','ui-notification' ])

.config([ '$routeProvider', function($routeProvider) {
	$routeProvider

	.when('/blog', {
		templateUrl : 'modules/blog/blog.jsp',
		controller : 'BlogController'
	});
} ])

.controller('BlogController', function($scope, $http,Notification) {
	$scope.message = 'Hello from BlogController';
	$scope.myIP = function() {
		$http({
			method : 'GET',
			url : 'api/ip'
		}).success(function(data, status, headers, config) {
			$scope.data = data;
			Notification.info({
				message : 'Your Ip is saved : ---> '+data.ip,
				positionY : 'bottom',
				positionX : 'right', delay: 3000});
		}).error(function(data, status, headers, config) {
			Notification.error({
				message : 'Error Code is : ---> '+status,
				positionY : 'bottom',
				positionX : 'right'
			});
		});
	}

});