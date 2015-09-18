(function() {
  'use strict';
  angular.module('app-filters', []);

  angular.module('app-filters').filter('cpf', function() {
    return function(input) {
      var str = input + '';
      if(str.length <= 11){
        str = str.replace(/\D/g, '');
        str = str.replace(/(\d{3})(\d)/, "$1.$2");
        str = str.replace(/(\d{3})(\d)/, "$1.$2");
        str = str.replace(/(\d{3})(\d{1,2})$/, "$1-$2");
      }
      return str;
    };
  });

  angular.module('app-filters')
    .filter('abestado', function() {
      return function(input,muito) {
        
        var str = input || ''
        if (input) {
          str += ' é abestado';
          if(muito){
            str += ' de cum força'
          }
        }
        return str;
      };
    });

  
})();