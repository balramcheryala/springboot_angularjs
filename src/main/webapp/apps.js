angular.module('notificationTest', ['ui-notification']);

angular.module('notificationTest')

.controller('notificationController', function($scope, Notification) {
    
    $scope.primary = function() {
        Notification('Primary notification');
    };

    $scope.error = function() {
        Notification.error('Error notification');
    };

    $scope.success = function() {
        Notification.success('Success notification');
    };

    $scope.info = function() {
        Notification.info('Information notification');
    };

    $scope.warning = function() {
        Notification.warning('Warning notification');
    };

    // ==

    $scope.primaryTitle = function() {
        Notification({message: 'Primary notification', title: 'Primary notification'});
    };

    // ==

    $scope.errorTime = function() {
        Notification.error({message: 'Error notification 1s', delay: 1000});
    };
    $scope.errorNoTime = function() {
        Notification.error({message: 'Error notification (no timeout)', delay: null});
    };

    $scope.successTime = function() {
        Notification.success({message: 'Success notification 20s', delay: 20000});
    };

    // ==

    $scope.errorHtml = function() {
        Notification.error({message: '<b>Error</b> <s>notification</s>', title: '<i>Html</i> <u>message</u>'});
    };

    $scope.successHtml = function() {
        Notification.success({message: 'Success notification<br>Some other <b>content</b><br><a href="https://github.com/alexcrack/angular-ui-notification">This is a link</a><br><img src="https://angularjs.org/img/AngularJS-small.png">', title: 'Html content'});
    };

    // ==

    $scope.TopLeft = function() {
        Notification.success({message: 'Success Top Left', positionX: 'left'});
    };

    $scope.BottomRight = function() {
        Notification.error({message: 'Error Bottom Right', positionY: 'bottom', positionX: 'right'});
    };

    $scope.BottomLeft = function() {
        Notification.warning({message: 'warning Bottom Left', positionY: 'bottom', positionX: 'left'});
    };

    // == 

    $scope.nTitle = "Title from other scope";
    $scope.nClicksLog = [];
    $scope.nClick = function() {
        $scope.nClicksLog.push("Clicked");
    };
    $scope.nElements = ['one', 'two', 'three'];
    $scope.customTemplateScope = function() {
        Notification.primary({message: "Just message", templateUrl: "custom_template.html", scope: $scope});
    };

});