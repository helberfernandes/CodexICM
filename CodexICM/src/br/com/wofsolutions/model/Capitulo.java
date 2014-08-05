package br.com.wofsolutions.model;

import java.util.ArrayList;
import java.util.List;


public class Capitulo {
	
	private Integer capituloId;
	private String descricao;
	
	
	private Titulo  titulo= new Titulo();
	
	
	private Parte parte;
	
	
	private Seccao seccao;
	
	
	
	private List<Canone> canones = new ArrayList<Canone>();
	
	
	private List<Artigo> artigos = new ArrayList<Artigo>();
	
	
	
	public Capitulo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Capitulo(Integer capituloId) {
		super();
		this.capituloId = capituloId;
	}
	
	
	public Capitulo(Integer capituloId, String descricao) {
		super();
		this.capituloId = capituloId;
		this.descricao = descricao;
	}
	public Integer getCapituloId() {
		return capituloId;
	}
	public void setCapituloId(Integer capituloId) {
		this.capituloId = capituloId;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Titulo getTitulo() {
		return titulo;
	}
	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}
	public List<Canone> getCanones() {
		return canones;
	}
	public void setCanones(List<Canone> canones) {
		this.canones = canones;
	}
	public List<Artigo> getArtigos() {
		return artigos;
	}
	public void setArtigos(List<Artigo> artigos) {
		this.artigos = artigos;
	}
	public Parte getParte() {
		return parte;
	}
	public void setParte(Parte parte) {
		this.parte = parte;
	}
	public Seccao getSeccao() {
		return seccao;
	}
	public void setSeccao(Seccao seccao) {
		this.seccao = seccao;
	}
	
	
	
}
