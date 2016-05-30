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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "tb_vinculo")
public class Vinculo implements Serializable{
	
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
	
	@Column(name="tipo_vinculo",columnDefinition="varchar(30)", nullable=false)
	@NotNull
	@Size(max = 30)
	@Pattern(regexp = "[A-zA-ú ]*", message = "Somente letras e espaços")
	private String tipoVinculo;
	
	@Column(name="empresa",columnDefinition="varchar(30)", nullable=false)
	@NotNull
	@Size(max =120)
	@Pattern(regexp = "[A-zA-ú ]*", message = "Somente letras e espaços")
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
	@Pattern(regexp = "[A-zA-ú ]*", message = "Somente letras e espaços")
	@Size(max = 100)
	private String cargo;
	
	@Column(name="salario",columnDefinition="decimal(14,2)", nullable=false)
	@NotNull
	@DecimalMin("500.0")
	@DecimalMax("100000.00")
	private String salario;
	
	@Column(name="pessoa_referencia",columnDefinition="varchar(100)", nullable=false)
	@Size(max = 100)
	@Pattern(regexp = "[A-zA-ú ]*", message = "Somente letras e espaços")
	private String pessoaReferencia;
	
	@Column(name="telefone_referencia",columnDefinition="char(14)", nullable=false)
	@NotNull
	@Pattern(regexp="\\(\\d{2}\\)\\d{4}-\\d{4}")
	private String telefoneReferencia;
	
	@Column(name="email_referencia",columnDefinition="varchar(100)", nullable=true)
	@Email
	@Size(max = 100)
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
	
	public Vinculo() {
		super();
	}

	public Vinculo(String tipoVinculo, String empresa, Date dataDesde, Date dataAte, String cargo, String salario,
			String pessoaReferencia, String telefoneReferencia, String emailReferencia, Proponente proponente) {
		super();
		this.tipoVinculo = tipoVinculo;
		this.empresa = empresa;
		this.dataDesde = dataDesde;
		this.dataAte = dataAte;
		this.cargo = cargo;
		this.salario = salario;
		this.pessoaReferencia = pessoaReferencia;
		this.telefoneReferencia = telefoneReferencia;
		this.emailReferencia = emailReferencia;
		this.proponente = proponente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cargo == null) ? 0 : cargo.hashCode());
		result = prime * result + ((dataAte == null) ? 0 : dataAte.hashCode());
		result = prime * result + ((dataDesde == null) ? 0 : dataDesde.hashCode());
		result = prime * result + ((emailReferencia == null) ? 0 : emailReferencia.hashCode());
		result = prime * result + ((empresa == null) ? 0 : empresa.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pessoaReferencia == null) ? 0 : pessoaReferencia.hashCode());
		result = prime * result + ((salario == null) ? 0 : salario.hashCode());
		result = prime * result + ((telefoneReferencia == null) ? 0 : telefoneReferencia.hashCode());
		result = prime * result + ((tipoVinculo == null) ? 0 : tipoVinculo.hashCode());
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
		Vinculo other = (Vinculo) obj;
		if (cargo == null) {
			if (other.cargo != null)
				return false;
		} else if (!cargo.equals(other.cargo))
			return false;
		if (dataAte == null) {
			if (other.dataAte != null)
				return false;
		} else if (!dataAte.equals(other.dataAte))
			return false;
		if (dataDesde == null) {
			if (other.dataDesde != null)
				return false;
		} else if (!dataDesde.equals(other.dataDesde))
			return false;
		if (emailReferencia == null) {
			if (other.emailReferencia != null)
				return false;
		} else if (!emailReferencia.equals(other.emailReferencia))
			return false;
		if (empresa == null) {
			if (other.empresa != null)
				return false;
		} else if (!empresa.equals(other.empresa))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pessoaReferencia == null) {
			if (other.pessoaReferencia != null)
				return false;
		} else if (!pessoaReferencia.equals(other.pessoaReferencia))
			return false;
		if (salario == null) {
			if (other.salario != null)
				return false;
		} else if (!salario.equals(other.salario))
			return false;
		if (telefoneReferencia == null) {
			if (other.telefoneReferencia != null)
				return false;
		} else if (!telefoneReferencia.equals(other.telefoneReferencia))
			return false;
		if (tipoVinculo == null) {
			if (other.tipoVinculo != null)
				return false;
		} else if (!tipoVinculo.equals(other.tipoVinculo))
			return false;
		return true;
	}
}