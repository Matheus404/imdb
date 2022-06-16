package com.ioasys.imdb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ioasys.imdb.model.UsuarioImdb;

@Repository
public interface UserImdbRepository extends JpaRepository<UsuarioImdb, Long> {
	
	public Optional<UsuarioImdb> findByLogin(String login);
	
}
