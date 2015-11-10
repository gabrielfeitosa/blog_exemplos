(function() {
    angular.module("app", []);

    angular.module("app")
        .factory("MensagemFactory", function($http, $timeout) {
            var promise;
            var URL = "http://localhost:8080/chat/rest/mensagens/";
            var mensagens = [];
            var aberto = false;

            return {
                abrir: abrir,
                listar: listar,
                cadastrar: cadastrar,
                isAberto: isAberto,
                sair: sair
            };

            function isAberto() {
                return aberto;
            }

            function listar() {
                return mensagens;
            }

            function abrir(usuario) {
                aberto = true;
                atualizar(usuario);
            }

            function atualizar(usuario) {
                $http.get(URL)
                    .success(function(data) {
                        mensagens = data;
                    });
                promise = $timeout(atualizar, 3000, true, usuario);

            }

            function cadastrar(usuario, texto) {
                var msg = {
                    usuario: usuario,
                    texto: texto
                }
                $http.post(URL, msg);
            }

            function sair(){
              $timeout.cancel(promise);
              aberto = false;
            }
        });

    angular.module("app")
        .controller("ChatController", function($scope, MensagemFactory) {
            $scope.mensagens = MensagemFactory;
            $scope.usuario = {nome: ""};
        });

})();