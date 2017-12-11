lms.controller('addReaderController', ['$rootScope','$scope', function($rootScope,$scope) {

    $scope.admin=1;
    $scope.branch=["Newark","Woodbridge","Edison","Elizabeth"];
    $scope.doc_type=["Book","Journal Volume","Proceedings"];
    $scope.editors=["Harsha","Jasti"];
    $scope.publishers=["Sunrise Publications","Sunset publications"]
    console.log($scope.branch);

    $scope.add_doc = function(x){
        console.log(x);
        $scope.message="Doc has successfully been added to the system";
    }

}]);