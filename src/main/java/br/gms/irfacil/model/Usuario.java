package br.gms.irfacil.model;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Usuario implements UserDetails {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String email;

	private String login;

	private String nome;

	private String senha;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_criacao")
	private Date dtCriacao;

	//bi-directional many-to-one association to Operacao
	@OneToMany(mappedBy="usuario")
	@JsonIgnore
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
	
	public Date getDtCriacao() {
		return this.dtCriacao;
	}

	public void setDtCriacao(Date dtCriacao) {
		this.dtCriacao = dtCriacao;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return getSenha();
	}

	@Override
	public String getUsername() {
		return getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}