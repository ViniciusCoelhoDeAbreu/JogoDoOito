package br.com.ies.aps.listener;

import java.awt.event.KeyEvent;

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
		int teclaApertada = e.getKeyCode();

		switch(teclaApertada) {

		case 37:
			gameManager.move(DirecaoType.ESQUERDA);
			break;
		case 38:
			gameManager.move(DirecaoType.CIMA);
			break;
		case 39:
			gameManager.move(DirecaoType.DIREITA);
			break;
		case 40:
			gameManager.move(DirecaoType.BAIXO);
			break;
		}
		
	}

}
