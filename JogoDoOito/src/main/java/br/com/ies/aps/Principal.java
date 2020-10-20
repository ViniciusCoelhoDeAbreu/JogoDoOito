package br.com.ies.aps;

import java.awt.EventQueue;

import br.com.ies.aps.frame.FrameJogoOito;
import br.com.ies.aps.listener.KeyListener;
import br.com.ies.aps.manager.JogoManager;
import br.com.ies.aps.type.TipoOrdenacaoType;
import br.com.ies.aps.util.ListenerUtil;

public class Principal {

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameJogoOito frame = new FrameJogoOito();
					JogoManager gameManager = new JogoManager();
					
					ListenerUtil.adicionaListener(frame);
					
					gameManager.embaralhaCasas(TipoOrdenacaoType.EMBARALHAR);
					frame.addKeyListener(new KeyListener(gameManager));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
}
