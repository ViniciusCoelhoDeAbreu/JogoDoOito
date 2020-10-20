package br.com.ies.aps.util;

import java.util.ArrayList;
import java.util.List;

import br.com.ies.aps.listener.JogoListener;
import br.com.ies.aps.manager.JogoManager;
import br.com.ies.aps.type.EventoType;

public class ListenerUtil {

	private static List<JogoListener> listeners;
	
	static {
		listeners = new ArrayList<JogoListener>();
	}
	
	public static void adicionaListener(JogoListener gameListener) {
		listeners.add(gameListener);
	}
	
	public static void notificaListener(EventoType tipoEvento, JogoManager gameManager) {
		listeners.forEach(listener -> listener.onEvento(tipoEvento, gameManager));
	}
	
}
