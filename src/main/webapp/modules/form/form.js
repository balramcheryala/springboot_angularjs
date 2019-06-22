'use strict';

angular.module('myApp.form', [ 'ngRoute', 'ngResource' ,'ui-notification' ])

.config([ '$routeProvider', function($routeProvider) {
	$routeProvider

	.when('/form', {
		templateUrl : 'modules/form/form.jsp',
		controller : 'FormController'
	});
} ])

.controller('FormController', function($scope, $http,Notification) {
	$scope.message = 'Create a Request';
	$scope.submit = function() {
		var person = ({
			name : $scope.name,
			email : $scope.email,
			password : $scope.password,
			mobile : $scope.mobile
		});

		var res = $http.post('save', person);
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
		$scope.name = '';
		$scope.email = '';
		$scope.password = '';
		$scope.mobile = '';
	}
});