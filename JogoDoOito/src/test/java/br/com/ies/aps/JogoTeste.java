package br.com.ies.aps;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.com.ies.aps.manager.JogoManager;
import br.com.ies.aps.model.Jogo;
import br.com.ies.aps.type.DirecaoType;
import br.com.ies.aps.type.TipoOrdenacaoType;
import br.com.ies.aps.util.JogoUtil;

public class JogoTeste {

	private JogoManager jogoManager;
	
	public JogoTeste() {
		jogoManager = new JogoManager();
	}
	
	@Before
	public void init() {
		jogoManager.embaralhaCasas(TipoOrdenacaoType.TESTE);
	}
	
	
	@Test
	public void testaMoverEsquerda() {
		Jogo jogoAntigo = jogoManager.getJogo().clone();
		
		jogoManager.move(DirecaoType.ESQUERDA);
		
		assertEquals(DirecaoType.ESQUERDA, JogoUtil.calculaDirecaoMovimentacao(jogoManager.getJogo(), jogoAntigo));
	}
	
	@Test
	public void testaMoverDireita() {
		Jogo jogoAntigo = jogoManager.getJogo().clone();
		
		jogoManager.move(DirecaoType.DIREITA);
		
		assertEquals(DirecaoType.DIREITA, JogoUtil.calculaDirecaoMovimentacao(jogoManager.getJogo(), jogoAntigo));
	}
	
	@Test
	public void testaMoverCima() {
		Jogo jogoAntigo = jogoManager.getJogo().clone();
		
		jogoManager.move(DirecaoType.CIMA);
		
		assertEquals(DirecaoType.CIMA, JogoUtil.calculaDirecaoMovimentacao(jogoManager.getJogo(), jogoAntigo));
	}
	
	@Test
	public void testaMoverBaixo() {
		Jogo jogoAntigo = jogoManager.getJogo().clone();
		
		jogoManager.move(DirecaoType.BAIXO);
		
		assertEquals(DirecaoType.BAIXO, JogoUtil.calculaDirecaoMovimentacao(jogoManager.getJogo(), jogoAntigo));
	}
	
	
}
