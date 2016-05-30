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
import javax.persistence.Version;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_endereco")
public class Endereco implements Serializable {

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

	@Column(name = "tipo", columnDefinition = "varchar(30)", nullable = false)
	@NotNull
	@Size(max = 30)
	@Pattern(regexp = "[A-zÀ-ú ]*", message = "Somente letras e espaços")
	private String tipo;

	@Column(name = "cep", columnDefinition = "char(8)", nullable = false)
	@NotNull
	@Pattern(regexp = "\\d{8}", message = "O cep deve ter 8 numeros")
	private String cep;

	@Column(name = "tipo_logradouro", columnDefinition = "varchar(30)", nullable = false)
	@NotNull
	@Size(max = 30)
	@Pattern(regexp = "[A-zÀ-ú ]*", message = "Somente letras e espaços")
	private String tipoLogradouro;

	@Column(name = "logradouro", columnDefinition = "varchar(150)", nullable = false)
	@NotNull
	@Size(max = 150)
	@Pattern(regexp = "[A-zÀ-ú ]*", message = "Somente letras e espaços")
	private String logradouro;

	@Column(name = "numero", columnDefinition = "varchar(30)", nullable = false)
	@NotNull
	@Size(max = 30)
	private String numero;

	@Column(name = "complemento", columnDefinition = "varchar(100)", nullable = true)
	@Size(max = 100)
	private String complemento;

	@Column(name = "cidade", columnDefinition = "varchar(100)", nullable = true)
	@NotNull
	@Size(max = 100)
	@Pattern(regexp = "[A-zÀ-ú ]*", message = "Somente letras e espaços")
	private String cidade;

	@Column(name = "estado", columnDefinition = "char(2)", nullable = false)
	@NotNull
	@Pattern(regexp = "[A-Z]{2}", message = "Somente letras maisculas")
	private String estado;

	@ManyToOne(fetch = FetchType.EAGER)
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

	public Endereco() {

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((cidade == null) ? 0 : cidade.hashCode());
		result = prime * result + ((complemento == null) ? 0 : complemento.hashCode());
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((logradouro == null) ? 0 : logradouro.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((tipoLogradouro == null) ? 0 : tipoLogradouro.hashCode());
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
		Endereco other = (Endereco) obj;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (estado == null) {
			if (other.estado != null)
				return false;
		} else if (!estado.equals(other.estado))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (logradouro == null) {
			if (other.logradouro != null)
				return false;
		} else if (!logradouro.equals(other.logradouro))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (tipoLogradouro == null) {
			if (other.tipoLogradouro != null)
				return false;
		} else if (!tipoLogradouro.equals(other.tipoLogradouro))
			return false;
		return true;
	}
}