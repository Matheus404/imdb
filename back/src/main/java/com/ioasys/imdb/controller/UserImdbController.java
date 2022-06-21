package com.ioasys.imdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ioasys.imdb.model.UsuarioImdb;
import com.ioasys.imdb.service.UserImdbService;

@RestController
@RequestMapping("/user")
public class UserImdbController {
	
	@Autowired
	private UserImdbService userImdbService;
	@Autowired
	private PasswordEncoder encoder;
	
	@GetMapping
	public ResponseEntity<?> listUsers() {
		List<UsuarioImdb> users = userImdbService.findAllUserImdb();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> saveUser(@RequestBody UsuarioImdb usuario) {
		usuario.setPassword(encoder.encode(usuario.getPassword()));
		userImdbService.saveUserImdb(usuario);
		return new ResponseEntity<>(usuario, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UsuarioImdb userImdb) {
		UsuarioImdb userAux = userImdbService.updateUserImdb(id, userImdb);
		return new ResponseEntity<>(userAux, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		try {
			userImdbService.deleteUserImdb(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	
}
