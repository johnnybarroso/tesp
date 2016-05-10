package br.unibh.seguros.entidades;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;

@Entity @Inheritance(strategy=InheritanceType.JOINED)
@Table(name = "tb_pessoa_fisica", uniqueConstraints = @UniqueConstraint(columnNames = "cpf"))
public class PessoaFisica implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, String cpf, String telefoneComercial, String telefoneResidencial,
			String telefoneCelular, String email, String idade, Date data_nascimento) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefoneComercial = telefoneComercial;
		this.telefoneResidencial = telefoneResidencial;
		this.telefoneCelular = telefoneCelular;
		this.email = email;
		this.idade = idade;
		this.data_nascimento = data_nascimento;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome",columnDefinition="varchar(100)", nullable=false)
	@NotNull
	@Size(min = 5, max = 100)
	@Pattern(regexp = "[A-zÀ-ú ]*", message = "Deve conter apenas letras e espaços")
	private String nome;
	
	@Column(name="cpf",columnDefinition="char(11)", nullable=false)
	@NotNull
	@Pattern(regexp="\\d{11}")
	private String cpf;
	
	@Column(name="telefone_comercial",columnDefinition="char(14)", nullable=true)
	@NotNull
	@Pattern(regexp="\\(\\d{2}\\)\\d{4}-\\d{4}")
	private String telefoneComercial;
	
	@Column(name="telefone_residencial",columnDefinition="char(14)", nullable=false)
	@NotNull
	@Pattern(regexp="\\(\\d{2}\\)\\d{4}-\\d{4}")
	private String telefoneResidencial;
	
	@Column(name="telefone_celular",columnDefinition="char(14)", nullable=true)
	@Pattern(regexp="\\(\\d{2}\\)\\d{4}-\\d{4}")
	private String telefoneCelular;
	
	@Column(name="email",columnDefinition="varchar(100)", nullable=true)
	@Email
	@Size(max = 100)
	private String email;
	
	@Column(name="idade",columnDefinition="integer", nullable=false)
	@Range(min=18, max=99)
	private String idade;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_nascimento", nullable=false)
	@NotNull
	@Past
	private Date data_nascimento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdade() {
		return idade;
	}

	public void setIdade(String idade) {
		this.idade = idade;
	}

	public Date getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(Date data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	@Override
	public String toString() {
		return "PessoaFisica [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", telefoneComercial=" + telefoneComercial
				+ ", telefoneResidencial=" + telefoneResidencial + ", telefoneCelular=" + telefoneCelular + ", email="
				+ email + ", idade=" + idade + ", data_nascimento=" + data_nascimento + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((data_nascimento == null) ? 0 : data_nascimento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idade == null) ? 0 : idade.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefoneCelular == null) ? 0 : telefoneCelular.hashCode());
		result = prime * result + ((telefoneComercial == null) ? 0 : telefoneComercial.hashCode());
		result = prime * result + ((telefoneResidencial == null) ? 0 : telefoneResidencial.hashCode());
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
		PessoaFisica other = (PessoaFisica) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (data_nascimento == null) {
			if (other.data_nascimento != null)
				return false;
		} else if (!data_nascimento.equals(other.data_nascimento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idade == null) {
			if (other.idade != null)
				return false;
		} else if (!idade.equals(other.idade))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (telefoneCelular == null) {
			if (other.telefoneCelular != null)
				return false;
		} else if (!telefoneCelular.equals(other.telefoneCelular))
			return false;
		if (telefoneComercial == null) {
			if (other.telefoneComercial != null)
				return false;
		} else if (!telefoneComercial.equals(other.telefoneComercial))
			return false;
		if (telefoneResidencial == null) {
			if (other.telefoneResidencial != null)
				return false;
		} else if (!telefoneResidencial.equals(other.telefoneResidencial))
			return false;
		return true;
	}
}