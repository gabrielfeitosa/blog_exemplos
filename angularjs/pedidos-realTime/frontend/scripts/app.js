(function() {
  angular.module("app", []);

  angular.module("app")
    .factory("BalcaoFactory", function($http, $timeout) {
      var promise;
      var aberto = false;
      var pedidos = [];
      var URL = "http://localhost:8080/pedidos/rest/balcao";

      return {
        isAberto: isAberto,
        getPedidos: getPedidos,
        iniciarAtendimento: iniciarAtendimento,
        encerrarAtendimento: encerrarAtendimento,
        atenderPedido: atenderPedido
      };

      function isAberto() {
        return aberto;
      }

      function getPedidos() {
        return pedidos;
      }

      function atualizarPedidos() {
        $http.get(URL+"/pedidos")
          .success(function(data) {
            pedidos = data;
          });
        promise = $timeout(atualizarPedidos, 3000);
      }

      function iniciarAtendimento() {
        pedidos = [];
        $http.post(URL+"/atendimento", true).success(function(){
          aberto = true;
          atualizarPedidos();
        });
      }

      function encerrarAtendimento() {
        aberto = false;
        pedidos = [];
        $http.post(URL+"/atendimento", false);
        $timeout.cancel(promise);
      }

      function atenderPedido(pedido) {
    	  pedido.emAtendimento = true;
        $http.delete(URL+"/pedidos/" + pedido.id);
      }
    });

  angular.module("app")
    .controller("BalcaoController", function(BalcaoFactory) {
      var self = this;
      self.fn = BalcaoFactory;
    });

})();
