package com.gabrielfeitosa.pedidos.entity;

import java.io.Serializable;

import com.gabrielfeitosa.pedidos.util.StatusPedido;

public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String item;
	private StatusPedido status;
	
	public Pedido(String item) {
		super();
		this.item = item;
		status = StatusPedido.AGUARDANDO_ATENDIMENTO;
	}
	
	public Pedido(Integer id) {
		super();
		this.id = id;
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
	
	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
