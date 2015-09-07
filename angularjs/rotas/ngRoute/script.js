(function(){
    angular.module('feira-app',['ngRoute']);

    angular.module('feira-app')
      .config(function configurar($routeProvider){
        $routeProvider
          .when('/animais', {
            templateUrl: 'list.html',
            controller: 'AnimalListaController'
          })
          .when('/animais/:id', {
            templateUrl: 'detalhe.html',
            controller: 'AnimalDetalheController'
          }).otherwise({
            redirectTo: '/animais'
          });
    });

    angular.module('feira-app')
      .controller('AppController',function($scope, $route, $routeParams, $location){
        $scope.$route = $route;
        $scope.$location = $location;
        $scope.$routeParams = $routeParams;
    });

    angular.module('feira-app')
      .controller('AnimalListaController',function($scope,AnimalFactory){
        $scope.nome = 'AnimalListaController';
      $scope.listar = function(){
        return AnimalFactory.listar();
      }
    });

    angular.module('feira-app')
      .controller('AnimalDetalheController',function($scope,$routeParams,AnimalFactory){
      $scope.nome = 'AnimalDetalheController';
      $scope.animal = AnimalFactory.recuperar($routeParams.id);
    });

    angular.module('feira-app')
      .factory('AnimalFactory',function AnimalFactory($http){
        var animais = [];

        init();

        return {
          recuperar: get,
          listar: list
        }

        function init(){
          $http.get('/animais.json').then(function(response){
            animais = response.data;
          });
        }

        function get(id){
          return animais[id];
        }

        function list(){
          return animais;
        }
    });
})();