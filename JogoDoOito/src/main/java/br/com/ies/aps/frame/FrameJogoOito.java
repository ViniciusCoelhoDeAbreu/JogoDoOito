package br.com.ies.aps.frame;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import br.com.ies.aps.listener.JogoListener;
import br.com.ies.aps.manager.JogoManager;
import br.com.ies.aps.model.Casa;
import br.com.ies.aps.model.Jogo;
import br.com.ies.aps.model.PanelCoordenada;
import br.com.ies.aps.type.EventoType;
import br.com.ies.aps.util.Constants;

public class FrameJogoOito extends JFrame implements JogoListener {

	private static final long serialVersionUID = 1L;

	private JPanel conteudoPainelJogo;
	private Map<Integer, JTextPane> mapPanel;
	private PanelCoordenada[] panelCoordenada;

	@Override
	public void onEvento(EventoType tipoEvento, JogoManager jogoManager) {
		switch(tipoEvento) {
		case MOVER:
			alteraCampos(jogoManager.getJogo());
			break;
		case VENCER:
			JOptionPane.showMessageDialog(null, "Você venceu o jogo!");
			break;
		}

	}

	public FrameJogoOito() {
		this.mapPanel = new HashMap<Integer, JTextPane>();
		this.panelCoordenada = new PanelCoordenada[]{
								new PanelCoordenada(0, 0, 220, 118),
								new PanelCoordenada(230, 0, 234, 118),
								new PanelCoordenada(474, 0, 220, 118),
								new PanelCoordenada(0, 129, 220, 118),
								new PanelCoordenada(230, 129, 234, 118),
								new PanelCoordenada(474, 129, 220, 118),
								new PanelCoordenada(0, 258, 220, 118),
								new PanelCoordenada(230, 258, 234, 118),
								new PanelCoordenada(474, 258, 220, 118)
													};

		setVisible(true);
		setOpacity(1.0f);
		setTitle("Jogo Oito");
		setForeground(Color.BLUE);
		setBackground(Color.BLUE);
		setAlwaysOnTop(false);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 405);
		conteudoPainelJogo = new JPanel();
		conteudoPainelJogo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(conteudoPainelJogo);
		conteudoPainelJogo.setLayout(null);
		
		JPanel panelJogoOito = new JPanel();
		panelJogoOito.setBackground(Color.BLUE);
		panelJogoOito.setBounds(0, 0, 694, 379);
		conteudoPainelJogo.add(panelJogoOito);
		panelJogoOito.setLayout(null);

		for(int i = 0; i <= 8; i++) {
			JTextPane panel = build(panelCoordenada[i].getX(), panelCoordenada[i].getY(), panelCoordenada[i].getWidth(), panelCoordenada[i].getHeight());

			mapPanel.put(i, panel);
			panelJogoOito.add(panel);
			
		}

	}
	
	private JTextPane build(int x, int y, int width, int height) {
		JTextPane painel = new JTextPane();
		painel.setFont(new Font("Arial Black", Font.BOLD, 50));
		painel.setEditable(false);
		painel.setEnabled(false);
		painel.setBounds(x, y, width, height);
		return painel;
	}
	

	public void alteraCampos(Jogo jogo) {
		int index = 0;

		for (int l = 0; l < Constants.TAMANHO_MATRIZ_JOGO; l++) {
			for (int c = 0; c < Constants.TAMANHO_MATRIZ_JOGO; c++) {
				Integer valor = jogo.retornaValor(new Casa(l, c));

				mapPanel.get(index).setText(valor == 0 ? new String() : Integer.toString(valor));

				index++;
			}
		}
	}

}
