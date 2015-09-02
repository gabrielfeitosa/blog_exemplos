(function(){

  angular.module('gf-app').controller('FeiraController',FeiraController);
  
  function FeiraController($scope,$http){
    $http.get('animais.json').then(function(res){
      $scope.animais = res.data;
    });
    $scope.teste = 'Oi';  
  }
})();
