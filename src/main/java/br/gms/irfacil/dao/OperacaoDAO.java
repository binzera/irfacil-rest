package br.gms.irfacil.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.gms.irfacil.model.Operacao;

@Repository
public class OperacaoDAO extends BaseCRUDRepository<Operacao> {

	public List<Operacao> porUsuario(Integer userId) {
		List<Operacao> operacoes = manager
				.createQuery("select o from Operacao o where o.usuario.id = :userId", Operacao.class)
				.setParameter("userId", userId).getResultList();

		return operacoes;
	}
}
