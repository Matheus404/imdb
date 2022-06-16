package com.ioasys.imdb.jwt.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ioasys.imdb.model.UsuarioImdb;


public class DetalheUsuarioData implements UserDetails {
	
	/**
	 * Classe usuário para o jwt
	 */
	private static final long serialVersionUID = 1L;
	
	private final Optional<UsuarioImdb> usuario;
	
    public DetalheUsuarioData(Optional<UsuarioImdb> usuario) {
        this.usuario = usuario;
    }
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return new ArrayList<>();
	}

	@Override
	public String getPassword() {
		return usuario.orElse(new UsuarioImdb()).getPassword();
	}

	@Override
	public String getUsername() {
		return usuario.orElse(new UsuarioImdb()).getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
