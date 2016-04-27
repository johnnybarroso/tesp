package br.unibh.seguros.entidades;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "tb_setor")
public class Setor implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome",columnDefinition="varchar(150)", nullable=false, unique=true)
	@NotNull
	@Size(min = 3, max = 150)
	@Pattern(regexp = "[A-zÀ-ú ]*", message = "Deve conter apenas letras e espaços")
	private String nome;
	
	@OneToOne(optional=true)
	@JoinColumn(name="setor_superior_id")
	private Setor setorSuperior;
	
	@OneToMany(mappedBy="setor", fetch=FetchType.LAZY)
	private Collection<Usuario> membro;
	
	@OneToMany(mappedBy="setorResponsavel", fetch=FetchType.LAZY)
	private Collection<Tramitacao> tramitacoes;

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

	public Setor getSetorSuperior() {
		return setorSuperior;
	}

	public void setSetorSuperior(Setor setorSuperior) {
		this.setorSuperior = setorSuperior;
	}

	public Collection<Usuario> getMembro() {
		return membro;
	}

	public void setMembro(Collection<Usuario> membro) {
		this.membro = membro;
	}
	

	public Collection<Tramitacao> getTramitacoes() {
		return tramitacoes;
	}

	public void setTramitacoes(Collection<Tramitacao> tramitacoes) {
		this.tramitacoes = tramitacoes;
	}

	@Override
	public String toString() {
		return "Setor [id=" + id + ", nome=" + nome + ", setorSuperior=" + setorSuperior + ", membro=" + membro
				+ ", tramitacoes=" + tramitacoes + "]";
	}
}