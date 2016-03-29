package br.unibh.seguros.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tb_endereco")
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="tipo",columnDefinition="varchar(30)", nullable=false)
	private String tipo;
	
	@Column(name="cep",columnDefinition="char(8)", nullable=false)
	private String cep;
	
	@Column(name="tipo_logradouro",columnDefinition="varchar(30)", nullable=false)
	private String tipoLogradouro;
	
	@Column(name="numero",columnDefinition="varchar(30)", nullable=false)
	private String numero;
	
	@Column(name="complemento",columnDefinition="varchar(100)", nullable=true)
	private String complemento;
	
	@Column(name="cidade",columnDefinition="varchar(100)", nullable=true)
	private String cidade;
	
	@Column(name="estado",columnDefinition="char(2)", nullable=false)
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

}