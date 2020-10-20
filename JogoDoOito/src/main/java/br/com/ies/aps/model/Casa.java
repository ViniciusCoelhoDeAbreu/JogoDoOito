package br.com.ies.aps.model;

public class Casa implements Cloneable{

	private Integer linha;
	private Integer coluna;

	public Casa(Integer linha, Integer coluna) {
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public Integer getLinha() {
		return linha;
	}

	public Casa setLinha(Integer linha) {
		this.linha = linha;
		return this;
	}

	public Integer getColuna() {
		return coluna;
	}

	public Casa setColuna(Integer coluna) {
		this.coluna = coluna;
		return this;
	}
	
	@Override
	public String toString() {
		return "Casa [linha=" + linha + ", coluna=" + coluna + "]";
	}
	@Override
	public boolean equals(Object obj) {
		return ((Casa)obj).getColuna() == this.getColuna() 
				&&	((Casa)obj).getLinha() == this.getLinha();
	}
	@Override
	public Casa clone() {
		try {
			return (Casa) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

}
