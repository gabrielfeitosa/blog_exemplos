package com.gabrielfeitosa.pedidos;

import java.io.Serializable;

public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String item;
	
	public Pedido(Integer id, String item) {
		super();
		this.id = id;
		this.item = item;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", item=" + item + "]";
	}
	
}
