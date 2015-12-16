(function() {
  'use strict';

   angular.module('app')
    .factory('ChatFactory', function() {
      var socket = io.connect('http://localhost:5000');
      var aberto = false;

      return {
        entrar: entrar,
        cadastrar: cadastrar,
        isAberto: isAberto,
        sair: sair
      };

      function entrar(usuario,callBack) {
        aberto = true;
        socket.emit('chat entrar', usuario);
        socket.on('chat mensagem', callBack);
      }

      function sair() {
        aberto = false;
      }

      function cadastrar(texto) {
        socket.emit('chat mensagem', texto);
        
      }

      function isAberto() {
        return aberto;
      }
    });
})();