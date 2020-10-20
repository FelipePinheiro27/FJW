package br.ufc.web.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.web.server.model.User;
import br.ufc.web.server.service.UserService;

@RestController
@CrossOrigin
@RequestMapping(path = "/api/users/login")
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> postLogin(@RequestBody User user) {
		 user = userService.getUserByLoginAndPassword(user.getLogin(), user.getPassword());
		 if(user != null) {
			 return new ResponseEntity<User>(user, HttpStatus.OK);
		 }
		 else {
			return new ResponseEntity<User>(user, HttpStatus.UNAUTHORIZED);
		 }
	}

}
