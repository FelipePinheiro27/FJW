package br.ufc.web.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.web.server.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
	List<Project> findByTitulo(String titulo);
	Project findFirstByTitulo(String titulo);

	
}