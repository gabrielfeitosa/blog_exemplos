(function() {

  angular.module("app", ["luegg.directives", "app.focus"]);

  angular.module("app")
    .factory("ChatFactory", function($http, $timeout) {
      var promise;
      var URL = "http://gf-chat.herokuapp.com/rest/mensagens/";
      var mensagens = [];
      var aberto = false;
      var contador = 5;

      return {
        entrar: entrar,
        listar: listar,
        cadastrar: cadastrar,
        isAberto: isAberto,
        sair: sair,
        getContador: getContador
      };

      function entrar() {
        aberto = true;
        periodicRefresh()
      }

      function periodicRefresh() {
        contador--;
        if (contador === 0) {
          atualizar();
          contador = 5;
        }
        promise = $timeout(periodicRefresh, 1000);
      }

      function sair() {
        $timeout.cancel(promise);
        aberto = false;
      }

      function atualizar() {
        $http.get(URL)
          .success(function(data) {
            mensagens = data;
          });
      }

      function cadastrar(usuario, texto) {
        var msg = {
          usuario: usuario,
          texto: texto
        }
        $http.post(URL, msg);
      }

      function getContador() {
        return contador;
      }

      function isAberto() {
        return aberto;
      }

      function listar() {
        return mensagens;
      }
    });


  angular.module("app")
    .controller("ChatController", function($scope, ChatFactory) {
      $scope.chat = ChatFactory;
      $scope.usuario = {
        nome: ""
      };
    });
})();
