package br.com.wofsolutions.model;

import java.util.ArrayList;
import java.util.List;


public class Titulo {
	
	private Integer tituloId;	
	private String descricao;
	
	
	private Livro livro;
	
	
	
	private List<Canone> canones = new ArrayList<Canone>();
	
	
	private List<Capitulo> capitulos = new ArrayList<Capitulo>();
	
	
	private Parte  parte;
	
	
	private Seccao seccao;
	
	
	
	

	public Titulo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Titulo(Integer tituloId) {
		super();
		this.tituloId = tituloId;
	}
	
	
	public Titulo(Integer tituloId, String descricao) {
		super();
		this.tituloId = tituloId;
		this.descricao = descricao;
	}
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
	public Integer getTituloId() {
		return tituloId;
	}
	public void setTituloId(Integer tituloId) {
		this.tituloId = tituloId;
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
	public Seccao getSeccao() {
		return seccao;
	}
	public void setSeccao(Seccao seccao) {
		this.seccao = seccao;
	}
	
	
	
}
