package br.unibh.seguros.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity @PrimaryKeyJoinColumn
@Table(name = "tb_dependente")
public class Dependente extends PessoaFisica{
	
	@Column(name="grau_parentesco",columnDefinition="varchar(30)", nullable=false)
	private String nome;
	
	@Column(name="percentual_beneficio",columnDefinition="decimal(30)", nullable=false)
	private String percentualBeneficio;
	
	@Column(name="dependente_ir", columnDefinition="char(1)", nullable=false)
	private Character dependenteIR;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Proponente proponente;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	
}