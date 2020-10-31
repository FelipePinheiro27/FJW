package br.ufc.web.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.web.server.model.Project;
import br.ufc.web.server.service.ProjectService;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/projects")
public class ProjectController {
	
	@Autowired
	ProjectService projectService;
	///Get All
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Project>> getProjects() {
		return new ResponseEntity<List<Project>>(projectService.getProjects(), HttpStatus.OK);
	}
	//Get One
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ResponseEntity<Project> getProject(@PathVariable("id") Integer id) {
		return new ResponseEntity<Project>(projectService.getProject(id), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/search")
    public ResponseEntity<List<Project>> getProjectByTitulo(@RequestParam("titulo") String titulo) {
        return new ResponseEntity<List<Project>>(projectService.getProjectByTitulo(titulo), HttpStatus.OK);
    }
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Project> addProject(@RequestBody Project Project) {			
		//int user_id, String titulo, String descricao, String palavras_chaves, String tipo
		if(Project.getTitulo() != "" && Project.getDescricao() != "" && Project.getpalavras_chaves() != "" && Project.getTipo() != "") {
			return new ResponseEntity<Project>(projectService.addProject(Project.getuser_id(), Project.getTitulo(), Project.getDescricao(), Project.getpalavras_chaves(),Project.getTipo()), HttpStatus.OK);
		}else {
			return new ResponseEntity<Project>(HttpStatus.UNAUTHORIZED);
		}
	
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public ResponseEntity<Project> updateProject(@PathVariable("id") Integer id, @RequestBody Project Project) {
		if(Project.getTitulo() != "" && Project.getDescricao() != "" && Project.getpalavras_chaves() != "" && Project.getTipo() != "") {
			return new ResponseEntity<Project>(projectService.updateProject(id, Project.getuser_id(), Project.getTitulo(), Project.getDescricao(), Project.getpalavras_chaves(),Project.getTipo()), HttpStatus.OK);
		}else {
			return new ResponseEntity<Project>(HttpStatus.UNAUTHORIZED);
		}
		
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable("id") Integer id) {
		if (projectService.removeProject(id)) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
