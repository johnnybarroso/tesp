package br.unibh.seguros.entidades;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Past;

@Entity
@Table(name = "tb_questionario")
public class Questionario implements Serializable{
	
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
	
	//TRUE setei para true para fazer teste
	@Column(name="portador_necessidades_especiais", columnDefinition="char(1)", nullable=false)
	private Character portadorNescessidadesEspeciais;
	
	//TRUE setei para true para fazer teste
	@Column(name="utiliza_remedio_controlado", columnDefinition="char(1)", nullable=false)
	private Character portadorMolestiaGrave;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_ultima_internacao", nullable=true)
	@Past
	private Date dataUltimaInternacao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_ultima_consulta_medica", nullable=true)
	@Past
	private Date dataUltimaConsultaMedica;
	
	//TRUE setei para true para fazer teste
	@Column(name="possui_plano_saude_particular", columnDefinition="char(1)", nullable=false)
	private Character possuiPlanoSaudeParticular;
	
	//TRUE setei para true para fazer teste
	@Column(name="pratica_esportes", columnDefinition="char(1)", nullable=false)
	private Character praticaEsportes;
	
	//TRUE setei para true para fazer teste
	@Column(name="executa_atividade_de_risco", columnDefinition="char(1)", nullable=false)
	private Character executaAtividadeDeRisco;
	
	//TRUE setei para true para fazer teste
	@Column(name="se_envolveu_em_acidente_ultimo_ano", columnDefinition="char(1)", nullable=false)
	private Character seEnvolveuEmAcidenteUltimoAno;
	
	//TRUE setei para true para fazer teste
	@Column(name="historico_cancer_familia", columnDefinition="char(1)", nullable=false)
	private Character historicoCancerFamilia;
	
	//TRUE setei para true para fazer teste
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

	public Questionario() {
		super();
	}

	public Questionario(Boolean portadorNescessidadesEspeciais, Boolean portadorMolestiaGrave,
			Date dataUltimaInternacao, Date dataUltimaConsultaMedica, Boolean possuiPlanoSaudeParticular,
			Boolean praticaEsportes, Boolean executaAtividadeDeRisco, Boolean seEnvolveuEmAcidenteUltimoAno,
			Boolean historicoCancerFamilia, Boolean possuiDoencaContagiosa) {
		super();
		setPortadorNescessidadesEspeciais(portadorNescessidadesEspeciais);
		setPortadorMolestiaGrave(portadorMolestiaGrave);
		this.dataUltimaInternacao = dataUltimaInternacao;
		this.dataUltimaConsultaMedica = dataUltimaConsultaMedica;
		setPossuiPlanoSaudeParticular(possuiPlanoSaudeParticular);
		setPraticaEsportes(praticaEsportes);
		setExecutaAtividadeDeRisco(executaAtividadeDeRisco);
		setSeEnvolveuEmAcidenteUltimoAno(seEnvolveuEmAcidenteUltimoAno);
		setHistoricoCancerFamilia(historicoCancerFamilia);
		setPossuiDoencaContagiosa(possuiDoencaContagiosa);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataUltimaConsultaMedica == null) ? 0 : dataUltimaConsultaMedica.hashCode());
		result = prime * result + ((dataUltimaInternacao == null) ? 0 : dataUltimaInternacao.hashCode());
		result = prime * result + ((executaAtividadeDeRisco == null) ? 0 : executaAtividadeDeRisco.hashCode());
		result = prime * result + ((historicoCancerFamilia == null) ? 0 : historicoCancerFamilia.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((portadorMolestiaGrave == null) ? 0 : portadorMolestiaGrave.hashCode());
		result = prime * result
				+ ((portadorNescessidadesEspeciais == null) ? 0 : portadorNescessidadesEspeciais.hashCode());
		result = prime * result + ((possuiDoencaContagiosa == null) ? 0 : possuiDoencaContagiosa.hashCode());
		result = prime * result + ((possuiPlanoSaudeParticular == null) ? 0 : possuiPlanoSaudeParticular.hashCode());
		result = prime * result + ((praticaEsportes == null) ? 0 : praticaEsportes.hashCode());
		result = prime * result
				+ ((seEnvolveuEmAcidenteUltimoAno == null) ? 0 : seEnvolveuEmAcidenteUltimoAno.hashCode());
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
		Questionario other = (Questionario) obj;
		if (dataUltimaConsultaMedica == null) {
			if (other.dataUltimaConsultaMedica != null)
				return false;
		} else if (!dataUltimaConsultaMedica.equals(other.dataUltimaConsultaMedica))
			return false;
		if (dataUltimaInternacao == null) {
			if (other.dataUltimaInternacao != null)
				return false;
		} else if (!dataUltimaInternacao.equals(other.dataUltimaInternacao))
			return false;
		if (executaAtividadeDeRisco == null) {
			if (other.executaAtividadeDeRisco != null)
				return false;
		} else if (!executaAtividadeDeRisco.equals(other.executaAtividadeDeRisco))
			return false;
		if (historicoCancerFamilia == null) {
			if (other.historicoCancerFamilia != null)
				return false;
		} else if (!historicoCancerFamilia.equals(other.historicoCancerFamilia))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (portadorMolestiaGrave == null) {
			if (other.portadorMolestiaGrave != null)
				return false;
		} else if (!portadorMolestiaGrave.equals(other.portadorMolestiaGrave))
			return false;
		if (portadorNescessidadesEspeciais == null) {
			if (other.portadorNescessidadesEspeciais != null)
				return false;
		} else if (!portadorNescessidadesEspeciais.equals(other.portadorNescessidadesEspeciais))
			return false;
		if (possuiDoencaContagiosa == null) {
			if (other.possuiDoencaContagiosa != null)
				return false;
		} else if (!possuiDoencaContagiosa.equals(other.possuiDoencaContagiosa))
			return false;
		if (possuiPlanoSaudeParticular == null) {
			if (other.possuiPlanoSaudeParticular != null)
				return false;
		} else if (!possuiPlanoSaudeParticular.equals(other.possuiPlanoSaudeParticular))
			return false;
		if (praticaEsportes == null) {
			if (other.praticaEsportes != null)
				return false;
		} else if (!praticaEsportes.equals(other.praticaEsportes))
			return false;
		if (seEnvolveuEmAcidenteUltimoAno == null) {
			if (other.seEnvolveuEmAcidenteUltimoAno != null)
				return false;
		} else if (!seEnvolveuEmAcidenteUltimoAno.equals(other.seEnvolveuEmAcidenteUltimoAno))
			return false;
		return true;
	}
}