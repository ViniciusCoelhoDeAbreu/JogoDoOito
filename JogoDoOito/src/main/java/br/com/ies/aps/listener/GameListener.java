package br.com.ies.aps.listener;

import br.com.ies.aps.manager.GameManager;
import br.com.ies.aps.type.EventoType;

public interface GameListener {

	void onEvento(EventoType tipoEvento, GameManager gameManager);
	
}
