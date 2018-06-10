package br.gms.irfacil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.gms.irfacil.dao.OperacaoDAO;
import br.gms.irfacil.model.Operacao;

@Controller
@RequestMapping("/operacao")
public class OperacaoController {

	@Autowired
	private OperacaoDAO dao;
	
	@RequestMapping(value="/incluir" , method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Operacao incluir(@RequestBody Operacao operacao) {
		if(operacao.getId() == 0) {
			operacao.setId(null);
		}
		return dao.incluir(operacao);
	}
	
	@RequestMapping(value="/listar" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Operacao> listar() {
		return dao.list();
	}
	
	@RequestMapping(value="/excluir/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String excluir(@PathVariable Integer id) throws Exception {
		Operacao operacao = dao.consultarPorId(id);
		dao.excluir(operacao);
		return "EXCLUSAO_SUCESSO";
	}
	
	@RequestMapping(value="/porUsuario/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Operacao> operacoesPorUsuario(@PathVariable Integer id) {
		return dao.porUsuario(id);
	}
	
}
