'use strict';

angular.module('myApp.signup', [ 'ngRoute', 'ngResource' ])

.config([ '$routeProvider', function($routeProvider) {
	$routeProvider

	.when('/signup', {
		templateUrl : 'modules/signup/signup.jsp',
		controller : 'SignupController'
	});
} ])

.controller('SignupController', function($scope, $http) {
	$scope.message = 'Hello from SignupController';
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
		})
		$scope.userName = '';
		$scope.password = '';
		$scope.firstName = '';
		$scope.lastName = '';
		$scope.emailAddress = '';
	}
});