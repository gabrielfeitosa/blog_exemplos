package com.gabrielfeitosa.chat.dtos;

import java.util.Calendar;


public class Mensagem {
	
	private String usuario;
	private String texto;
	private Calendar dataRegistro;
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Calendar getDataRegistro() {
		return dataRegistro;
	}
	public void setDataRegistro(Calendar dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

}
