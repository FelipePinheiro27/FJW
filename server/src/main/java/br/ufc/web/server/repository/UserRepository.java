package br.ufc.web.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.web.server.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findFirstByLoginAndPassword(String login, String password);
	User findFirstByLogin(String login);
	List<User> findByLogin(String login);
	List<User> findByLoginAndCurso(String login, String curso);
	List<User> findByCurso(String curso);

}