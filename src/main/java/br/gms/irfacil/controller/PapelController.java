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
		
		Papel papel2 = new Papel();
		papel2.setCdPapel("ABEV3");
		papel2.setNoEmpresa("Ambev");
		dao.incluir(papel2);
		
		Papel papel3 = new Papel();
		papel3.setCdPapel("VALE5");
		papel3.setNoEmpresa("Vale");
		dao.incluir(papel3);
		
		Papel papel4 = new Papel();
		papel4.setCdPapel("BRKM5");
		papel4.setNoEmpresa("Brasken");
		dao.incluir(papel4);
		
		Papel papel5 = new Papel();
		papel5.setCdPapel("RSID3");
		papel5.setNoEmpresa("Rossi");
		dao.incluir(papel5);
		
		Papel papel6 = new Papel();
		papel6.setCdPapel("BBAS3");
		papel6.setNoEmpresa("Banco do brasil");
		dao.incluir(papel6);
		
		Papel papel7 = new Papel();
		papel7.setCdPapel("BBDC3");
		papel7.setNoEmpresa("Bradesco");
		dao.incluir(papel7);
		
		Papel papel8 = new Papel();
		papel8.setCdPapel("GOLL4");
		papel8.setNoEmpresa("Gol");
		dao.incluir(papel8);
		
		
		return "Papéis cadastrados com sucesso";
	}
}
