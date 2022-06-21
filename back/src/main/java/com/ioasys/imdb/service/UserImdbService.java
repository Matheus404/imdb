package com.ioasys.imdb.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ioasys.imdb.model.UsuarioImdb;
import com.ioasys.imdb.repository.UserImdbRepository;

@Service
public class UserImdbService {
	
	@Autowired
	private UserImdbRepository userImdbRepository;

	public UsuarioImdb findById(Long id) {
		Optional<UsuarioImdb> userImdbOptional = userImdbRepository.findById(id);
		return userImdbOptional.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado! Id: " + id, 
				UsuarioImdb.class.getName()));
	}
	
	public List<UsuarioImdb> findAllUserImdb() {
		return userImdbRepository.findAll();
	}
	
	public UsuarioImdb saveUserImdb(UsuarioImdb userImdb) {
		return userImdbRepository.save(userImdb);
	}
	
	public void deleteUserImdb(Long id) {
		userImdbRepository.deleteById(id);
	}
	
	public UsuarioImdb updateUserImdb(Long id, UsuarioImdb userImdb) {
		UsuarioImdb userOpt = findById(id);
		userOpt.setLogin(userImdb.getLogin());
		userOpt.setPassword(userImdb.getPassword());
		userOpt.setPapeis(userImdb.getPapeis());
		return userImdbRepository.save(userOpt);
	}
}
