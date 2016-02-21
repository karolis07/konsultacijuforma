/**
 * Created by p998snc on 2016.02.10.
 */
var demoApp = angular.module('demoApp',['ngRoute', 'ngMaterial', 'ngMessages']);

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

        demoApp.controller('ContactCtrl',function($scope, $http, $location)
        {
            $scope.UpdateData = function () {
                    $http.put('/US1/'+$('#inputid').val()+'/'+$('#inputFirstname').val()+'/'+$('#inputLastname').val()+'/')
                    $location.url('/home');
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

        demoApp.directive('datepicker', function() {
                    return {
                        restrict: 'A',
                        require : 'ngModel',
                        link : function (scope, element, attrs, ngModelCtrl) {
                            $(function(){
                                element.datepicker({
                                    dateFormat:"yy-mm-dd",
                                    onSelect:function (date) {
                                        ngModelCtrl.$setViewValue(date);
                                        scope.$apply();
                                    }
                                });
                            });
                        }
                    }
                });

        demoApp.controller('contactController',function($scope, $http, $location)
        {
            $scope.submit = function () {
                    $http.put('/US3/'+$scope.theme+'/'+$scope.InputMessage+'/'+$scope.first_name+'/'+$scope.last_name+'/'+$scope.phone_number+'/'+$scope.email+'/'+$scope.answer+'/');
                    $location.url('/home');
            };
        });

        demoApp.controller('registerController', function($scope, $location, $http) {


           $scope.submit = function(){
                $http.put('/US2/' + $scope.name + '/' + $scope.surname + '/' + $scope.tel + '/' + $scope.email + '/' + $scope.bank + '/' + $scope.date + '/' + $scope.subject + '/' + $scope.message);
                $location.url('/home');
            //$location.url('/home');
                //window.location.href = 'google.com';
           };

           $scope.myDate = new Date();
             $scope.minDate = new Date(
                 $scope.myDate.getFullYear(),
                 $scope.myDate.getMonth() - 2,
                 $scope.myDate.getDate());
             $scope.maxDate = new Date(
                 $scope.myDate.getFullYear(),
                 $scope.myDate.getMonth() + 2,
                 $scope.myDate.getDate());
             $scope.onlyWeekendsPredicate = function(date) {
               var day = date.getDay();
               return day === 0 || day === 6;
             }

//           angular.element(document).ready(function () {
//                var date_input=$('input[name="date"]'); //our date input has the name "date"
//                var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
//                date_input.datepicker({
//                    format: 'yyyy-mm-dd',
//                    container: container,
//                    todayHighlight: true,
//                    autoclose: true,
//                })
//           });
        });



