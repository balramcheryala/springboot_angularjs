'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp',
		[ 'ngRoute',
			'myApp.home',
			'myApp.form', 
			'myApp.upload', 
			'myApp.blog',
			'myApp.about', 
			'myApp.mails',
			'ui-notification',
			'myapp.alerts'])
		
.config(
		[ '$routeProvider', function($routeProvider) {

			$routeProvider.when('/', {
				templateUrl : 'modules/home/home.jsp',
				controller : 'HomeController'
			})

			$routeProvider.otherwise({
				redirectTo : '/'
			});
		} ]);