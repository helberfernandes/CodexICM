package br.com.wofsolutions.model;

import java.io.Serializable;

 
public class Canone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private Integer canoneId;
	
	
	
	private String numero="";
	
	private String descricao;
	
	
	private Livro livro = new Livro();
	
	
	private Titulo titulo ;
	
	
	private Capitulo capitulo;
	
	
	private Parte parte;
	
	
	
	
	private Artigo artigo;
	
	
	private boolean grupoCanone=false;
	
	
	private boolean grupoCanoneTitulo=false;
	private boolean grupoCanoneCapitulo=false;
	
	
	public Canone() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Canone(Integer canoneId, String numero, String descricao) {
		super();
		this.canoneId = canoneId;
		this.numero = numero;
		this.descricao = descricao;
	}
	public Canone(Integer canoneId, String numero, String descricao,
			Livro livro, Titulo titulo, Capitulo capitulo, Parte parte,
			Artigo artigo) {
		super();
		this.canoneId = canoneId;
		this.numero = numero;
		this.descricao = descricao;
		this.livro = livro;
		this.titulo = titulo;
		this.capitulo = capitulo;
		this.parte = parte;
		this.artigo = artigo;
	}
	public Integer getCanoneId() {
		return canoneId;
	}
	public void setCanoneId(Integer canoneId) {
		this.canoneId = canoneId;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
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
	public Titulo getTitulo() {
		return titulo;
	}
	public void setTitulo(Titulo titulo) {
		this.titulo = titulo;
	}
	public Capitulo getCapitulo() {
		return capitulo;
	}
	public void setCapitulo(Capitulo capitulo) {
		this.capitulo = capitulo;
	}
	public Parte getParte() {
		return parte;
	}
	public void setParte(Parte parte) {
		this.parte = parte;
	}
	public Artigo getArtigo() {
		return artigo;
	}
	public void setArtigo(Artigo artigo) {
		this.artigo = artigo;
	}
	public boolean isGrupoCanone() {
		return grupoCanone;
	}
	public void setGrupoCanone(boolean grupoCanone) {
		this.grupoCanone = grupoCanone;
	}
	public boolean isGrupoCanoneTitulo() {
		return grupoCanoneTitulo;
	}
	public void setGrupoCanoneTitulo(boolean grupoCanoneTitulo) {
		this.grupoCanoneTitulo = grupoCanoneTitulo;
	}
	public boolean isGrupoCanoneCapitulo() {
		return grupoCanoneCapitulo;
	}
	public void setGrupoCanoneCapitulo(boolean grupoCanoneCapitulo) {
		this.grupoCanoneCapitulo = grupoCanoneCapitulo;
	}
	
	
	

}
