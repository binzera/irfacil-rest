package br.gms.irfacil.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String email;

	private String login;

	private String nome;

	private String senha;

	//bi-directional many-to-one association to Operacao
	@OneToMany(mappedBy="usuario")
	private List<Operacao> operacaos;

	public Usuario() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Operacao> getOperacaos() {
		return this.operacaos;
	}

	public void setOperacaos(List<Operacao> operacaos) {
		this.operacaos = operacaos;
	}

	public Operacao addOperacao(Operacao operacao) {
		getOperacaos().add(operacao);
		operacao.setUsuario(this);

		return operacao;
	}

	public Operacao removeOperacao(Operacao operacao) {
		getOperacaos().remove(operacao);
		operacao.setUsuario(null);

		return operacao;
	}

}