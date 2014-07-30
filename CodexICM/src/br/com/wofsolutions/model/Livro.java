package br.com.wofsolutions.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Livro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer livroId;	
	private String descricao;
	
	
		
	private List<Canone> canones = new ArrayList<Canone>();

	
	private List<Parte> partes = new ArrayList<Parte>();
	
	
	
	private List<Titulo> titulos  = new ArrayList<Titulo>();
	
	
	
	
	
	public Livro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Livro(Integer livroId, String descricao) {
		super();
		this.livroId = livroId;
		this.descricao = descricao;
	}

	public Livro(Integer livroId, String descricao, List<Canone> canones,
			List<Parte> partes, List<Titulo> titulos) {
		super();
		this.livroId = livroId;
		this.descricao = descricao;
		this.canones = canones;
		this.partes = partes;
		this.titulos = titulos;
	}

	public Integer getLivroId() {
		return livroId;
	}

	public void setLivroId(Integer livroId) {
		this.livroId = livroId;
	}

	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Titulo> getTitulos() {
		return titulos;
	}

	public void setTitulos(List<Titulo> titulos) {
		this.titulos = titulos;
	}

	public List<Canone> getCanones() {
		return canones;
	}

	public void setCanones(List<Canone> canones) {
		this.canones = canones;
	}

	public List<Parte> getPartes() {
		return partes;
	}

	public void setPartes(List<Parte> partes) {
		this.partes = partes;
	}
	
	
	
	
}
