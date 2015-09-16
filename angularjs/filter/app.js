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
})();