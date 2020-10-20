package br.com.ies.aps.util;

import br.com.ies.aps.model.Casa;
import br.com.ies.aps.model.Jogo;
import br.com.ies.aps.type.DirecaoType;

public class JogoUtil {

	public static DirecaoType calculaDirecaoMovimentacao(Jogo jogoAtual, Jogo jogoAntigo) {
			Casa casaAntigo = jogoAntigo.retornaCasa(0);
			Casa casaAtual = jogoAtual.retornaCasa(0);

			if(casaAntigo.getColuna() != casaAtual.getColuna()) 
				return casaAntigo.getColuna() > casaAtual.getColuna() ? DirecaoType.ESQUERDA : DirecaoType.DIREITA;
			
			if(casaAntigo.getLinha() != casaAtual.getLinha())
				return casaAntigo.getLinha() > casaAtual.getLinha() ? DirecaoType.CIMA : DirecaoType.BAIXO;
		
		return null;
	}

}
