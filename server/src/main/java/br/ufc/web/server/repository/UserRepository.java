package br.ufc.web.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.web.server.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findFirstByLoginAndPassword(String login, String password);
}