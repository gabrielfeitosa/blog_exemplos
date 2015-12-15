package com.gabrielfeitosa.chat.service;

import javax.websocket.server.ServerEndpointConfig.Configurator;

public class MensagensEndPointConfigurator extends Configurator{

	private static MensagensSocket mensagensSocket = new MensagensSocket();
	
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getEndpointInstance(Class<T> clazz) throws InstantiationException {
		return (T)mensagensSocket;
	}
}
