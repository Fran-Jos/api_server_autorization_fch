package com.example.demo.service;

import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.repository.IUsuarioRepository;
import com.example.demo.repository.modelo.Usuario;

@Service
public class UsuarioServiceImpl implements UserDetailsService {

	@Autowired
	private IUsuarioRepository iUsuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario = this.iUsuarioRepository.consultarPorNombre(username);
		System.out.println(usuario.getNombre());
		System.out.println(usuario.getPassword());
		
		return new User(usuario.getNombre(), usuario.getPassword(), emptyList());
	}

}
