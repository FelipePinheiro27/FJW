package model;

//import java.util.ArrayList;

public class User {
	
	private int id;
	private String login;
	private String password;
	private String instituicao;
	private String curso;
	//private ArrayList projetos = new ArrayList();
	public String getInstituicao() {
		return instituicao;
	}

	public User(int id, String login, String password, String instituicao, String curso) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.instituicao = instituicao;
		this.curso = curso;
		//this.projetos = null;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

//	public ArrayList getProjetos() {
//		return projetos;
//	}
//
//	public void setProjetos(ArrayList projetos) {
//		this.projetos = projetos;
//	}

	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + "]";
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
