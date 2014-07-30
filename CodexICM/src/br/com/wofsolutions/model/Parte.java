package br.com.wofsolutions.model;

import java.util.ArrayList;
import java.util.List;


public class Parte {
	
	
	private Integer parteId;
	
	private String descricao;
	
	private Livro livro;
	
	
	private List<Capitulo> capitulos = new ArrayList<Capitulo>();
	
	
	private List<Seccao> seccaos = new ArrayList<Seccao>();
	
	
		
	private List<Canone> canones = new ArrayList<Canone>();

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	public Integer getParteId() {
		return parteId;
	}
	public void setParteId(Integer parteId) {
		this.parteId = parteId;
	}
	public List<Capitulo> getCapitulos() {
		return capitulos;
	}
	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}
	public List<Seccao> getSeccaos() {
		return seccaos;
	}
	public void setSeccaos(List<Seccao> seccaos) {
		this.seccaos = seccaos;
	}
	public List<Canone> getCanones() {
		return canones;
	}
	public void setCanones(List<Canone> canones) {
		this.canones = canones;
	}
	
	
}
