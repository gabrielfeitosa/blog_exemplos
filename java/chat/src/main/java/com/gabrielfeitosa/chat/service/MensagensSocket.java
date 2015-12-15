package com.gabrielfeitosa.chat.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/mensagens", configurator = MensagensEndPointConfigurator.class)
public class MensagensSocket {

	private Set<Session> userSessions = Collections.synchronizedSet(new HashSet<Session>());

	@OnOpen
	public void onOpen(Session userSession) {
		userSessions.add(userSession);
	}

	@OnClose
	public void onClose(Session userSession) {
		userSessions.remove(userSession);
	}

	@OnMessage
	public void onMessage(String message, Session userSession) {
		System.out.println("Message Received: " + message);
		for (Session session : userSessions) {
			System.out.println("Sending to " + session.getId());
			session.getAsyncRemote().sendText(message);
		}
	}
}
