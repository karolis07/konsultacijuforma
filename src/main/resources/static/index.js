/**
 * Created by p998snc on 2016.02.10.
 */
var demoApp = angular.module('demoApp',['ngRoute']);

    demoApp.config(function($routeProvider){
        $routeProvider
            .when('/',
            {
                controller: 'homeController',
                templateUrl: 'pages/home.html'
            })
            .when('/register',
            {
                controller: 'registerController',
                templateUrl: 'pages/registration.html'
            })
            .when('/contact',
            {
                controller: 'contactController',
                templateUrl: 'pages/contact.html'
            })
            .when('/history',
                        {
                            controller: 'historyController',
                            templateUrl: 'pages/history.html'
                        })
            .otherwise({ redirectTo: '/'});
        });

        demoApp.controller('registerController', [function() {
                   angular.element(document).ready(function () {
                        var date_input=$('input[name="date"]'); //our date input has the name "date"
                        var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
                        date_input.datepicker({
                            format: 'dd/mm/yyyy',
                            container: container,
                            todayHighlight: true,
                            autoclose: true,
                        })
                        });
                     }]);



