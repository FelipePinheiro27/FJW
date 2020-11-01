package br.ufc.web.server.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.web.server.model.Project;
import br.ufc.web.server.model.User;
import br.ufc.web.server.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepo;

	public Project addProject(int user_id, String titulo, String descricao, String palavras_chaves, String tipo) {
		Project user4 = projectRepo.findFirstByTitulo(titulo);
		if (user4 != null) {

			if (titulo.equals(user4.getTitulo())) {
				System.out.println(user4);
				System.out.println("Login: " + titulo + "   User: " + user4.getTitulo());
				return null;
			}

		}

		if (titulo != "" && descricao != "" && palavras_chaves != "" && tipo != "") {
			Project user = new Project(user_id, titulo, descricao, palavras_chaves, tipo);
			return projectRepo.save(user);

		} else {
			return null;
		}
	}

	public boolean removeProject(Integer id) {
		if (projectRepo.existsById(id)) {
			projectRepo.deleteById(id);
			return true;
		}
		return false;
	}

	public List<Project> getProjects() {
		return projectRepo.findAll();
	}

	@PersistenceContext
	private EntityManager entityManager;

	public List<Project> getUserByQuantidade(int valor) {
		List<Project> consulta = entityManager
				.createQuery("SELECT project FROM projects project ORDER BY project.id", Project.class)
				.setMaxResults(valor).getResultList();
		return consulta;
	}

	public Project getProject(Integer id) {
		return projectRepo.findById(id).get();
	}

	public Project getProjectByFirstTitulo(String titulo) {
		return projectRepo.findFirstByTitulo(titulo);
	}

	public List<Project> getProjectByTitulo(String titulo) {
		return projectRepo.findByTitulo(titulo);
	}
	

	public Project updateProject(Integer id, int user_id, String titulo, String descricao, String palavras_chaves,
			String tipo) {
		Project ProjectAux = projectRepo.findById(id).get();
		Project projeto4 = projectRepo.findFirstByTitulo(titulo);
		if (ProjectAux != null) {

			if (titulo == "" || descricao == "" || palavras_chaves == "" || tipo == "") {
				System.out.println("1: " + ProjectAux);
				return null;
			}
			if (projeto4 != null) {
				if (ProjectAux.getTitulo().equals(projeto4.getTitulo())) {
					ProjectAux.setuser_id(user_id);
					ProjectAux.setTitulo(titulo);
					ProjectAux.setDescricao(descricao);
					ProjectAux.setpalavras_chaves(palavras_chaves);
					ProjectAux.setTipo(tipo);
					projectRepo.save(ProjectAux);
					System.out.println("2:" + ProjectAux);
					return ProjectAux;
				}

				else if (!titulo.equals(ProjectAux.getTitulo()) && titulo.equals(projeto4.getTitulo())) {
					System.out.println("3: " + ProjectAux);
					return null;
				}

			}

			else {
				ProjectAux.setuser_id(user_id);
				ProjectAux.setTitulo(titulo);
				ProjectAux.setDescricao(descricao);
				ProjectAux.setpalavras_chaves(palavras_chaves); 
				ProjectAux.setTipo(tipo);
				projectRepo.save(ProjectAux);
				System.out.println("4: " + ProjectAux);
				return ProjectAux;

			}
		}
		return null;
	}

}
