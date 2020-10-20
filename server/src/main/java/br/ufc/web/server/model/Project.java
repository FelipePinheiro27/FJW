package br.ufc.web.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "projects")
public class Project {

	@Id
	@GeneratedValue
	private int id;
	private String titulo;
	private String descricao;
	private String palavras_chaves;
	private String tipo;
	private int user_id;

	@Override
	public String toString() {
		return "Project [titulo=" + titulo + ", descricao=" + descricao + ", palavras_chaves=" + palavras_chaves
				+ ", tipo=" + tipo + ", id=" + id + ", user_id=" + user_id + "]";
	}

	public Project() {

	}

	public Project(int user_id, String titulo, String descricao, String palavras_chaves, String tipo) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.palavras_chaves = palavras_chaves;
		this.tipo = tipo;
		this.user_id = user_id;
	}

	public Project(int id, int user_id, String titulo, String descricao, String palavras_chaves, String tipo) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.palavras_chaves = palavras_chaves;
		this.tipo = tipo;
		this.setId(id);
		this.setuser_id(user_id);
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getpalavras_chaves() {
		return palavras_chaves;
	}

	public void setpalavras_chaves(String palavras_chaves) {
		this.palavras_chaves = palavras_chaves;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getuser_id() {
		return user_id;
	}

	public void setuser_id(int user_id) {
		this.user_id = user_id;
	}
}