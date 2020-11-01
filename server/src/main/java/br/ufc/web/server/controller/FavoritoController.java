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
import org.springframework.web.bind.annotation.RestController;

import br.ufc.web.server.model.Favorito;
import br.ufc.web.server.model.Project;
import br.ufc.web.server.service.FavoritoService;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/favoritos")
public class FavoritoController {
	
	@Autowired
	FavoritoService favoritoService;
	///Get All
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Favorito>> getProjects() {
		return new ResponseEntity<List<Favorito>>(favoritoService.getProjects(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Favorito> addProject(@RequestBody Favorito Project) {			
		return new ResponseEntity<Favorito>(favoritoService.addFavorito(Project.getuser_id(),Project.getProject_id()), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public ResponseEntity<Void> deleteProject(@PathVariable("id") Integer id) { 
		if (favoritoService.removeProject(id)) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
