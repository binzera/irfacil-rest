package br.gms.irfacil.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import br.gms.irfacil.model.Usuario;



@Repository
public class UsuarioDAO extends BaseCRUDRepository<Usuario>{
	
	public Usuario loadUserByUsername(String login) {
		List<Usuario> usuarios = manager
				.createQuery("select u from Usuario u where u.login = :login",
				Usuario.class)
			.setParameter("login", login)
			.getResultList();
		
		if (usuarios.isEmpty()) {
			return null;
			//throw new UsernameNotFoundException("Usuário "  + email + " não foi encontrado");
		}
		
		return usuarios.get(0);
	}
	
	public void gravar(Usuario usuario) {
		manager.persist(usuario);
	}
}
