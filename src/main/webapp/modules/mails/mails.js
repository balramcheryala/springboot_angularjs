'use strict';

angular.module('myApp.mails', [ 'ngRoute', 'ngResource', 'ui-notification' ])

.config(
		[ '$routeProvider', '$httpProvider',
				function($routeProvider, $httpProvider) {
					$routeProvider.when('/mail', {
						templateUrl : 'modules/mails/mails.jsp',
						controller : 'MailController'
					});
				} ])

.controller('MailController', function($scope, $http, Notification) {
	$scope.submit = function() {
		var mail = ({
			to : $scope.to,
			subject : $scope.subject,
			text : $scope.message
		});
		alert(mail);

		var postResponse = $http.post('api/sendmail', mail);
		postResponse.success(function(data, status, headers, config) {
			if (data.$MSG) {
				Notification.error({
					message : 'Exception  : ---> ' + data.$MSG,
					positionY : 'bottom',
					positionX : 'right'
				});
			} else
				Notification.success({
					message : 'Success  : ---> Mail sent to : ' + config.data.to,
					positionY : 'bottom',
					positionX : 'right'
				});
		})
		$scope.to = '';
		$scope.subject = '';
		$scope.message = '';
		$scope.attachFile = '';
	}

});