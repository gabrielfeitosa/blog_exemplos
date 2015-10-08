package com.gabrielfeitosa.pedidos;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/balcao")
public class BalcaoService {

	private static boolean atendimentoAberto = false;

	@POST
	@Path("/atendimento")
	@Consumes("application/json")
	public void statusAtendimento(Boolean status) {
		atendimentoAberto = status;
		mockarCadastroPedidos();
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
	
	private void mockarCadastroPedidos() {
		PedidosBD.zerarPedidos();
		new Thread() {
			@Override
			public void run() {
				while (atendimentoAberto) {
					cadastrarPedido(new Pedido("Item"));
					try {
						Thread.sleep((int)(Math.random()*10000));
					} catch (InterruptedException e) {
						System.err.println("Ops, acabou a CACHAÇA!");
					}
				}
			}
		}.start();
	}

}
