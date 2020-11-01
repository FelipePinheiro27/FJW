package br.ufc.web.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="favoritos")

public class Favorito {
	int user_id;
	int project_id;
	@Id
	@GeneratedValue
	int id;
	
	
	public Favorito() {
	}
	
	public Favorito(int id, int user_id, int project_id) {
		super();  
		this.id = id;
		this.user_id = user_id;
		this.project_id = project_id;
	}
	
	public Favorito(int user_id, int project_id) {
		super();
		this.user_id = user_id;
		this.project_id = project_id;
	}
	

	public int getuser_id() {
		return user_id;
	}

	public void setuser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	} 

	@Override
	public String toString() {
		return "Favorito [user_id=" + user_id + ", project_id=" + project_id + "]";
	}
}
