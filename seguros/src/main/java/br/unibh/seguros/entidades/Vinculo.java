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
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "tb_vinculo")
public class Vinculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="tipo_vinculo",columnDefinition="varchar(30)", nullable=false)
	@NotNull
	@Max(30)
	@Pattern(regexp = "[A-zA-ú ]", message = "Somente letras e espaços")
	private String tipoVinculo;
	
	@Column(name="empresa",columnDefinition="varchar(30)", nullable=false)
	@NotNull
	@Max(120)
	@Pattern(regexp = "[A-zA-ú ]", message = "Somente letras e espaços")
	private String empresa;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_desde", nullable=false)
	@NotNull
	@Past
	private Date dataDesde;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_ate", nullable=true)
	@Past
	private Date dataAte;
	
	@Column(name="cargo",columnDefinition="varchar(100)", nullable=false)
	@NotNull
	@Pattern(regexp = "[A-zA-ú ]", message = "Somente letras e espaços")
	@Max(100)
	private String cargo;
	
	@Column(name="salario",columnDefinition="decimal(14,2)", nullable=false)
	@NotNull
	@DecimalMin("500.0")
	@DecimalMax("100000.00")
	private String salario;
	
	@Column(name="pessoa_referencia",columnDefinition="varchar(100)", nullable=false)
	@Max(100)
	@Pattern(regexp = "[A-zA-ú ]", message = "Somente letras e espaços")
	private String pessoaReferencia;
	
	@Column(name="telefone_referencia",columnDefinition="char(14)", nullable=false)
	@NotNull
	@Pattern(regexp="\\(\\d{2}\\)\\d{4}-\\d{4}")
	private String telefoneReferencia;
	
	@Column(name="email_referencia",columnDefinition="varchar(100)", nullable=true)
	@Email
	@Max(100)
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