/**
 * Created by p998snc on 2016.02.10.
 */
var demoApp = angular.module('demoApp',['ngRoute']);

    demoApp.config(['$routeProvider', function ($routeProvider){
        $routeProvider
            .when('/',
            {
                controller: 'SimpleController',
                templateUrl: 'home.html'
            })
            .when('/newReg',
            {
                controller: 'SimpleController',
                templateUrl: 'newRegistration.html'
            })
            .when('/contact',
            {
                controller: 'SimpleController',
                templateUrl: 'contact.html'
            })
            .when('/history',
                        {
                            controller: 'SimpleController',
                            templateUrl: 'history.html'
                        })
            .otherwise({ redirectTo: '/'});
        }]);
