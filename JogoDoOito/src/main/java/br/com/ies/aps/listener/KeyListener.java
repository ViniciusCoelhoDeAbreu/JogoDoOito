package br.com.ies.aps.listener;

import java.awt.event.KeyEvent;
import java.util.Arrays;

import br.com.ies.aps.manager.JogoManager;
import br.com.ies.aps.type.DirecaoType;

public class KeyListener implements java.awt.event.KeyListener {
	
	private JogoManager gameManager;

	public KeyListener(JogoManager gameManager) {
		this.gameManager = gameManager;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
		Arrays.stream(DirecaoType.values())
											.filter(direcao -> direcao.getNumeroTecla() == e.getKeyCode())
											.forEach(gameManager::move);
		
	}

}
