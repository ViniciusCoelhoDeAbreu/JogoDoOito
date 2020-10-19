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

import br.com.ies.aps.listener.GameListener;
import br.com.ies.aps.manager.GameManager;
import br.com.ies.aps.model.Casa;
import br.com.ies.aps.model.Jogo;
import br.com.ies.aps.type.EventoType;
import br.com.ies.aps.util.Constants;

public class FrameJogoOito extends JFrame implements GameListener {

	private static final long serialVersionUID = 1L;

	private JPanel conteudoPainelJogo;
	private Map<Integer, JTextPane> mapPanel;

	@Override
	public void onEvento(EventoType tipoEvento, GameManager gameManager) {
		switch(tipoEvento) {
		case MOVER:
			alteraCampos(gameManager.getJogo());
			break;
		case VENCER:
			JOptionPane.showMessageDialog(null, "Você venceu o jogo!");
			break;
		}

	}

	public FrameJogoOito() {
		this.mapPanel = new HashMap<Integer, JTextPane>();

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

		JTextPane painel1 = new JTextPane();
		painel1.setFont(new Font("Arial Black", Font.BOLD, 50));
		painel1.setEnabled(false);
		painel1.setEditable(false);
		painel1.setBounds(0, 0, 220, 118);
		panelJogoOito.add(painel1);

		JTextPane painel3 = new JTextPane();
		painel3.setFont(new Font("Arial Black", Font.BOLD, 50));
		painel3.setEditable(false);
		painel3.setEnabled(false);
		painel3.setBounds(474, 0, 220, 118);
		panelJogoOito.add(painel3);

		JTextPane painel2 = new JTextPane();
		painel2.setFont(new Font("Arial Black", Font.BOLD, 50));
		painel2.setEnabled(false);
		painel2.setEditable(false);
		painel2.setBounds(230, 0, 234, 118);
		panelJogoOito.add(painel2);

		JTextPane painel4 = new JTextPane();
		painel4.setFont(new Font("Arial Black", Font.BOLD, 50));
		painel4.setEnabled(false);
		painel4.setEditable(false);
		painel4.setBounds(0, 129, 220, 118);
		panelJogoOito.add(painel4);

		JTextPane painel5 = new JTextPane();
		painel5.setFont(new Font("Arial Black", Font.BOLD, 50));
		painel5.setEditable(false);
		painel5.setEnabled(false);
		painel5.setBounds(230, 129, 234, 118);
		panelJogoOito.add(painel5);

		JTextPane painel6 = new JTextPane();
		painel6.setFont(new Font("Arial Black", Font.BOLD, 50));
		painel6.setEnabled(false);
		painel6.setEditable(false);
		painel6.setBounds(474, 129, 220, 118);
		panelJogoOito.add(painel6);

		JTextPane painel7 = new JTextPane();
		painel7.setFont(new Font("Arial Black", Font.BOLD, 50));
		painel7.setEditable(false);
		painel7.setEnabled(false);
		painel7.setBounds(0, 258, 220, 118);
		panelJogoOito.add(painel7);

		JTextPane painel8 = new JTextPane();
		painel8.setFont(new Font("Arial Black", Font.BOLD, 50));
		painel8.setEnabled(false);
		painel8.setEditable(false);
		painel8.setBounds(230, 258, 234, 118);
		panelJogoOito.add(painel8);

		JTextPane painel9 = new JTextPane();
		painel9.setFont(new Font("Arial Black", Font.BOLD, 50));
		painel9.setEditable(false);
		painel9.setEnabled(false);
		painel9.setBounds(474, 258, 220, 118);
		panelJogoOito.add(painel9);


		mapPanel.put(0, painel1);
		mapPanel.put(1, painel2);
		mapPanel.put(2, painel3);
		mapPanel.put(3, painel4);
		mapPanel.put(4, painel5);
		mapPanel.put(5, painel6);
		mapPanel.put(6, painel7);
		mapPanel.put(7, painel8);
		mapPanel.put(8, painel9);

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
