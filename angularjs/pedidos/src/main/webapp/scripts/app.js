(function(){
	angular.module("lanchonete",[]);
	
	angular.module("lanchonete").service("LanchoneteService",function($http,$timeout){
		var promise;
		var self = {
			'aberta': false,
			'pedidos': [],
			'abrir': function(){
				$http.post("rest/lanchonete/abrir",{});
				self.aberta = true;
				self.activateRealtime();
			},
			'fechar': function(){
				self.aberta = false;
				$timeout.cancel(promise);
			},
			'activateRealtime': function(){
				$http.get("rest/lanchonete/pedidos")
	            .success(function(data) {
	              self.pedidos = data;
	           });
		       promise = $timeout(self.activateRealtime, 3000);
		    },
		    'getPedidos': function(){	
			    return self.pedidos;
			},
			'atenderPedido': function(id){
				$http.delete("rest/lanchonete/pedidos/"+id);
			}
			 
		}
		return self;
	});
	
	angular.module("lanchonete").controller("LanchoneteController",function(LanchoneteService){
		var self = this;
		self.isAberta = function(){
			return LanchoneteService.aberta;
		}
		self.abrir = LanchoneteService.abrir;
		self.fechar = LanchoneteService.fechar;
	});
	
	angular.module("lanchonete").controller("AtendimentoController",function(LanchoneteService){
		var self = this;
		self.getPedidos = LanchoneteService.getPedidos;
		self.atenderPedido = LanchoneteService.atenderPedido;
	});
})();
