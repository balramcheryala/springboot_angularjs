'use strict';

angular.module('myApp.upload', [ 'ngRoute', 'ngResource','ui-notification' ])

.config([ '$routeProvider', function($routeProvider) {
	$routeProvider

	.when('/upload', {
		templateUrl : 'modules/upload/upload.jsp',
		controller : 'UploadController'
	});
} ])


.directive('fileModel', ['$parse', function ($parse) {
            return {
               restrict: 'A',
               link: function(scope, element, attrs) {
                  var model = $parse(attrs.fileModel);
                  var modelSetter = model.assign;
                  
                  element.bind('change', function() {
                     scope.$apply(function() {
                        modelSetter(scope, element[0].files[0]);
                     });
                  });
               }
            };
         }])
         
.controller('UploadController', ['$scope','$http','Notification', function($scope,$http, Notification ) {
            $scope.uploadFile = function() {
               var file = $scope.myFile;
               
               console.dir(file);
               
               var uploadUrl = "/upload";
               var fd = new FormData();
               fd.append('files', file);
            
               $http.post(uploadUrl, fd, {
                  transformRequest: angular.identity,
                  headers: {'Content-Type': undefined}
               })
            
               .success(function() {
            	   Notification.info({
       				message : 'Your File is saved in Database',
       				positionY : 'bottom',
       				positionX : 'right', delay: 3000});
               })
            
               .error(function() {
            	   Notification.error({
       				message : 'Oops : Something went wrong ',
       				positionY : 'bottom',
       				positionX : 'right'
       			});
               })
            };
}]);