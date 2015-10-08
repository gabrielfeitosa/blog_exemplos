package com.gabrielfeitosa.pedidos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PedidosBD {

	private static Map<Integer, Pedido> pedidos = new HashMap<Integer, Pedido>();
	private static int quantidadePedidosPorDia = 100;
	private static int index = 0;
	
	private static void add(Pedido pedido){
		System.out.println("Novo "+ pedido);
		pedidos.put(pedido.getId(),pedido);
		quantidadePedidosPorDia--;
	}
	
	private static boolean isHoraDeFechar() {
		return quantidadePedidosPorDia <1;
	}
	
	public static List<Pedido> getPedidos(){
		return new ArrayList<Pedido>(pedidos.values());
	}

	public static void iniciar() {
		new Thread(){
			@Override
			public void run() {
				while(!isHoraDeFechar()){
					add(new Pedido(index, "Item "+index++));
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						System.err.println("Ops, acabou a farinha!");
					}
				}
			}
		}.start();
	}

	public static void remover(Integer id) {
		pedidos.remove(id);
		
	}
}
