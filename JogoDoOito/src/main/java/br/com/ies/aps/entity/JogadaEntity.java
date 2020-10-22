package br.com.ies.aps.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "jogada", schema = "public")
public class JogadaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "jogada_id")
	private Integer jogadaId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data")
	private Date data;

	@Column(name = "venceu")
	private Boolean venceu;
	
	@Column(name = "estado")
	private byte[] estado;

	public JogadaEntity() {
	}

	public JogadaEntity(Date data, Boolean venceu) {
		this.data = data;
		this.venceu = venceu;
	}
	public JogadaEntity(Date data, Boolean venceu, byte[] estado) {
		this.data = data;
		this.venceu = venceu;
		this.estado = estado;
	}

	public Integer getJogadaId() {
		return jogadaId;
	}



	public void setJogadaId(Integer jogadaId) {
		this.jogadaId = jogadaId;
	}


	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Boolean getVenceu() {
		return venceu;
	}

	public void setVenceu(Boolean venceu) {
		this.venceu = venceu;
	}
	public byte[] getEstado() {
		return estado;
	}
	public void setEstado(byte[] estado) {
		this.estado = estado;
	}

	

}
