package com.gabrielfeitosa.pedidos.service;

import java.util.Random;

import com.gabrielfeitosa.pedidos.bd.PedidosBD;
import com.gabrielfeitosa.pedidos.entity.PedidosMock;

/**
 * @author gabrielf 
 * 09/10/2015
 */
public class AtendimentoService {
	
	public static boolean atendimentoAberto = false;
	private static Random random = new Random();
	
	public static void alterarStatusDoAtendimento(boolean status){
		atendimentoAberto = status;
		run();
	}

	private static void run() {
		PedidosBD.zerarPedidos();
		new Thread() {
			@Override
			public void run() {
				while (atendimentoAberto) {
					PedidosBD.cadastrarPedido(PedidosMock.getPedido());
					try {
						Thread.sleep((random.nextInt(8)+1)*10000);
					} catch (InterruptedException e) {
						System.err.println("Ops, acabou a CACHAÇA!");
					}
				}
			}
		}.start();
	}
}
