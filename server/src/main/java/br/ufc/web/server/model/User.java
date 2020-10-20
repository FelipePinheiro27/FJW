package br.ufc.web.server.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="users")

public class User {
	@Id
	@GeneratedValue
	
	int id;
	String login;
	String password;
	String curso;
	String instituicao;


	public User(int id, String login, String password, String curso, String instituicao) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.curso = curso;
		this.instituicao = instituicao;
	}
	
	public User() {
	}

	public User(String login, String password, String curso, String instituicao) {
		super();
		this.login = login;
		this.password = password;
		this.curso = curso;
		this.instituicao = instituicao;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + ", curso=" + curso + ", instituicao="
				+ instituicao + "]";
	}

	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getInstituicao() {
		return instituicao;
	}
	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
