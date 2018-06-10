package br.gms.irfacil.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_operacao database table.
 * 
 */
@Entity
@Table(name="tipo_operacao")
@NamedQuery(name="TipoOperacao.findAll", query="SELECT t FROM TipoOperacao t")
public class TipoOperacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String descricao;

	//bi-directional many-to-one association to Operacao
	@OneToMany(mappedBy="tipoOperacao")
	private List<Operacao> operacaos;

	public TipoOperacao() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Operacao> getOperacaos() {
		return this.operacaos;
	}

	public void setOperacaos(List<Operacao> operacaos) {
		this.operacaos = operacaos;
	}


}