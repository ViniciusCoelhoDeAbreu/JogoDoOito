package br.com.ies.aps.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.SerializationUtils;

public class Jogo implements Cloneable, Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Map<Integer, Casa> mapCasas;

	public Jogo() {
		mapCasas = new HashMap<Integer, Casa>();
	}
	public Jogo(byte[] jogoEstado) {
		this.mapCasas = ((Jogo) SerializationUtils.deserialize(jogoEstado)).getMapCasas();
	}
	
	public void adicionaCasa(Integer valor, Casa casa) {
		mapCasas.put(valor, casa);
	}
	
	public Casa retornaCasa(Casa casa) {
		
		return mapCasas.values()
								.stream()
								.filter(c -> c.equals(casa))
								.findFirst()
								.get();
	}
	
	public Integer retornaValor(Casa casa) {
		return mapCasas.entrySet()
								.stream()
								.filter(c -> c.getValue().equals(casa))
								.findFirst()
								.get()
								.getKey();
									
	}
	
	public Casa retornaCasa(Integer valor) {
		return mapCasas.get(valor);
	}
	
	
	public Map<Integer, Casa> getMapCasas() {
		return mapCasas;
	}
	
	@Override
	public Jogo clone() {
		try {
			Jogo jogoClone = (Jogo)super.clone();
			jogoClone.mapCasas = this.mapCasas.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().clone()));
			return jogoClone;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
