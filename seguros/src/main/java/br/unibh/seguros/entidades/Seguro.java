package br.unibh.seguros.entidades;

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
@Table(name = "tb_seguro")
@NamedQuery(name="Seguro.findByName", query = "select o from Seguro o where o.codigoSusep like :codigoSusep")
public class Seguro implements Serializable{
	
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
	
	@Column(name="codigo_susep",columnDefinition="char(15)", nullable=false, unique=true)
	@NotNull
	@Size(max = 15)
	private String codigoSusep;

	@Column(name="tipo_segurado",columnDefinition="varchar(30)", nullable=false)
	@Pattern(regexp = "[A-zÀ-ú ]*", message = "Somente letras e espaços")
	@Size(max = 30)
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
	@Size(max = 30)
	@Pattern(regexp = "[A-zÀ-ú ]*", message = "Somente letras e espaços")
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
	
	@NotNull
	@Size(max = 15)
	@Column(name="agencia", columnDefinition="varchar(15)", nullable=false)
	private String agencia;
	
	@Column(name="conta", columnDefinition="varchar(15)", nullable=false)
	@NotNull
	@Size(max = 50)
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

	public Seguro()
	{
		super();
	}
	
	public Seguro(String codigoSusep, String tipoSegurado, String valorSegurado, String classe, Date dataInicioVigencia,
			Date dataTerminoVigencia, String carenciaEmMeses, String situacaoAtual, String valorPremio,
			String diaPagamento, String bancoPagamento, String agencia, String conta, Proponente proponente) {
		super();
		this.codigoSusep = codigoSusep;
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
		result = prime * result + ((codigoSusep == null) ? 0 : codigoSusep.hashCode());
		result = prime * result + ((conta == null) ? 0 : conta.hashCode());
		result = prime * result + ((dataInicioVigencia == null) ? 0 : dataInicioVigencia.hashCode());
		result = prime * result + ((dataTerminoVigencia == null) ? 0 : dataTerminoVigencia.hashCode());
		result = prime * result + ((diaPagamento == null) ? 0 : diaPagamento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((situacaoAtual == null) ? 0 : situacaoAtual.hashCode());
		result = prime * result + ((tipoSegurado == null) ? 0 : tipoSegurado.hashCode());
		result = prime * result + ((valorPremio == null) ? 0 : valorPremio.hashCode());
		result = prime * result + ((valorSegurado == null) ? 0 : valorSegurado.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		Seguro other = (Seguro) obj;
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
		if (codigoSusep == null) {
			if (other.codigoSusep != null)
				return false;
		} else if (!codigoSusep.equals(other.codigoSusep))
			return false;
		if (conta == null) {
			if (other.conta != null)
				return false;
		} else if (!conta.equals(other.conta))
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
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
}
