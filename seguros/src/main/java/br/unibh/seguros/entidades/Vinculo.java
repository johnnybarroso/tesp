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

@Entity
@Table(name = "tb_vinculo")
public class Vinculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="tipo_vinculo",columnDefinition="varchar(30)", nullable=false)
	private String tipoVinculo;
	
	@Column(name="empresa",columnDefinition="varchar(30)", nullable=false)
	private String empresa;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_desde", nullable=false)
	private Date dataDesde;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_ate", nullable=true)
	private Date dataAte;
	
	@Column(name="cargo",columnDefinition="varchar(100)", nullable=false)
	private String cargo;
	
	@Column(name="salario",columnDefinition="decimal(14,2)", nullable=false)
	private String salario;
	
	@Column(name="pessoa_referencia",columnDefinition="varchar(100)", nullable=false)
	private String pessoaReferencia;
	
	@Column(name="telefone_referencia",columnDefinition="char(14)", nullable=false)
	private String telefoneReferencia;
	
	@Column(name="email_referencia",columnDefinition="varchar(100)", nullable=true)
	private String emailReferencia;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Proponente proponente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoVinculo() {
		return tipoVinculo;
	}

	public void setTipoVinculo(String tipoVinculo) {
		this.tipoVinculo = tipoVinculo;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Date getDataDesde() {
		return dataDesde;
	}

	public void setDataDesde(Date dataDesde) {
		this.dataDesde = dataDesde;
	}

	public Date getDataAte() {
		return dataAte;
	}

	public void setDataAte(Date dataAte) {
		this.dataAte = dataAte;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}

	public String getPessoaReferencia() {
		return pessoaReferencia;
	}

	public void setPessoaReferencia(String pessoaReferencia) {
		this.pessoaReferencia = pessoaReferencia;
	}

	public String getTelefoneReferencia() {
		return telefoneReferencia;
	}

	public void setTelefoneReferencia(String telefoneReferencia) {
		this.telefoneReferencia = telefoneReferencia;
	}

	public String getEmailReferencia() {
		return emailReferencia;
	}

	public void setEmailReferencia(String emailReferencia) {
		this.emailReferencia = emailReferencia;
	}

	public Proponente getProponente() {
		return proponente;
	}

	public void setProponente(Proponente proponente) {
		this.proponente = proponente;
	}
}