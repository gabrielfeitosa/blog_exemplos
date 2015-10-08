package com.gabrielfeitosa.pedidos;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/lanchonete")
public class LanchoneteService {
	
	private boolean atendimentoAberto = false;
	
	@POST
	@Path("/abrir")
	public void iniciarAtendimento(){
		if(!atendimentoAberto)
			PedidosBD.iniciar();
	}
	
	@GET
	@Path("/pedidos")
	@Produces("application/json")
	public List<Pedido> getPedidos() {
		return PedidosBD.getPedidos();
	}
	
	@DELETE
	@Path("/pedidos/{id}")
	public void atenderPedido(@PathParam("id") Integer id){
		PedidosBD.remover(id);
	}
}
