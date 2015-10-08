package com.gabrielfeitosa.pedidos;

import java.util.LinkedList;
import java.util.List;

public class PedidosBD {

	private static List<Pedido> pedidos = new LinkedList<Pedido>();

	public static void cadastrarPedido(Pedido pedido){
		System.out.println("Novo "+ pedido);
		pedidos.add(pedido);
	}
	
	public static List<Pedido> getPedidos(){
		return pedidos;
	}
	
	public static void remover(Integer id) {
		System.out.println("Removendo pedido "+ id);
		pedidos.remove(new Pedido(id,null));
		
	}

	public static void zerarPedidos() {
		pedidos = new LinkedList<Pedido>();		
	}
}