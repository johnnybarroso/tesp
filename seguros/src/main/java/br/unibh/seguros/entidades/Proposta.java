package br.unibh.seguros.entidades;
import java.io.Serializable;
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
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

@Entity
@Table(name = "tb_proposta")
@NamedQuery(name="Proposta.findByName", query = "select o from Proposta o where o.bancoPagamento like :bancoPagamento")
public class Proposta implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Version
	@Column(columnDefinition = "bigint NOT NULL DEFAULT 0")
	private Long version;

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data", nullable=false)
	private Date data;
	
	@Column(name="tipo_segurado",columnDefinition="varchar(30)", nullable=false)
	@NotNull
	@Pattern(regexp = "[A-zÀ-ú ]*", message = "Deve conter apenas letras e espaços")
	@Size(max = 30)
	private String tipoSegurado;
	
	@Column(name="valor_segurado",columnDefinition="decimal(14,2)", nullable=false)
	@NotNull
	@DecimalMin("1000.0")
	@DecimalMax("10000000.00")
	private String valorSegurado;
	
	@Column(name="classe",columnDefinition="char(1)", nullable=false)
	@NotNull
	@Pattern(regexp = "[A-Z]{1}", message = "Deve conter apenas letras maisculas")
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
	@Range(min = 0, max = 24)
	private String carenciaEmMeses;
	
	@Column(name="situacao_atual", columnDefinition="varchar(30)", nullable=false)
	@Pattern(regexp = "[A-zÀ-ú ]*", message = "Somente letras e espaços")
	@Size(max = 30)
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
	@Size(max = 50)
	private String bancoPagamento;
	
	@Column(name="agencia", columnDefinition="varchar(15)", nullable=false)
	@NotNull
	@Size(max = 15)
	private String agencia;
	
	@Column(name="conta", columnDefinition="varchar(15)", nullable=false)
	@NotNull
	@Size(max = 50)
	private String conta;
	
	//Optional = false
	@OneToOne(optional=true)
	@JoinColumn(name="questionario_id")
	private Questionario questionario;
	
	//Optional = false
	@OneToOne(optional=true)
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

	
	public Proposta() {
		super();
	}

	public Proposta(Date data, String tipoSegurado, String valorSegurado, String classe, Date dataInicioVigencia,
			Date dataTerminoVigencia, String carenciaEmMeses, String situacaoAtual, String valorPremio,
			String diaPagamento, String bancoPagamento, String agencia, String conta, Questionario questionario,
			Seguro seguro, Collection<Tramitacao> tramitacoes, Collection<Tramitacao> propostas,
			Proponente proponente) {
		super();
		this.data = data;
		this.tipoSegurado = tipoSegurado;
		this.valorSegurado = valorSegurado;
		this.classe = classe;
		this.dataInicioVigencia = dataInicioVigencia;
		this.dataTerminoVigencia = dataTerminoVigencia;
		this.carenciaEmMeses = carenciaEmMeses;
		this.situacaoAtual = situacaoAtual;
		this.valorPremio = valorPremio;
		this.diaPagamento = diaPagamento;
		this.bancoPagamento = bancoPagamento;
		this.agencia = agencia;
		this.conta = conta;
		this.questionario = questionario;
		this.seguro = seguro;
		this.tramitacoes = tramitacoes;
		this.propostas = propostas;
		this.proponente = proponente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agencia == null) ? 0 : agencia.hashCode());
		result = prime * result + ((bancoPagamento == null) ? 0 : bancoPagamento.hashCode());
		result = prime * result + ((carenciaEmMeses == null) ? 0 : carenciaEmMeses.hashCode());
		result = prime * result + ((classe == null) ? 0 : classe.hashCode());
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((dataInicioVigencia == null) ? 0 : dataInicioVigencia.hashCode());
		result = prime * result + ((dataTerminoVigencia == null) ? 0 : dataTerminoVigencia.hashCode());
		result = prime * result + ((diaPagamento == null) ? 0 : diaPagamento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((situacaoAtual == null) ? 0 : situacaoAtual.hashCode());
		result = prime * result + ((tipoSegurado == null) ? 0 : tipoSegurado.hashCode());
		result = prime * result + ((valorPremio == null) ? 0 : valorPremio.hashCode());
		result = prime * result + ((valorSegurado == null) ? 0 : valorSegurado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proposta other = (Proposta) obj;
		if (agencia == null) {
			if (other.agencia != null)
				return false;
		} else if (!agencia.equals(other.agencia))
			return false;
		if (bancoPagamento == null) {
			if (other.bancoPagamento != null)
				return false;
		} else if (!bancoPagamento.equals(other.bancoPagamento))
			return false;
		if (carenciaEmMeses == null) {
			if (other.carenciaEmMeses != null)
				return false;
		} else if (!carenciaEmMeses.equals(other.carenciaEmMeses))
			return false;
		if (classe == null) {
			if (other.classe != null)
				return false;
		} else if (!classe.equals(other.classe))
			return false;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
			return false;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (dataInicioVigencia == null) {
			if (other.dataInicioVigencia != null)
				return false;
		} else if (!dataInicioVigencia.equals(other.dataInicioVigencia))
			return false;
		if (dataTerminoVigencia == null) {
			if (other.dataTerminoVigencia != null)
				return false;
		} else if (!dataTerminoVigencia.equals(other.dataTerminoVigencia))
			return false;
		if (diaPagamento == null) {
			if (other.diaPagamento != null)
				return false;
		} else if (!diaPagamento.equals(other.diaPagamento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (situacaoAtual == null) {
			if (other.situacaoAtual != null)
				return false;
		} else if (!situacaoAtual.equals(other.situacaoAtual))
			return false;
		if (tipoSegurado == null) {
			if (other.tipoSegurado != null)
				return false;
		} else if (!tipoSegurado.equals(other.tipoSegurado))
			return false;
		if (valorPremio == null) {
			if (other.valorPremio != null)
				return false;
		} else if (!valorPremio.equals(other.valorPremio))
			return false;
		if (valorSegurado == null) {
			if (other.valorSegurado != null)
				return false;
		} else if (!valorSegurado.equals(other.valorSegurado))
			return false;
		return true;
	}
}