package br.gms.irfacil.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the operacao database table.
 * 
 */
@Entity
@Table(name="operacao")
@NamedQuery(name="Operacao.findAll", query="SELECT o FROM Operacao o")
public class Operacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date data;

	private int quantidade;

	private double valor;

	//bi-directional many-to-one association to Papel
	@ManyToOne(fetch=FetchType.LAZY)
	private Papel papel;

	//bi-directional many-to-one association to TipoOperacao
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="tipo_operacao_id")
	private TipoOperacao tipoOperacao;

	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;

	public Operacao() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Papel getPapel() {
		return this.papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}

	public TipoOperacao getTipoOperacao() {
		return this.tipoOperacao;
	}

	public void setTipoOperacao(TipoOperacao tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}