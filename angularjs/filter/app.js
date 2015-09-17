(function() {
  'use strict';
  angular.module('app-filters', []);

  angular.module('app-filters')
    .filter('inverterString', function() {
      return function(input) {
        input = input || '';
        var out = "";
        for (var i = 0; i < input.length; i++) {
          out = input.charAt(i) + out;
        }
        return out;
      };
    });

  angular.module('app-filters')
    .filter('abestado', function() {
      return function(input) {
        input = input || '';
        if (input) {
          return input + ' é abestado!';
        }
        return input;
      };
    });

  angular.module('app-filters')
    .controller('ExemploController', function($scope, $filter,currencyFilter) {
      $scope.moedaFormatada = $filter('currency')(123456789);
      $scope.moedaFormatada2 = currencyFilter(123456789);
      $scope.dataFormatada = $filter('date')('1984-12-15T00:00','medium');
    });
})();