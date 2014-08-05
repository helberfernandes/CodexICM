package br.com.wofsolutions.model;

import java.util.ArrayList;
import java.util.List;


public class Artigo {
	
	
	private Integer artigoId;
	
	private String descricao;
	

	private Capitulo  capitulo ;
	

	private List<Canone> canones = new ArrayList<Canone>();
	
	
	
	public Artigo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Artigo(Integer artigoId) {
		super();
		this.artigoId = artigoId;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

	public Integer getArtigoId() {
		return artigoId;
	}
	public void setArtigoId(Integer artigoId) {
		this.artigoId = artigoId;
	}
	public Capitulo getCapitulo() {
		return capitulo;
	}
	public void setCapitulo(Capitulo capitulo) {
		this.capitulo = capitulo;
	}
	public List<Canone> getCanones() {
		return canones;
	}
	public void setCanones(List<Canone> canones) {
		this.canones = canones;
	}

	
	
}
