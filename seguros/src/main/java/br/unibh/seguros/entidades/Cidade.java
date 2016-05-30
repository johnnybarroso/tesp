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
import javax.persistence.Version;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Range;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tb_cidade")
public class Cidade implements Serializable {

	@Version
	@Column(columnDefinition = "bigint NOT NULL DEFAULT 0")
	private Long version;

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "estado", columnDefinition = "char(2)", nullable = false)
	@NotNull
	@Pattern(regexp = "[A-Z]{2}", message = "Somente letras maisculas")
	private String estado;

	@Column(name = "cidade", columnDefinition = "varchar(100)", nullable = true)
	@NotNull
	@Size(max = 100)
	@Pattern(regexp = "[A-zÀ-ú ]*", message = "Somente letras e espaços")
	private String cidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Cidade() {
		super();
	}

	public Cidade(String estado, String cidade) {
		super();
		this.estado = estado;
		this.cidade = cidade;
	}
}