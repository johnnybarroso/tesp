package br.unibh.seguros.entidades;

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

@Entity @PrimaryKeyJoinColumn
@Table(name = "tb_proponente")
public class Proponente extends PessoaFisica{
	
	@Column(name="matricula",columnDefinition="char(8)", nullable=false, unique=true)
	private String matricula;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_cadastro", nullable=false)
	private Date data_cadastro;
	
	@Column(name="situacao_cadastro",columnDefinition="varchar(30)", nullable=false, unique=true)
	private String situacaoCadastro;
	
	@Column(name="status",columnDefinition="varchar(30)", nullable=false)
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
}
