(function() {
  'use strict';
  angular.module('feira-app', ['ngRoute']);

  angular.module('feira-app')
    .run(function($rootScope, $route, $routeParams, $location) {
      $rootScope.$route = $route;
      $rootScope.$location = $location;
      $rootScope.$routeParams = $routeParams;
    });

  angular.module('feira-app')
    .config(function($routeProvider) {
      $routeProvider
        .when('/animais', {
          templateUrl: 'lista.html',
          controller: 'AnimalListaController'
        })
        .when('/animais/:id', {
          templateUrl: 'detalhe.html',
          controller: 'AnimalDetalheController'
        }).otherwise({
          redirectTo: '/animais'
        });
    });
})();