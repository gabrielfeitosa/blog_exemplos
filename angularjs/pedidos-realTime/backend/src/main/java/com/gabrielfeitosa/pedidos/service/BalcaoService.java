package com.gabrielfeitosa.pedidos.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.gabrielfeitosa.pedidos.bd.PedidosBD;
import com.gabrielfeitosa.pedidos.entity.Pedido;

@Path("/balcao")
public class BalcaoService {

	@POST
	@Path("/atendimento")
	@Consumes("application/json")
	public void statusAtendimento(Boolean status) {
		AtendimentoService.alterarStatusDoAtendimento(status);
	}
	
	@GET
	@Path("/pedidos")
	@Produces("application/json")
	public List<Pedido> getPedidos() {
		return PedidosBD.getPedidos();
	}

	@DELETE
	@Path("/pedidos/{id}")
	public void atenderPedido(@PathParam("id") Integer id) {
		PedidosBD.remover(id);
	}
	
	@POST
	@Path("/pedidos")
	public void cadastrarPedido(Pedido pedido){
		PedidosBD.cadastrarPedido(pedido);		
	}
}
