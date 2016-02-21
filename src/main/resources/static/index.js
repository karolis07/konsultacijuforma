/**
 * Created by p998snc on 2016.02.10.
 */
var demoApp = angular.module('demoApp',['ngRoute']);

    demoApp.config(function($routeProvider){
        $routeProvider
            .when('/',
            {
                controller: 'loginController',
                templateUrl: 'pages/login.html'
            })
            .when('/register',
            {
                controller: 'registerController',
                templateUrl: 'pages/registration.html'
            })
            .when('/register2',
            {
                controller: 'testControl',
                templateUrl: 'pages/registration2.html'
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
            .when('/home',
            {
                controller: 'homeController',
                templateUrl: 'pages/home.html'
            })
            .when('/test',
            {
                controller: 'ContactCtrl',
                templateUrl: 'pages/test.html'
            })
            .otherwise({ redirectTo: '/'});
        });

//        demoapp.controller('loginCrtl', function($scope, $location)
//        {
//            $scope.submit = function()
//            {
//                if($scope.username == 'admin' $$ $scope.password == 'admin')
//                {
//                    $rootScope.username = $scope.username;
//                    $rootScope.password = $scope.password;
//                    $location.path('/home');
//                }else
//                {
//                    alert('Wrong stuff')
//                }
//            };
//        });

        demoApp.controller('ContactCtrl',function($scope, $http)
        {
            $scope.UpdateData = function () {
                    $http.put('/US1/'+$('#inputid').val()+'/'+$('#inputFirstname').val()+'/'+$('#inputLastname').val()+'/')
                };
        });

        demoApp.controller('cookieController', ['$scope', function($scope) {
            document.cookie = "someCookieName=true; expires=Fri, 31 Dec 9999 23:59:59 GMT; path=/";
            $scope.cookies = document.cookie;
        }]);

        demoApp.controller('loginController', ['$scope', '$http', '$templateCache',
            function($scope, $http, $templateCache){
                $scope.method = 'GET';
                $scope.url = '/peanuts';
                $scope.code = null;
                $scope.response = null;

                $http({method: $scope.method, url: $scope.url, cache: $templateCache}).
                then(function(response){
                    $scope.status = response.status;
                    $scope.data = response.data;
                }, function(response){
                    $scope.data = response.data || "Request failed";
                    $scope.status = response.status;
                });

                $scope.updateModel = function(method, url) {
                    $scope.method = method;
                    $scope.url = url;
                };
            }]);

        demoApp.controller('testControl', function($scope, $location){
            $scope.submit = function(){
                window.location.href = 'http://swedbank-us1bteam.rhcloud.com/insert?id=' + $scope.id + '&name=' + $scope.name + '&surname=' + $scope.surname;
                setTimer(window.location.href = 'http://swedbank-us1bteam.rhcloud.com/#/history', 3000);
                //$location.url('/home');
            };

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



