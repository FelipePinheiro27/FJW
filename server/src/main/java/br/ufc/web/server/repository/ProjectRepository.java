package br.ufc.web.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.web.server.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
	Project findFirstByTitulo(String titulo);
	//Aqui que vai ter que ter as coisas pras filtragens... Pegando por mais de um parâmetro, qualquer coisa olha 
}