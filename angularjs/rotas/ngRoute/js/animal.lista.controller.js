(function() {
    'use strict';

    angular.module('feira-app')
      .controller('AnimalListaController', AnimalListaController);

    AnimalListaController.$inject = ['$scope', 'AnimalFactory'];

    function AnimalListaController($scope, AnimalFactory) {
      $scope.nome = 'AnimalListaController';
      $scope.listar = function() {
        return AnimalFactory.listar();
      };
    }

})();