package br.com.wofsolutions.model;

import java.util.ArrayList;
import java.util.List;


public class Seccao {
	

	private Integer seccaoId;
	
	private String descricao;
	
	private Parte  parte;
	
	
	private List<Canone> canones = new ArrayList<Canone>();
	
	
	
	
	private List<Titulo> titulos  = new ArrayList<Titulo>();
	
		
	
	private List<Capitulo> capitulos = new ArrayList<Capitulo>();

	

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public Integer getSeccaoId() {
		return seccaoId;
	}
	public void setSeccaoId(Integer seccaoId) {
		this.seccaoId = seccaoId;
	}
	public Parte getParte() {
		return parte;
	}
	public void setParte(Parte parte) {
		this.parte = parte;
	}
	public List<Canone> getCanones() {
		return canones;
	}
	public void setCanones(List<Canone> canones) {
		this.canones = canones;
	}
	public List<Capitulo> getCapitulos() {
		return capitulos;
	}
	public void setCapitulos(List<Capitulo> capitulos) {
		this.capitulos = capitulos;
	}
	public List<Titulo> getTitulos() {
		return titulos;
	}
	public void setTitulos(List<Titulo> titulos) {
		this.titulos = titulos;
	}
	
	
	
}
