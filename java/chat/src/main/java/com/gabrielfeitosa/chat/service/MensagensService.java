package com.gabrielfeitosa.chat.service;


import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.gabrielfeitosa.chat.dtos.Mensagem;

@Path("/mensagens")
public class MensagensService {

	private static LinkedList<Mensagem> mensagens = new LinkedList<Mensagem>();
	
	@POST
	@Consumes("application/json")
	public Response cadastrar(Mensagem m){
		m.setDataRegistro(Calendar.getInstance());
		mensagens.add(m);
		if(mensagens.size() >100){
			mensagens.pop();
		}
		return Response.status(Status.CREATED).build();
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
