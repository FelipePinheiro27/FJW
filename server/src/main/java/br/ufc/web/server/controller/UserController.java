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

import br.ufc.web.server.model.User;
import br.ufc.web.server.service.UserService;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/users")
public class UserController {

	@Autowired
	UserService userService;
	///Get All
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getUsers() {
		return new ResponseEntity<List<User>>(userService.getUsers(), HttpStatus.OK);
	}
	//Get One
	@RequestMapping(method = RequestMethod.GET, value = "{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") Integer id) {
		return new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);
	}
	
//	@RequestMapping(method = RequestMethod.GET, value = "/search")
//    public ResponseEntity<User> getUserByLogin(@RequestParam("login") String login) {
//        return new ResponseEntity<User>(userService.getUserByLogin(login), HttpStatus.OK);
//    }
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> addUser(@RequestBody User user) {			
			//System.out.println("Login: " + user2.getLogin() + "Senha: " + user2.getPassword() + "Curso: " + user2.getCurso());
		return new ResponseEntity<User>(userService.addUser(user.getLogin(), user.getPassword(), user.getCurso(), user.getInstituicao()), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
		return new ResponseEntity<User>(userService.updateUser(id, user.getLogin(), user.getPassword(), user.getCurso(), user.getInstituicao()), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Integer id) {
		if (userService.removeUser(id)) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
}
