package br.gms.irfacil.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.gms.irfacil.dao.UsuarioDAO;
import br.gms.irfacil.model.Usuario;

public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UsuarioDAO dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = dao.loadUserByUsername(username);
						
		if (usuario == null) {
			return null;
			//throw new UsernameNotFoundException("Usuário "  + email + " não foi encontrado");
		}
		
		return usuario;
	}

}
