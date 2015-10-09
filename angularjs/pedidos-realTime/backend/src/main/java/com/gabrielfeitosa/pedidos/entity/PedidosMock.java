package com.gabrielfeitosa.pedidos.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author gabrielf 
 * 09/10/2015
 */
public class PedidosMock {

	private static List<String> pedidos = new ArrayList<String>();
	private static Random ran = new Random();
	
	static {
		pedidos.add("Vale Verde 12 Anos");
		pedidos.add("Magnífica Soleira");
		pedidos.add("Boazinha");
		pedidos.add("Reserva do Gerente");
		pedidos.add("Anísio Santiago/Havana");
		pedidos.add("Leblon Signature");
		pedidos.add("Companheira Extra Premium");
		pedidos.add("Germana Heritage");
		pedidos.add("Weber Haus/ Carvalho e Cabriúva");
		pedidos.add("Canarinha");
		pedidos.add("Nega Fulô");
		pedidos.add("Salineira");
		pedidos.add("Casa Bucco 6 Anos");
		pedidos.add("Porto Morretes Ouro");
		pedidos.add("Ypióca Ouro Res. Especial");
		pedidos.add("Weber Haus Lote 48");
		pedidos.add("Salinas Carvalho");
		pedidos.add("Seleta");
		pedidos.add("Canabella");
		pedidos.add("Bento Albino");
		pedidos.add("Vale Verde");
		pedidos.add("Dona Beja");
		pedidos.add("Da Quinta Umburana");
		pedidos.add("Tabaroa");
		pedidos.add("Rainha do Vale ");
		pedidos.add("Germana");
		pedidos.add("Santo Grau Cel. Xavier Chaves");
		pedidos.add("Sinhá Brasil ");
		pedidos.add("Weber Haus Umburana");
		pedidos.add("Velha Januária");
		pedidos.add("Providência");
		pedidos.add("Cambraia");
		pedidos.add("Meia Lua");
		pedidos.add("Rochinha Cerejeira");
		pedidos.add("Werneck Ouro");
		pedidos.add("Tabua Bálsamo");
		pedidos.add("Piragibana");
		pedidos.add("Pedra Branca ");
		pedidos.add("Indaiazinha");
		pedidos.add("Leblon Prata");
		pedidos.add("BeijaFlor ");
		pedidos.add("Minha Deusa");
		pedidos.add("Áurea Custódio");
		pedidos.add("Ferreira Januária");
		pedidos.add("Espírito de Minas");
		pedidos.add("Da Quinta – Pura");
		pedidos.add("Coqueiro Prata");
		pedidos.add("Maria Izabel ");
		pedidos.add("Século XVIII");
		pedidos.add("Sapucaia Velha ");
	}

	public static Pedido getPedido() {
		return new Pedido(pedidos.get(ran.nextInt(pedidos.size())));
	}
}
