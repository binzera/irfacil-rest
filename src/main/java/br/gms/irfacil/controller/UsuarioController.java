package br.gms.irfacil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.gms.irfacil.dao.UsuarioDAO;
import br.gms.irfacil.model.Usuario;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO dao;
	
	@RequestMapping(value="/logar" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Usuario logar(@RequestBody Usuario usuario) {
		Usuario logado = dao.loadUserByUsername(usuario.getLogin());
		return logado;
	}
	
	@RequestMapping(value="/incluir" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Usuario cadastrarusuario(@RequestBody Usuario usuario) {
		return dao.incluir(usuario);
	}
	
	@RequestMapping(value="/listar" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Usuario> listar() {
		return dao.list();
	}
	
	@RequestMapping(value="/inserirusuarioteste" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Usuario userTeste() {
		Usuario user = new Usuario();
		user.setNome("Joaozinho");
		user.setLogin("joao");
		user.setSenha("1739e701ccc9dbf1b485f672203fc81f");
		user.setEmail("joao@gmail.com");
		return dao.incluir(user);
	}

}
