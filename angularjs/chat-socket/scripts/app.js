(function() {
	'use strict';

	angular.module('app', ['luegg.directives', 'app.focus']);

	angular.module('app')
		.controller('ChatController', function($scope, ChatFactory) {
			$scope.chat = ChatFactory;
			$scope.mensagens = [];
			$scope.usuario = {
				nome: ''
			};

			$scope.atualizar = function(msg) {
				console.log('atualizando mensagem ' + msg);
				$scope.mensagens.push(msg);
				$scope.$apply();
			};
		});
})();