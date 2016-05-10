package br.unibh.seguros.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity @PrimaryKeyJoinColumn
@Table(name = "tb_dependente")
public class Dependente extends PessoaFisica implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name="grau_parentesco",columnDefinition="varchar(30)", nullable=false)
	@NotNull
	@Size(max = 30)
	@Pattern(regexp = "[A-zÀ-ú ]*", message = "Somente letras e espaços")
	private String grauParentesco;
	
	@Column(name="percentual_beneficio",columnDefinition="decimal(30)", nullable=false)
	@NotNull
	@DecimalMin("0.0")
	@DecimalMax("100.0")
	private String percentualBeneficio;
	
	//Tem que ser nulo, alterei para realizar o teste Perguntar ao professor
	@Column(name="dependente_ir", columnDefinition="char(1)", nullable=true)
	private Character dependenteIR;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Proponente proponente;


	public String getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(String grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	public String getPercentualBeneficio() {
		return percentualBeneficio;
	}

	public void setPercentualBeneficio(String percentualBeneficio) {
		this.percentualBeneficio = percentualBeneficio;
	}

	public Boolean getDependenteIR() {
		if (dependenteIR == null)
			return null;
		return dependenteIR == 'S' ? Boolean.TRUE : Boolean.FALSE;
		
	}

	public void setDependenteIR(Boolean dependenteIR) {
		if (dependenteIR == null){
			this.dependenteIR = null;
		}else {
			this.dependenteIR = dependenteIR == true ? 'S' : 'N';
		}
	}

	public Proponente getProponente() {
		return proponente;
	}

	public void setProponente(Proponente proponente) {
		this.proponente = proponente;
	}

	public void setDependenteIR(Character dependenteIR) {
		this.dependenteIR = dependenteIR;
	}

	public Dependente() {
		super();
	}

	public Dependente(String nome, String cpf, String telefoneComercial, String telefoneResidencial,
			String telefoneCelular, String email, String idade, Date data_nascimento, String grauParentesco,
			String percentualBeneficio, Character dependenteIR, Proponente proponente) {
		super(nome, cpf, telefoneComercial, telefoneResidencial, telefoneCelular, email, idade, data_nascimento);
		this.grauParentesco = grauParentesco;
		this.percentualBeneficio = percentualBeneficio;
		this.dependenteIR = dependenteIR;
		this.proponente = proponente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dependenteIR == null) ? 0 : dependenteIR.hashCode());
		result = prime * result + ((grauParentesco == null) ? 0 : grauParentesco.hashCode());
		result = prime * result + ((percentualBeneficio == null) ? 0 : percentualBeneficio.hashCode());
		result = prime * result + ((proponente == null) ? 0 : proponente.hashCode());
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
		Dependente other = (Dependente) obj;
		if (dependenteIR == null) {
			if (other.dependenteIR != null)
				return false;
		} else if (!dependenteIR.equals(other.dependenteIR))
			return false;
		if (grauParentesco == null) {
			if (other.grauParentesco != null)
				return false;
		} else if (!grauParentesco.equals(other.grauParentesco))
			return false;
		if (percentualBeneficio == null) {
			if (other.percentualBeneficio != null)
				return false;
		} else if (!percentualBeneficio.equals(other.percentualBeneficio))
			return false;
		if (proponente == null) {
			if (other.proponente != null)
				return false;
		} else if (!proponente.equals(other.proponente))
			return false;
		return true;
	}
}