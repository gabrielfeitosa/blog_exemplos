package com.gabrielfeitosa.chat;


import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/mensagens")
public class MensagensService {

	private static LinkedList<Mensagem> mensagens = new LinkedList<Mensagem>();
	
	@POST
	@Consumes("application/json")
	public void cadastrar(Mensagem m){
		m.setDataRegistro(Calendar.getInstance());
		mensagens.add(m);
		if(mensagens.size() >100){
			mensagens.pop();
		}
	}
	
	@GET
	@Produces("application/json")
	public List<Mensagem> getMensagens(){
		return mensagens;
	}
	
	@DELETE
	public void zerarMensagens(){
		mensagens.clear();
	}
	
}
