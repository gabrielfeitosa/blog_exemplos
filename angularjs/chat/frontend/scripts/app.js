(function() {
    
    angular.module("app", ["luegg.directives","app.focus"]);

    angular.module("app")
        .factory("MensagemFactory", function($http, $timeout) {
            var promise;
            var URL = "http://gf-chat.herokuapp.com/rest/mensagens/";
            var mensagens = [];
            var aberto = false;
            var contador = 5;
            return {
                abrir: abrir,
                listar: listar,
                cadastrar: cadastrar,
                isAberto: isAberto,
                sair: sair,
                getContador:getContador
            };

            function getContador(){
              return contador;
            }

            function isAberto() {
                return aberto;
            }

            function listar() {
                return mensagens;
            }

            function abrir() {
                aberto = true;
                init();
            }

            function atualizar() {
                $http.get(URL)
                    .success(function(data) {
                        mensagens = data;
                    });
            }

            function init(){
                contador--;
                if(contador === 0){
                  atualizar();
                  contador =5;
                }
                promise = $timeout(init, 1000); 
            }
            function cadastrar(usuario, texto) {
                var msg = {
                    usuario: usuario,
                    texto: texto
                }
                $http.post(URL, msg);
            }

            function sair() {
                $timeout.cancel(promise);
                aberto = false;
            }
        });


    angular.module("app")
        .controller("ChatController", function($scope, MensagemFactory) {
            $scope.mensagens = MensagemFactory;
            $scope.usuario = {
                nome: ""
            };
        });
})();