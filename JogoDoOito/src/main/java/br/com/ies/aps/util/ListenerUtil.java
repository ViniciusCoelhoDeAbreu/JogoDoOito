package br.com.ies.aps.util;

import java.util.ArrayList;
import java.util.List;

import br.com.ies.aps.listener.GameListener;
import br.com.ies.aps.manager.GameManager;
import br.com.ies.aps.type.EventoType;

public class ListenerUtil {

	private static List<GameListener> listeners;
	
		
	static {
		listeners = new ArrayList<GameListener>();
	}
	
	public static void adicionaListener(GameListener gameListener) {
		listeners.add(gameListener);
	}
	
	public static void notificaListener(EventoType tipoEvento, GameManager gameManager) {
		listeners.forEach(listener -> listener.onEvento(tipoEvento, gameManager));
	}
	
}
