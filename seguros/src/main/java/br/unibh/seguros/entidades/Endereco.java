package br.unibh.seguros.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


@Entity
@Table(name = "tb_endereco")
public class Endereco implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="tipo",columnDefinition="varchar(30)", nullable=false)
	@NotNull
	@Max(30)
	@Pattern(regexp = "[A-zÀ-ú ]", message = "Somente letras e espaços")
	private String tipo;
	
	@Column(name="cep",columnDefinition="char(8)", nullable=false)
	@NotNull
	@Pattern(regexp="\\d{8}", message = "O cep deve ter 8 numeros")
	private String cep;
	
	@Column(name="tipo_logradouro",columnDefinition="varchar(30)", nullable=false)
	@NotNull
	@Max(30)
	@Pattern(regexp = "[A-zÀ-ú ]", message = "Somente letras e espaços")
	private String tipoLogradouro;
	
	@Column(name="logradouro",columnDefinition="varchar(150)", nullable=false)
	@NotNull
	@Max(150)
	@Pattern(regexp = "[A-zÀ-ú ]", message = "Somente letras e espaços")
	private String logradouro;
	
	@Column(name="numero",columnDefinition="varchar(30)", nullable=false)
	@NotNull
	@Max(30)
	private String numero;
	
	@Column(name="complemento",columnDefinition="varchar(100)", nullable=true)
	@Max(100)
	private String complemento;
	
	@Column(name="cidade",columnDefinition="varchar(100)", nullable=true)
	@NotNull
	@Max(100)
	@Pattern(regexp = "[A-zÀ-ú ]", message = "Somente letras e espaços")
	private String cidade;
	
	@Column(name="estado",columnDefinition="char(2)", nullable=false)
	@NotNull
	@Pattern(regexp = "[A-Z]{2}", message = "Somente letras maisculas")
	private String estado;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Proponente proponente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTipoLogradouro() {
		return tipoLogradouro;
	}

	public void setTipoLogradouro(String tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Proponente getPreponente() {
		return proponente;
	}

	public void setPreponente(Proponente preponente) {
		this.proponente = preponente;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Endereco(){
		
	}
	
	public Endereco(String tipo, String cep, String tipoLogradouro, String logradouro, String numero,
			String complemento, String cidade, String estado, Proponente proponente) {
		super();
		this.tipo = tipo;
		this.cep = cep;
		this.tipoLogradouro = tipoLogradouro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cidade = cidade;
		this.estado = estado;
		this.proponente = proponente;
	}
}