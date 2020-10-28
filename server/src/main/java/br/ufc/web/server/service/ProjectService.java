package br.ufc.web.server.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.web.server.model.Project;
import br.ufc.web.server.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepo;
	
	public Project addProject(int user_id, String titulo, String descricao, String palavras_chaves, String tipo) {
		Project project = new Project(user_id, titulo, descricao, palavras_chaves, tipo);
		return projectRepo.save(project);
	}
	
	public boolean removeProject(Integer id) {
		if(projectRepo.existsById(id)) {
			projectRepo.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Project> getProjects() {
		return projectRepo.findAll();
	}
	
	public Project getProject(Integer id) {
		return projectRepo.findById(id).get();
	}
	
	public List<Project> getProjectByTitulo(String titulo) {
		return projectRepo.findByTitulo(titulo);
	}
	
	public Project updateProject(Integer id, int user_id, String titulo, String descricao, String palavras_chaves, String tipo) {
		Project ProjectAux = projectRepo.findById(id).get();
		
		if(ProjectAux != null) {
			ProjectAux.setuser_id(user_id);
			ProjectAux.setTitulo(titulo);;
			ProjectAux.setDescricao(descricao);
			ProjectAux.setpalavras_chaves(palavras_chaves);
			ProjectAux.setTipo(tipo);
			projectRepo.save(ProjectAux);			
		}
		return ProjectAux;
	}
	
}
