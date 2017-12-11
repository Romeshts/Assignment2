lms.controller("loginController",['$rootScope','$scope','$http','$window', function($rootScope, $scope, $http, $window) {
    $scope.loginForm = {
        id : -1,
        userName : "",
        password : "",
        checkAdmin : ""
    };
    $rootScope.isLoggedIn = 0;

    //HTTP POST method for login.
    $scope.submitLoginForm = function() {
        var method = "";
        var url = "";
        if ($scope.loginForm.id == -1) {
            method = "POST";
            url = 'RAHLMS/login';
        }
        $http({
            method : method,
            url : url,
            data : angular.toJson($scope.loginForm),
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then(_success, _error);
    };

    function _success(response) {

        if (response.data.id == -1) {
            console.log("Invalid user details entered. Please check once!");
            $scope.loginMessage = "Invalid user details entered. Please check once!";
            _clearFormData();
        }
        else {
        	if (response.data.checkAdmin == 0) {
                $rootScope.readerId = response.data.id;
            }
            else {
                $rootScope.readerId = -1;
            }
            $rootScope.isAdmin = response.data.checkAdmin;
            $rootScope.isLoggedIn = 1;
            $window.location.href = "#/home";
        }
    }

    function _error(response) {
        console.log(response.statusText);
    }

    //Clear the form
    function _clearFormData() {
        $scope.loginForm.id = -1;
        $scope.loginForm.userName = "";
        $scope.loginForm.password = "";
        $scope.loginForm.checkAdmin = "";
        };
}]);