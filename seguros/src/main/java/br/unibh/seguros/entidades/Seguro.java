package br.unibh.seguros.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "tb_seguro")
public class Seguro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="codigo_susep",columnDefinition="char(15)", nullable=false, unique=true)
	@NotNull
	@Max(15)
	private String codigoSusep;

	@Column(name="tipo_segurado",columnDefinition="varchar(30)", nullable=false)
	@Pattern(regexp = "[A-zÀ-ú ]", message = "Somente letras e espaços")
	@Max(30)
	private String tipoSegurado;
	
	@Column(name="valor_segurado",columnDefinition="decimal(14,2)", nullable=false)
	@NotNull
	@DecimalMin("1000.0")
	@DecimalMax("10000000.00")
	private String valorSegurado;
	
	@Column(name="classe",columnDefinition="char(1)", nullable=false)
	@NotNull
	@Pattern(regexp = "[A-Z]{1}", message = "Somente caracteres maisculos")
	private String classe;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_inicio_vigencia", nullable=false)
	@NotNull
	private Date dataInicioVigencia;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_termino_vigencia", nullable=false)
	@NotNull
	private Date dataTerminoVigencia;
	
	@Column(name="carencia_em_meses", columnDefinition="integer", nullable=false)
	@NotNull
	@Range(min = 0, max=24)
	private String carenciaEmMeses;
	
	@Column(name="situacao_atual", columnDefinition="varchar(30)", nullable=false)
	@NotNull
	@Max(30)
	@Pattern(regexp = "[A-zÀ-ú ]", message = "Somente letras e espaços")
	private String situacaoAtual;
	
	@Column(name="valor_premio", columnDefinition="decimal(14,2)", nullable=false)
	@NotNull
	@DecimalMin("100.0")
	@DecimalMax("100000.00")
	private String valorPremio;
	
	@Column(name="dia_pagamento", columnDefinition="integer", nullable=false)
	@NotNull
	@Range(min = 1, max = 31)
	private String diaPagamento;
	
	@Column(name="banco_pagamento", columnDefinition="varchar(50)", nullable=false)
	@NotNull
	@Max(50)
	private String bancoPagamento;
	
	@NotNull
	@Max(15)
	@Column(name="agencia", columnDefinition="varchar(15)", nullable=false)
	private String agencia;
	
	@Column(name="conta", columnDefinition="varchar(15)", nullable=false)
	@NotNull
	@Max(50)
	private String conta;

	@ManyToOne(fetch=FetchType.EAGER)
	private Proponente proponente;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoSusep() {
		return codigoSusep;
	}

	public void setCodigoSusep(String codigoSusep) {
		this.codigoSusep = codigoSusep;
	}

	public String getTipoSegurado() {
		return tipoSegurado;
	}

	public void setTipoSegurado(String tipoSegurado) {
		this.tipoSegurado = tipoSegurado;
	}

	public String getValorSegurado() {
		return valorSegurado;
	}

	public void setValorSegurado(String valorSegurado) {
		this.valorSegurado = valorSegurado;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public Date getDataInicioVigencia() {
		return dataInicioVigencia;
	}

	public void setDataInicioVigencia(Date dataInicioVigencia) {
		this.dataInicioVigencia = dataInicioVigencia;
	}

	public Date getDataTerminoVigencia() {
		return dataTerminoVigencia;
	}

	public void setDataTerminoVigencia(Date dataTerminoVigencia) {
		this.dataTerminoVigencia = dataTerminoVigencia;
	}

	public String getCarenciaEmMeses() {
		return carenciaEmMeses;
	}

	public void setCarenciaEmMeses(String carenciaEmMeses) {
		this.carenciaEmMeses = carenciaEmMeses;
	}

	public String getSituacaoAtual() {
		return situacaoAtual;
	}

	public void setSituacaoAtual(String situacaoAtual) {
		this.situacaoAtual = situacaoAtual;
	}

	public String getValorPremio() {
		return valorPremio;
	}

	public void setValorPremio(String valorPremio) {
		this.valorPremio = valorPremio;
	}

	public String getDiaPagamento() {
		return diaPagamento;
	}

	public void setDiaPagamento(String diaPagamento) {
		this.diaPagamento = diaPagamento;
	}

	public String getBancoPagamento() {
		return bancoPagamento;
	}

	public void setBancoPagamento(String bancoPagamento) {
		this.bancoPagamento = bancoPagamento;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public Proponente getProponente() {
		return proponente;
	}

	public void setProponente(Proponente proponente) {
		this.proponente = proponente;
	}
}
