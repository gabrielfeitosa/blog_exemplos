package com.gabrielfeitosa.pedidos.bd;

import java.util.LinkedList;
import java.util.List;

import com.gabrielfeitosa.pedidos.entity.Pedido;

public class PedidosBD {

	private static List<Pedido> pedidos = new LinkedList<Pedido>();
	private static int index = 0;
	
	public static void cadastrarPedido(Pedido pedido){
		pedido.setId(index);
		pedido.setItem(pedido.getItem()+" "+index);
		index++;
		pedidos.add(pedido);
	}
	
	public static List<Pedido> getPedidos(){
		return pedidos;
	}
	
	public static void remover(Integer id) {
		pedidos.remove(new Pedido(id));
		
	}

	public static void zerarPedidos() {
		pedidos.clear();		
		index = 0;
	}
}
