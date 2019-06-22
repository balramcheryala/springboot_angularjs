'use strict';

angular.module('myApp.about', [ 'ngRoute', 'ngResource' ,'ui-notification' ])

.config([ '$routeProvider', function($routeProvider) {
	$routeProvider

	.when('/about', {
		templateUrl : 'modules/about/about.jsp',
		controller : 'AboutController'
	});
} ])

.controller('AboutController', function($scope, $http,Notification) {
	$scope.message = 'Hello from AboutController';
	$scope.submit = function() {
		var AncySignUp = ({
			userName : $scope.userName,
			password : $scope.password,
			firstName : $scope.firstName,
			lastName : $scope.lastName,
			emailAddress : $scope.emailAddress
		});

		var res = $http.post('api/signup', AncySignUp);
		res.success(function(data, status, headers, config) {
			$scope.message = data;
			Notification.info({
				message : 'Code is : ---> '+data,
				positionY : 'bottom',
				positionX : 'right'
			});
		}).error(function(data, status, headers, config) {
			Notification.error({
				message : 'Error Code is : ---> '+data,
				positionY : 'bottom',
				positionX : 'right', delay: 10000});
		});
		$scope.userName = '';
		$scope.password = '';
		$scope.firstName = '';
		$scope.lastName = '';
		$scope.emailAddress = '';
	}
});