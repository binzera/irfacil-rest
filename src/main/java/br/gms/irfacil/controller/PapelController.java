package br.gms.irfacil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.gms.irfacil.dao.PapelDAO;
import br.gms.irfacil.model.Papel;

@Controller
@RequestMapping("/papel")
public class PapelController {
	
	@Autowired
	private PapelDAO dao;
	
	@RequestMapping(value="/incluir" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Papel cadastrarusuario(@RequestBody Papel papel) {
		return dao.incluir(papel);
	}
	
	@RequestMapping(value="/listar" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Papel> listar() {
		return dao.list();
	}
	
	@RequestMapping(value="/excluir" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void excluir(Papel papel) {
		dao.excluir(papel);
	}
}
