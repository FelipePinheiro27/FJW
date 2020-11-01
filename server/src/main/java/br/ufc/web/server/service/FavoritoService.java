package br.ufc.web.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.web.server.model.Favorito;
import br.ufc.web.server.repository.FavoritoRepository;

@Service
public class FavoritoService {

	
	@Autowired
	FavoritoRepository favoritoRepo;
	
	public Favorito addFavorito(int user_id, int projeto_id) {
		Favorito project = new Favorito(user_id, projeto_id);
		return favoritoRepo.save(project);
	}
	
	public boolean removeProject(Integer id) {
		if(favoritoRepo.existsById(id)) {
			favoritoRepo.deleteById(id);
			return true;
		}
		return false;
	}
	
	public List<Favorito> getProjects() {
		return favoritoRepo.findAll();
	}
}
