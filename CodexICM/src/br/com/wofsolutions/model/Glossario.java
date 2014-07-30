package br.com.wofsolutions.model;

import java.io.Serializable;


public class Glossario implements Serializable {

	
	
	private Integer glossarioId;
	
	private String palavra;
	
	
	private String significado="";

	public Integer getGlossarioId() {
		return glossarioId;
	}

	public void setGlossarioId(Integer glossarioId) {
		this.glossarioId = glossarioId;
	}

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public String getSignificado() {
		return significado;
	}

	public void setSignificado(String significado) {
		this.significado = significado;
	}
	
	
}
