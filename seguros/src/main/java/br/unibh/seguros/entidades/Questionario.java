package br.unibh.seguros.entidades;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_questionario")
public class Questionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="portador_necessidades_especiais", columnDefinition="char(1)", nullable=false)
	private Character portadorNescessidadesEspeciais;
	
	@Column(name="utiliza_remedio_controlado", columnDefinition="char(1)", nullable=false)
	private Character portadorMolestiaGrave;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_ultima_internacao", nullable=true)
	private Date dataUltimaInternacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_ultima_consulta_medica", nullable=true)
	private Date dataUltimaConsultaMedica;
	
	@Column(name="possui_plano_saude_particular", columnDefinition="char(1)", nullable=false)
	private Character possuiPlanoSaudeParticular;
	
	@Column(name="pratica_esportes", columnDefinition="char(1)", nullable=false)
	private Character praticaEsportes;
	
	@Column(name="executa_atividade_de_risco", columnDefinition="char(1)", nullable=false)
	private Character executaAtividadeDeRisco;
	
	@Column(name="se_envolveu_em_acidente_ultimo_ano", columnDefinition="char(1)", nullable=false)
	private Character seEnvolveuEmAcidenteUltimoAno;
	
	@Column(name="historico_cancer_familia", columnDefinition="char(1)", nullable=false)
	private Character historicoCancerFamilia;
	
	@Column(name="possui_doenca_contagiosa", columnDefinition="char(1)", nullable=false)
	private Character possuiDoencaContagiosa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getPortadorNescessidadesEspeciais() {
		if (portadorNescessidadesEspeciais == null)
			return null;
		return portadorNescessidadesEspeciais == 'S' ? Boolean.TRUE : Boolean.FALSE;
		
	}

	public void setPortadorNescessidadesEspeciais(Boolean portadorNescessidadesEspeciais) {
		if (portadorNescessidadesEspeciais == null){
			this.portadorNescessidadesEspeciais = null;
		}else {
			this.portadorNescessidadesEspeciais = portadorNescessidadesEspeciais == true ? 'S' : 'N';
		}
	}

	public Boolean getPortadorMolestiaGrave() {
		if(portadorMolestiaGrave == null)
			return null;
		return portadorMolestiaGrave == 'S' ? Boolean.TRUE : Boolean.FALSE;
	}

	public void setPortadorMolestiaGrave(Boolean portadorMolestiaGrave) {
		if(portadorMolestiaGrave == null){
			this.portadorMolestiaGrave = null;
		}else {
			this.portadorMolestiaGrave = portadorMolestiaGrave == true ? 'S' : 'N';
		}
	}

	public Date getDataUltimaInternacao() {
		return dataUltimaInternacao;
	}

	public void setDataUltimaInternacao(Date dataUltimaInternacao) {
		this.dataUltimaInternacao = dataUltimaInternacao;
	}

	public Date getDataUltimaConsultaMedica() {
		return dataUltimaConsultaMedica;
	}

	public void setDataUltimaConsultaMedica(Date dataUltimaConsultaMedica) {
		this.dataUltimaConsultaMedica = dataUltimaConsultaMedica;
	}

	public Boolean getPossuiPlanoSaudeParticular() {
		if(possuiPlanoSaudeParticular == null)
			return null;
		return possuiPlanoSaudeParticular == 'S' ? Boolean.TRUE : Boolean.FALSE;
	}

	public void setPossuiPlanoSaudeParticular(Boolean possuiPlanoSaudeParticular) {
		if(possuiPlanoSaudeParticular == null){
			this.possuiPlanoSaudeParticular = null;
		} else{
			this.possuiPlanoSaudeParticular = possuiPlanoSaudeParticular == true ? 'S' : 'N';
		}
	}

	public Boolean getPraticaEsportes() {
		if(praticaEsportes == null)
			return null;
		return praticaEsportes == 'S' ? Boolean.TRUE : Boolean.FALSE;
	}

	public void setPraticaEsportes(Boolean praticaEsportes) {
		if(praticaEsportes == null){
			this.praticaEsportes = null;
		} else{ 
			this.praticaEsportes = praticaEsportes == true ? 'S' : 'N';
		}
	}

	public Boolean getExecutaAtividadeDeRisco() {
		if(executaAtividadeDeRisco == null)
			return null;
		return executaAtividadeDeRisco == 'S' ? Boolean.TRUE : Boolean.FALSE;
	}

	public void setExecutaAtividadeDeRisco(Boolean executaAtividadeDeRisco) {
		if(executaAtividadeDeRisco == null){
			this.executaAtividadeDeRisco = null;
		} else{ 
			this.executaAtividadeDeRisco = executaAtividadeDeRisco == true ? 'S' : 'N';
		}
	}

	public Boolean getSeEnvolveuEmAcidenteUltimoAno() {
		if(seEnvolveuEmAcidenteUltimoAno == null)
			return null;
		return seEnvolveuEmAcidenteUltimoAno == 'S' ? Boolean.TRUE : Boolean.FALSE;
	}

	public void setSeEnvolveuEmAcidenteUltimoAno(Boolean seEnvolveuEmAcidenteUltimoAno) {
		if(seEnvolveuEmAcidenteUltimoAno == null){
			this.seEnvolveuEmAcidenteUltimoAno = null;
		} else{ 
			this.seEnvolveuEmAcidenteUltimoAno = seEnvolveuEmAcidenteUltimoAno == true ? 'S' : 'N';
		}
	}

	public Boolean getHistoricoCancerFamilia() {
		if(historicoCancerFamilia == null)
			return null;
		return historicoCancerFamilia == 'S' ? Boolean.TRUE : Boolean.FALSE;
	}
	
	public void setHistoricoCancerFamilia(Boolean historicoCancerFamilia) {
		if(historicoCancerFamilia == null){
			this.historicoCancerFamilia = null;
		} else{ 
			this.historicoCancerFamilia = historicoCancerFamilia == true ? 'S' : 'N';
		}
	}

	public Boolean getPossuiDoencaContagiosa() {
		if(possuiDoencaContagiosa == null)
			return null;
		return possuiDoencaContagiosa == 'S' ? Boolean.TRUE : Boolean.FALSE;
	}

	public void setPossuiDoencaContagiosa(Boolean possuiDoencaContagiosa) {
		if(possuiDoencaContagiosa == null){
			this.possuiDoencaContagiosa = null;
		} else{ 
			this.possuiDoencaContagiosa = possuiDoencaContagiosa == true ? 'S' : 'N';
		}
	}

	public void setPortadorNescessidadesEspeciais(Character portadorNescessidadesEspeciais) {
		this.portadorNescessidadesEspeciais = portadorNescessidadesEspeciais;
	}

	@Override
	public String toString() {
		return "Questionario [id=" + id + ", portadorNescessidadesEspeciais=" + portadorNescessidadesEspeciais
				+ ", portadorMolestiaGrave=" + portadorMolestiaGrave + ", dataUltimaInternacao=" + dataUltimaInternacao
				+ ", dataUltimaConsultaMedica=" + dataUltimaConsultaMedica + ", possuiPlanoSaudeParticular="
				+ possuiPlanoSaudeParticular + ", praticaEsportes=" + praticaEsportes + ", executaAtividadeDeRisco="
				+ executaAtividadeDeRisco + ", seEnvolveuEmAcidenteUltimoAno=" + seEnvolveuEmAcidenteUltimoAno
				+ ", historicoCancerFamilia=" + historicoCancerFamilia + ", possuiDoencaContagiosa="
				+ possuiDoencaContagiosa + "]";
	}
}