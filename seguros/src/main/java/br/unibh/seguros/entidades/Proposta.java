package br.unibh.seguros.entidades;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_proposta")
public class Proposta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data", nullable=false)
	private Date data;
	
	@Column(name="tipo_segurado",columnDefinition="varchar(30)", nullable=false)
	private String tipoSegurado;
	
	@Column(name="valor_segurado",columnDefinition="decimal(14,2)", nullable=false)
	private String valorSegurado;
	
	@Column(name="classe",columnDefinition="char(1)", nullable=false)
	private String classe;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_inicio_vigencia", nullable=false)
	private Date dataInicioVigencia;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_termino_vigencia", nullable=false)
	private Date dataTerminoVigencia;
	
	@Column(name="carencia_em_meses", columnDefinition="integer", nullable=false)
	private String carenciaEmMeses;
	
	@Column(name="situacao_atual", columnDefinition="varchar(30)", nullable=false)
	private String situacaoAtual;
	
	@Column(name="valor_premio", columnDefinition="decimal(14,2)", nullable=false)
	private String valorPremio;
	
	@Column(name="dia_pagamento", columnDefinition="integer", nullable=false)
	private String diaPagamento;
	
	@Column(name="banco_pagamento", columnDefinition="varchar(50)", nullable=false)
	private String bancoPagamento;
	
	@Column(name="agencia", columnDefinition="varchar(15)", nullable=false)
	private String agencia;
	
	@Column(name="conta", columnDefinition="varchar(15)", nullable=false)
	private String conta;
	
	@OneToOne(optional=false)
	@JoinColumn(name="questionario_id")
	private Questionario questionario;
	
	@OneToOne(optional=false)
	@JoinColumn(name="seguro_id")
	private Seguro seguro;
	
	@OneToMany(mappedBy="tramitacoes", fetch=FetchType.LAZY)
	private Collection<Tramitacao> tramitacoes;
	
	@OneToMany(mappedBy="proposta", fetch=FetchType.LAZY)
	private Collection<Tramitacao> propostas;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Proponente proponente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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

	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}

	public Collection<Tramitacao> getTramitacoes() {
		return tramitacoes;
	}

	public void setTramitacoes(Collection<Tramitacao> tramitacoes) {
		this.tramitacoes = tramitacoes;
	}

	public Collection<Tramitacao> getPropostas() {
		return propostas;
	}

	public void setPropostas(Collection<Tramitacao> propostas) {
		this.propostas = propostas;
	}

	public Proponente getProponente() {
		return proponente;
	}

	public void setProponente(Proponente proponente) {
		this.proponente = proponente;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
}