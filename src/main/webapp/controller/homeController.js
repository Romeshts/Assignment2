lms.controller("homeController", ['$rootScope','$scope','$http','$window', function($rootScope, $scope, $http, $window) {

    $scope.admin = $rootScope.isAdmin;

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

	//HTTP POST method for reader - Reserve a book. 
    $scope.reserveABook = function(x) {
    	console.log("reserveABook::" + x);
    	console.log("branchName::" + x.branchName);
    	console.log("branchId::" + x.branchId);
    	console.log("docId::" + x.docId);
    	console.log("docTitle::" + x.docTitle);
    	console.log("copyNo::" + x.copyNo);
    	console.log("copyPosition::" + x.copyPosition);
    	console.log("readerId::" + x.readerId);
            /*method = "POST";
            url = 'RAHLMS/reserve';
        $http({
            method : method,
            url : url,
            data : angular.toJson($scope.loginForm),
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then(_success, _error);*/
    };

	//HTTP POST method for admin - Borrow a book. 
    $scope.borrowABook = function(x) {
    	console.log("reserveABook::" + x);
    	console.log("branchName::" + x.branchName);
    	console.log("branchId::" + x.branchId);
    	console.log("docId::" + x.docId);
    	console.log("docTitle::" + x.docTitle);
    	console.log("readerId::" + x.readerId);
    	console.log("copyNo::" + x.copyNo);
    	console.log("copyPosition::" + x.copyPosition);
            /*method = "POST";
            url = 'RAHLMS/reserve';
        $http({
            method : method,
            url : url,
            data : angular.toJson($scope.loginForm),
            headers : {
                'Content-Type' : 'application/json'
            }
        }).then(_success, _error);*/
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