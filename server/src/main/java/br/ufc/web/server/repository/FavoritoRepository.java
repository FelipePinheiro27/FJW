package br.ufc.web.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufc.web.server.model.Favorito;

public interface FavoritoRepository extends JpaRepository<Favorito, Integer> {
	
}