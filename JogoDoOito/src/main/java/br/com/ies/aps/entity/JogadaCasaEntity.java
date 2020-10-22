package br.com.ies.aps.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "jogada_casa", schema = "public")
public class JogadaCasaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jogada_casa_id")
	private Integer jogadaCasaId;
	
	@ManyToOne
	@JoinColumn(name = "jogada_id")
	private JogadaEntity jogada;
	
	@Column(name = "casa")
	private String casa;
	
	@Column(name = "linha")
	private Integer linha;
	
	@Column(name = "coluna")
	private Integer coluna;
	

	public JogadaCasaEntity() {
	}
	
	public JogadaCasaEntity( JogadaEntity jogada, String casa, Integer linha, Integer coluna) {
		this.jogada = jogada;
		this.casa = casa;
		this.linha = linha;
		this.coluna = coluna;
	}

	public Integer getJogadaCasaId() {
		return jogadaCasaId;
	}

	public void setJogadaCasaId(Integer jogadaCasaId) {
		this.jogadaCasaId = jogadaCasaId;
	}

	public JogadaEntity getJogada() {
		return jogada;
	}

	public void setJogada(JogadaEntity jogada) {
		this.jogada = jogada;
	}

	public String getCasa() {
		return casa;
	}

	public void setCasa(String casa) {
		this.casa = casa;
	}

	public Integer getLinha() {
		return linha;
	}

	public void setLinha(Integer linha) {
		this.linha = linha;
	}

	public Integer getColuna() {
		return coluna;
	}

	public void setColuna(Integer coluna) {
		this.coluna = coluna;
	}
	
	
	
}
