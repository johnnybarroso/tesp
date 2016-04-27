package br.unibh.seguros.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity @PrimaryKeyJoinColumn
@Table(name = "tb_proponente")
public class Proponente extends PessoaFisica implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name="matricula",columnDefinition="char(8)", nullable=false, unique=true)
	@NotNull
	@Size(min = 5, max = 8)
	@Pattern(regexp = "[0-9]*", message = "O campo aceita somente números")
	private String matricula;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_cadastro", nullable=false)
	private Date data_cadastro;
	
	@Column(name="situacao_cadastro",columnDefinition="varchar(30)", nullable=false, unique=true)
	@NotNull
	@Pattern(regexp = "[A-zÀ-ú ]*", message = "Somente letras e espaços")
	private String situacaoCadastro;
	
	@Column(name="status",columnDefinition="varchar(30)", nullable=false)
	@NotNull
	@Size(max = 30)
	@Pattern(regexp = "[A-zÀ-ú ]*", message = "Somente letras e espaços")
	private String status;
	
	@OneToMany(mappedBy="proponente", fetch=FetchType.LAZY)
	private Collection<Endereco> enderecos;
	
	@OneToMany(mappedBy="proponente", fetch=FetchType.LAZY)
	private Collection<Dependente> dependente;
	
	@OneToMany(mappedBy="proponente", fetch=FetchType.LAZY)
	private Collection<Vinculo> vinculos;
	
	@OneToMany(mappedBy="proponente", fetch=FetchType.LAZY)
	private Collection<Seguro> seguros;
	
	@OneToMany(mappedBy="proponente", fetch=FetchType.LAZY)
	private Collection<Proposta> propostas;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Date getData_cadastro() {
		return data_cadastro;
	}

	public void setData_cadastro(Date data_cadastro) {
		this.data_cadastro = data_cadastro;
	}

	public String getSituacaoCadastro() {
		return situacaoCadastro;
	}

	public void setSituacaoCadastro(String situacaoCadastro) {
		this.situacaoCadastro = situacaoCadastro;
	}

	public Collection<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(Collection<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Collection<Dependente> getDependente() {
		return dependente;
	}

	public void setDependente(Collection<Dependente> dependente) {
		this.dependente = dependente;
	}

	public Collection<Vinculo> getVinculos() {
		return vinculos;
	}

	public void setVinculos(Collection<Vinculo> vinculos) {
		this.vinculos = vinculos;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Proponente() {
		super();
	}
	
	
	
	public Proponente(String nome, String cpf, String telefoneComercial, String telefoneResidencial,
			String telefoneCelular, String email, String idade, Date data_nascimento, String matricula,
			Date data_cadastro, String situacaoCadastro, String status) {
		super(nome, cpf, telefoneComercial, telefoneResidencial, telefoneCelular, email, idade, data_nascimento);
		this.matricula = matricula;
		this.data_cadastro = data_cadastro;
		this.situacaoCadastro = situacaoCadastro;
		this.status = status;
	}
	
	public Proponente(String nome, String cpf, String telefoneComercial, String telefoneResidencial,
			String telefoneCelular, String email, String idade, Date data_nascimento, String matricula,
			Date data_cadastro, String situacaoCadastro, String status, Collection<Endereco> enderecos,
			Collection<Dependente> dependente, Collection<Vinculo> vinculos, Collection<Seguro> seguros,
			Collection<Proposta> propostas) {
		super(nome, cpf, telefoneComercial, telefoneResidencial, telefoneCelular, email, idade, data_nascimento);
		this.matricula = matricula;
		this.data_cadastro = data_cadastro;
		this.situacaoCadastro = situacaoCadastro;
		this.status = status;
		this.enderecos = enderecos;
		this.dependente = dependente;
		this.vinculos = vinculos;
		this.seguros = seguros;
		this.propostas = propostas;
	}
	
	

}
