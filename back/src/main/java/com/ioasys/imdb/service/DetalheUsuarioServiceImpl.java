package com.ioasys.imdb.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.ioasys.imdb.jwt.data.DetalheUsuarioData;
import com.ioasys.imdb.model.UsuarioImdb;
import com.ioasys.imdb.repository.UserImdbRepository;

@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService {

	private final UserImdbRepository userImdbRepository;
	
	public DetalheUsuarioServiceImpl(UserImdbRepository userImdbRepository) {
		this.userImdbRepository = userImdbRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UsuarioImdb> usuario = userImdbRepository.findByLogin(username);
		
		if(usuario.isEmpty()) {
			throw new UsernameNotFoundException("Usuário ["+username+"] não encontrado!");
		}
		
		return new DetalheUsuarioData(usuario);
	}

}
