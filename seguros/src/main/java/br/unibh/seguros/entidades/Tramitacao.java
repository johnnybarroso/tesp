package br.unibh.seguros.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tb_tramitacao")
@NamedQuery(name="Tramitacao.findByName", query = "select o from Tramitacao o where o.etapaProcesso like :etapaProcesso")
public class Tramitacao implements Serializable{

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
	
	@Column(name="etapa_processo",columnDefinition="varchar(30)", nullable=false)
	@NotNull
	@Pattern(regexp = "[A-zÀ-ú ]*", message = "Somente letras e espaços")
	@Size(max =30)
	private String etapaProcesso;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_hora", nullable=false)
	private Date dataHora;
	
	@Column(name="situacao_inicial",columnDefinition="varchar(50)", nullable=false)
	@NotNull
	@Pattern(regexp = "[A-zÀ-ú ]*", message = "Somente letras e espaços")
	@Size(max = 50)
	private String situacaoInicial;
	
	@Column(name="situacao_final",columnDefinition="varchar(50)", nullable=false)
	@Pattern(regexp = "[A-zÀ-ú ]*", message = "Somente letras e espaços")
	@NotNull
	@Size(max = 50)
	private String situacaoFinal;
	
	@Column(name="tipo_decisao",columnDefinition="varchar(100)", nullable=false)
	@NotNull
	@Size(max = 100)
	@Pattern(regexp = "[A-zÀ-ú ]*", message = "Somente letras e espaços")
	private String tipoDecisao;
	
	@Column(name="comentario",columnDefinition="varchar(4000)", nullable=true)
	@Pattern(regexp = "[A-zÀ-ú ]*", message = "Somente letras e espaços")
	@Size(max = 4000)
	private String comentario;
	
	@Column(name="documento",columnDefinition="blob", nullable=true)
	private String documento;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Proposta proposta;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Setor setorResponsavel;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Usuario usuarioDecisao;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Tramitacao tramitacoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEtapaProcesso() {
		return etapaProcesso;
	}

	public void setEtapaProcesso(String etapaProcesso) {
		this.etapaProcesso = etapaProcesso;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public String getSituacaoInicial() {
		return situacaoInicial;
	}

	public void setSituacaoInicial(String situacaoInicial) {
		this.situacaoInicial = situacaoInicial;
	}

	public String getSituacaoFinal() {
		return situacaoFinal;
	}

	public void setSituacaoFinal(String situacaoFinal) {
		this.situacaoFinal = situacaoFinal;
	}

	public String getTipoDecisao() {
		return tipoDecisao;
	}

	public void setTipoDecisao(String tipoDecisao) {
		this.tipoDecisao = tipoDecisao;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
	
	public Usuario getUsuarioDecisao() {
		return usuarioDecisao;
	}

	public void setUsuarioDecisao(Usuario usuarioDecisao) {
		this.usuarioDecisao = usuarioDecisao;
	}

	public Setor getSetorResponsavel() {
		return setorResponsavel;
	}

	public void setSetorResponsavel(Setor setorResponsavel) {
		this.setorResponsavel = setorResponsavel;
	}

	public Proposta getPropostas() {
		return proposta;
	}

	public void setPropostas(Proposta propostas) {
		this.proposta = propostas;
	}

	public Tramitacao() {
		super();
	}

	public Tramitacao(String etapaProcesso, Date dataHora, String situacaoInicial, String situacaoFinal,
			String tipoDecisao, String comentario, String documento, Proposta proposta, Setor setorResponsavel,
			Usuario usuarioDecisao, Tramitacao tramitacoes) {
		super();
		this.etapaProcesso = etapaProcesso;
		this.dataHora = dataHora;
		this.situacaoInicial = situacaoInicial;
		this.situacaoFinal = situacaoFinal;
		this.tipoDecisao = tipoDecisao;
		this.comentario = comentario;
		this.documento = documento;
		this.proposta = proposta;
		this.setorResponsavel = setorResponsavel;
		this.usuarioDecisao = usuarioDecisao;
		this.tramitacoes = tramitacoes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((dataHora == null) ? 0 : dataHora.hashCode());
		result = prime * result + ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((etapaProcesso == null) ? 0 : etapaProcesso.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((situacaoFinal == null) ? 0 : situacaoFinal.hashCode());
		result = prime * result + ((situacaoInicial == null) ? 0 : situacaoInicial.hashCode());
		result = prime * result + ((tipoDecisao == null) ? 0 : tipoDecisao.hashCode());
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
		Tramitacao other = (Tramitacao) obj;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (dataHora == null) {
			if (other.dataHora != null)
				return false;
		} else if (!dataHora.equals(other.dataHora))
			return false;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (etapaProcesso == null) {
			if (other.etapaProcesso != null)
				return false;
		} else if (!etapaProcesso.equals(other.etapaProcesso))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (situacaoFinal == null) {
			if (other.situacaoFinal != null)
				return false;
		} else if (!situacaoFinal.equals(other.situacaoFinal))
			return false;
		if (situacaoInicial == null) {
			if (other.situacaoInicial != null)
				return false;
		} else if (!situacaoInicial.equals(other.situacaoInicial))
			return false;
		if (tipoDecisao == null) {
			if (other.tipoDecisao != null)
				return false;
		} else if (!tipoDecisao.equals(other.tipoDecisao))
			return false;
		return true;
	}
}