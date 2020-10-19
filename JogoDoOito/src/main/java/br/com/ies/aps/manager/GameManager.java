package br.com.ies.aps.manager;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import br.com.ies.aps.model.Casa;
import br.com.ies.aps.model.Jogo;
import br.com.ies.aps.type.DirecaoType;
import br.com.ies.aps.type.EventoType;
import br.com.ies.aps.util.Constants;
import br.com.ies.aps.util.ListenerUtil;

public class GameManager {

	private GameDaoManager gameDaoManager;
	
	private Jogo jogo;

	public GameManager() {
		this.gameDaoManager = new GameDaoManager();
		this.jogo = new Jogo();
	}
	
	public Jogo getJogo() {
		return jogo;
	}

	public void embaralhaCasas() {
		List<Integer> listaCasas  = IntStream.range(0, (int) Math.pow(Constants.TAMANHO_MATRIZ_JOGO, 2))
											 .boxed()
											 .collect(Collectors.toList());

		for(int x = 0; x < Constants.TAMANHO_MATRIZ_JOGO; x++) {
			for(int y = 0; y < Constants.TAMANHO_MATRIZ_JOGO; y++) {

				Integer numeroRandomico = listaCasas.get(new Random().nextInt(listaCasas.size()));
				jogo.adicionaCasa(numeroRandomico, new Casa(x, y));
				listaCasas.remove(numeroRandomico);
				
			}
		}
		
		ListenerUtil.notificaListener(EventoType.MOVER, this);
		
	}

	public void move(DirecaoType direcao) {
		try {
			Casa casaZero = jogo.retornaCasa(0);

			jogo.retornaCasa(new Casa(casaZero.getLinha() - (direcao.getLinha() * - 1), casaZero.getColuna() - (direcao.getColuna() * - 1) ))
							.setLinha(casaZero.getLinha())
							.setColuna(casaZero.getColuna());

			casaZero.setLinha(casaZero.getLinha() + direcao.getLinha())
					.setColuna(casaZero.getColuna() + direcao.getColuna());

			Boolean fimJogo = verificaFimJogo();
			
			gameDaoManager.salvaJogada(jogo, fimJogo);
			ListenerUtil.notificaListener(EventoType.MOVER, this);
			
			if(fimJogo) {
				ListenerUtil.notificaListener(EventoType.VENCER, this);
				embaralhaCasas();
			}
			
		}catch(NoSuchElementException e) {
		}
	}
	
	public boolean verificaFimJogo() {
		
		if(jogo.retornaValor(new Casa(Constants.TAMANHO_MATRIZ_JOGO - 1, Constants.TAMANHO_MATRIZ_JOGO - 1)) != 0)
			return false;
		
		int index = 1;
		
		for(int l = 0; l < Constants.TAMANHO_MATRIZ_JOGO; l++) {
			for(int c = 0; c < Constants.TAMANHO_MATRIZ_JOGO; c++) {
				
					if (jogo.retornaValor(new Casa(l, c))  != index && jogo.retornaValor(new Casa(l, c)) != 0) return false;
				
				index++;
			}
		}
		
		return true;
		
	}


}
