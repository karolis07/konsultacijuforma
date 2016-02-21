angular.module('someCtrl', ['ui.router'])
  .config(function($stateProvider) {
    $stateProvider.state(
      'some', {
        url: '/some/:variable',
        controller: 'SomeCtrl',
        templateUrl: 'someCtrl.html'
      }
    );
  })
  .controller(
    'SomeCtrl',
    function($scope, $state) {
      // ...
    });