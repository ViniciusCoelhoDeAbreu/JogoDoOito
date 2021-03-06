package br.com.ies.aps.type;

public enum DirecaoType {

	ESQUERDA(0,-1, 37), CIMA(-1,0, 38), DIREITA(0,1, 39),  BAIXO(1,0, 40);
	
	private Integer linha;
	private Integer coluna;
	private Integer numeroTecla;
	
	private DirecaoType(Integer linha, Integer coluna, Integer numeroTecla) {
		this.linha = linha;
		this.coluna = coluna;
		this.numeroTecla = numeroTecla;
	}
	
	public Integer getLinha() {
		return linha;
	}
	public Integer getColuna() {
		return coluna;
	}
	public Integer getNumeroTecla() {
		return numeroTecla;
	}
	
}
