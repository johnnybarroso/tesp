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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((membro == null) ? 0 : membro.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((setorSuperior == null) ? 0 : setorSuperior.hashCode());
		result = prime * result + ((tramitacoes == null) ? 0 : tramitacoes.hashCode());
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
		Setor other = (Setor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (membro == null) {
			if (other.membro != null)
				return false;
		} else if (!membro.equals(other.membro))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (setorSuperior == null) {
			if (other.setorSuperior != null)
				return false;
		} else if (!setorSuperior.equals(other.setorSuperior))
			return false;
		if (tramitacoes == null) {
			if (other.tramitacoes != null)
				return false;
		} else if (!tramitacoes.equals(other.tramitacoes))
			return false;
		return true;
	}
}