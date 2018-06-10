package br.gms.irfacil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.gms.irfacil.dao.TipoOperacaoDAO;
import br.gms.irfacil.model.TipoOperacao;

@Controller
@RequestMapping("/tipoOperacao")
public class TipoOperacaoController {

	@Autowired
	private TipoOperacaoDAO dao;
	
	@RequestMapping(value="/incluir" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public TipoOperacao cadastrarusuario(@RequestBody TipoOperacao tpOperacao) {
		return dao.incluir(tpOperacao);
	}
	
	@RequestMapping(value="/listar" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<TipoOperacao> listar() {
		return dao.list();
	}
	
	@RequestMapping(value="/excluir" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void excluir(TipoOperacao entidade) {
		dao.excluir(entidade);
	}
}
