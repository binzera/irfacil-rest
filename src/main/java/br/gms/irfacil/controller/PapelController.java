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
import br.gms.irfacil.model.Usuario;

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
	
	@RequestMapping(value="/inserirPapeis" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String inserirPapel() {
		Papel papel = new Papel();
		papel.setCdPapel("PETR4");
		papel.setNoEmpresa("Petrobras");
		dao.incluir(papel);
		papel.setCdPapel("ABEV3");
		papel.setNoEmpresa("Ambev");
		dao.incluir(papel);
		papel.setCdPapel("VALE5");
		papel.setNoEmpresa("Vale");
		dao.incluir(papel);
		papel.setCdPapel("BRKM5");
		papel.setNoEmpresa("Brasken");
		dao.incluir(papel);
		papel.setCdPapel("RSID3");
		papel.setNoEmpresa("Rossi");
		dao.incluir(papel);
		papel.setCdPapel("BBAS3");
		papel.setNoEmpresa("Banco do brasil");
		dao.incluir(papel);
		papel.setCdPapel("BBDC3");
		papel.setNoEmpresa("Bradesco");
		dao.incluir(papel);
		papel.setCdPapel("GOLL4");
		papel.setNoEmpresa("Gol");
		
		
		return "Papéis cadastrados com sucesso";
	}
}
