var lms = angular.module('lms', ['ngRoute']);

lms.config(['$routeProvider', function ($routeProvider) {

    $routeProvider.when('/login', {
        templateUrl: 'login.html',
        controller: 'loginController'
    }).when('/home', {
        templateUrl: 'home.html',
        controller: 'homeController'
    }).when('/transactions', {
        templateUrl: 'transactions.html',
        controller: 'transactionsController'
    }).when('/addReader', {
        templateUrl: 'add_reader.html',
        controller: 'addReaderController'
    }).when('/addBook', {
        templateUrl: 'add_book.html',
        controller: 'addBookController'
    }).when('/addBranch', {
        templateUrl: 'add_branch.html',
        controller: 'addBranchController'
    }).when('/admin', {
        templateUrl: 'admin.html',
        controller: 'adminController'
    }).otherwise({
        redirectTo: '/login'
    });
}]);