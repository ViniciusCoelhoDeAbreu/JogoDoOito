package br.com.ies.aps.manager;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import br.com.ies.aps.dao.JogadaCasaDao;
import br.com.ies.aps.dao.JogadaDao;
import br.com.ies.aps.entity.JogadaCasaEntity;
import br.com.ies.aps.entity.JogadaEntity;
import br.com.ies.aps.model.Jogo;

public class JogoDaoManager {

	private ExecutorService executors;
	
	private JogadaDao jogadaDao;
	private JogadaCasaDao jogadaCasaDao;
	
	public JogoDaoManager() {
		this.jogadaDao = new JogadaDao();
		this.jogadaCasaDao = new JogadaCasaDao();
		this.executors = Executors.newFixedThreadPool(2);
	}
	
	public void salvaJogada(Jogo jogo, Boolean venceu) {
		executors.execute(() -> {
			JogadaEntity jogada = jogadaDao.salvaJogada(new JogadaEntity(new Date(), venceu));
			jogo.getMapCasas().entrySet().forEach(entrySet -> salvaJogadaCasa(jogada, entrySet.getKey().toString(), entrySet.getValue().getLinha(), entrySet.getValue().getColuna()));
		});
	}
	
	private void salvaJogadaCasa(JogadaEntity jogada, String casa, Integer linha, Integer coluna) {
		jogadaCasaDao.salvaJogadaCasa(new JogadaCasaEntity(jogada, casa, linha, coluna));
	}
	
}
