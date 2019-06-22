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
    
	
	 // On select of each file it will add in files array i.e store in Array.
    $scope.getFileDetails = function (e) {

        $scope.files = [];
        $scope.$apply(function () {

            // STORE THE FILE OBJECT IN AN ARRAY.
            for (var i = 0; i < e.files.length; i++) {
                $scope.files.push(e.files[i])
            }

        });
    };
	
	
	
	$scope.uploadFile = function() {
//               var file = $scope.myFile; // Single purpose
               
//               console.dir(file);
               
               var uploadUrl = "/upload";
               var fd = new FormData();
               
               for (var i in $scope.files) {
            	   fd.append("files", $scope.files[i]);
               }
               
               
//               fd.append('files', file); // single
            
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
               
	}; // remove this if you need to use progress bar
	
               /*
               // ADD LISTENERS.
               var objXhr = new XMLHttpRequest();
               objXhr.addEventListener("progress", updateProgress, false);
               objXhr.addEventListener("load", transferComplete, false);

               // SEND FILE DETAILS TO THE API.
               objXhr.open("POST", "/upload");
               objXhr.send(fd);
            };
            
            // UPDATE PROGRESS BAR.
            function updateProgress(e) {
                if (e.lengthComputable) {
                    document.getElementById('pro').setAttribute('value', e.loaded);
                    document.getElementById('pro').setAttribute('max', e.total);
                }
            }

            // CONFIRMATION.
            function transferComplete(e) {
                alert("Files uploaded successfully.");
            }*/
}]);