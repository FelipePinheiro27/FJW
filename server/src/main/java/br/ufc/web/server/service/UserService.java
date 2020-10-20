package br.ufc.web.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufc.web.server.model.User;
import br.ufc.web.server.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepo;
	
	public User addUser(String login, String password, String curso, String instituicao) {
		User user = new User(login, password, curso, instituicao);
		return userRepo.save(user);
	}
	
	public boolean removeUser(Integer id) {
		if(userRepo.existsById(id)) {
			userRepo.deleteById(id);
			return true;
		}
		
		return false;
	}
	
	public List<User> getUsers() {
		return userRepo.findAll();
	}
	
	public User getUser(Integer id) {
		return userRepo.findById(id).get();
	}
	
	public User getUserByLoginAndPassword(String login, String password) {
		return userRepo.findFirstByLoginAndPassword(login, password);
	}
	
	public User updateUser(Integer id, String login, String password, String curso, String instituicao) {
		User userAux = userRepo.findById(id).get();
		
		if(userAux != null) {
			userAux.setLogin(login);;
			userAux.setPassword(password);
			userAux.setCurso(curso);
			userAux.setInstituicao(instituicao);
			userRepo.save(userAux);			
		}
		return userAux;
	}
}