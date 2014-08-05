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

	
	
	
	
	public Parte() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Parte(Integer parteId) {
		super();
		this.parteId = parteId;
	}


	public Parte(Integer parteId, String descricao) {
		super();
		this.parteId = parteId;
		this.descricao = descricao;
	}
	public Parte(Integer parteId, String descricao, Livro livro,
			List<Capitulo> capitulos, List<Seccao> seccaos, List<Canone> canones) {
		super();
		this.parteId = parteId;
		this.descricao = descricao;
		this.livro = livro;
		this.capitulos = capitulos;
		this.seccaos = seccaos;
		this.canones = canones;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parteId == null) ? 0 : parteId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parte other = (Parte) obj;
		if (parteId == null) {
			if (other.parteId != null)
				return false;
		} else if (!parteId.equals(other.parteId))
			return false;
		return true;
	}
	
	
}
