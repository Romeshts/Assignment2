lms.controller("transactionsController", ['$rootScope','$scope','$http','$window', function($rootScope, $scope, $http, $window) {

    $scope.admin = $rootScope.isAdmin;
    $scope.availableReaderId = $rootScope.readerId;
    alert("Inside transactionsController...");
    //alert("$rootScope.admin::" + $rootScope.isAdmin);
    //alert("$rootScope.readerId::" + $rootScope.readerId);
    //alert("$scope.admin::" + $scope.admin);
    //alert("$scope.availableReaderId::" + $scope.availableReaderId);

    //Now load the data from server
    _refreshAvailableBooks();

    //HTTP GET - get all the available books
    function _refreshAvailableBooks() {
        //alert("Inside _refreshAvailableBooks()...");
        $http({
            method : 'GET',
            url : 'http://localhost:8080/mavenLMSWebAppProject/RAHLMS/availableBookCopies'
        }).then(function successCallback(response) {
            $scope.availableCopies = response.data;
        }, function errorCallback(response) {
            console.log(response.statusText);
        });
    }

	//HTTP POST method for login. 
    $scope.submitLoginForm = function() {
        var method = "";
        var url = "";
        if ($scope.loginForm.id == -1) {
            method = "POST";
            url = 'RAHLMS/reserve';
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
    	alert ("We are here 444444::response.data.checkAdmin::" + response.data.checkAdmin);
    	alert ("We are here 444444::response.data.id::" + response.data.id);
    	alert ("We are here 444444::response.data.userName::" + response.data.userName);
    	alert ("We are here 444444::response.data.password::" + response.data.password);
    	if (response.data.id == -1) {
    		console.log("response.statusText::" + response.statusText);
    		console.log("Invalid user details entered. Please check once!");
    		$scope.loginMessage = "Invalid user details entered. Please check once!";
    		_clearFormData();
    	} else {
    		console.log("response.statusText::" + response.statusText);
    		$rootScope.isAdmin = response.data.checkAdmin;
    		$rootScope.isLoggedIn = 1;
    		if (response.data.checkAdmin == 1) {
    	        $rootScope.readerId = response.data.id;
    		} else {
    			$rootScope.readerId = -1;	        			
    		}
    		$window.location.href = "home.html";
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