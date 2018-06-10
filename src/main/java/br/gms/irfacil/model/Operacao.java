package br.gms.irfacil.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * The persistent class for the operacao database table.
 * 
 */
@Entity
@NamedQuery(name="Operacao.findAll", query="SELECT o FROM Operacao o")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Operacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_compra")
	private Date dtCompra;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_venda")
	private Date dtVenda;

	private int quantidade;

	@Column(name="vl_compra")
	private double vlCompra;

	@Column(name="vl_emolumentos")
	private double vlEmolumentos;

	@Column(name="vl_ir")
	private double vlIr;

	@Column(name="vl_venda")
	private double vlVenda;

	//bi-directional many-to-one association to Papel
	@ManyToOne(fetch=FetchType.LAZY)
	private Papel papel;

	@Column(name="tipo_operacao_id")
	private Integer tipoOperacao;
	
	@Column(name="resultado_liquido")
	private Double resultadoLiquido;

	@Column(name="vl_ir_fonte")
	private Double vlIrFonte;
	
	//bi-directional many-to-one association to Usuario
	@ManyToOne(fetch=FetchType.LAZY)
	private Usuario usuario;

	public Operacao() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDtCompra() {
		return this.dtCompra;
	}

	public void setDtCompra(Date dtCompra) {
		this.dtCompra = dtCompra;
	}

	public Date getDtVenda() {
		return this.dtVenda;
	}

	public void setDtVenda(Date dtVenda) {
		this.dtVenda = dtVenda;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getVlCompra() {
		return this.vlCompra;
	}

	public void setVlCompra(double vlCompra) {
		this.vlCompra = vlCompra;
	}

	public double getVlEmolumentos() {
		return this.vlEmolumentos;
	}

	public void setVlEmolumentos(double vlEmolumentos) {
		this.vlEmolumentos = vlEmolumentos;
	}

	public double getVlIr() {
		return this.vlIr;
	}

	public void setVlIr(double vlIr) {
		this.vlIr = vlIr;
	}

	public double getVlVenda() {
		return this.vlVenda;
	}

	public void setVlVenda(double vlVenda) {
		this.vlVenda = vlVenda;
	}

	public Papel getPapel() {
		return this.papel;
	}

	public void setPapel(Papel papel) {
		this.papel = papel;
	}

	public Integer getTipoOperacao() {
		return this.tipoOperacao;
	}

	public void setTipoOperacao(Integer tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Double getResultadoLiquido() {
		return resultadoLiquido;
	}

	public void setResultadoLiquido(Double resultadoLiquido) {
		this.resultadoLiquido = resultadoLiquido;
	}

	public Double getVlIrFonte() {
		return vlIrFonte;
	}

	public void setVlIrFonte(Double vlIrFonte) {
		this.vlIrFonte = vlIrFonte;
	}

}