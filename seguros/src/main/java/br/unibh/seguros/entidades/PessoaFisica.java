package br.unibh.seguros.entidades;
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
public class PessoaFisica {
	
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
	@Max(100)
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
}