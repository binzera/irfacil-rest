package br.gms.irfacil.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the papel database table.
 * 
 */
@Entity
@NamedQuery(name="Papel.findAll", query="SELECT p FROM Papel p")
public class Papel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="cd_papel")
	private String cdPapel;

	@Column(name="no_empresa")
	private String noEmpresa;

	//bi-directional many-to-one association to Operacao
	@OneToMany(mappedBy="papel")
	private List<Operacao> operacaos;

	public Papel() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCdPapel() {
		return this.cdPapel;
	}

	public void setCdPapel(String cdPapel) {
		this.cdPapel = cdPapel;
	}

	public String getNoEmpresa() {
		return this.noEmpresa;
	}

	public void setNoEmpresa(String noEmpresa) {
		this.noEmpresa = noEmpresa;
	}

	public List<Operacao> getOperacaos() {
		return this.operacaos;
	}

	public void setOperacaos(List<Operacao> operacaos) {
		this.operacaos = operacaos;
	}

	public Operacao addOperacao(Operacao operacao) {
		getOperacaos().add(operacao);
		operacao.setPapel(this);

		return operacao;
	}

	public Operacao removeOperacao(Operacao operacao) {
		getOperacaos().remove(operacao);
		operacao.setPapel(null);

		return operacao;
	}

}