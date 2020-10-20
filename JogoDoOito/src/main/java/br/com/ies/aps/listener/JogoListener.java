package br.com.ies.aps.listener;

import br.com.ies.aps.manager.JogoManager;
import br.com.ies.aps.type.EventoType;

public interface JogoListener {

	void onEvento(EventoType tipoEvento, JogoManager jogoManager);
	
}
