package br.unibh.seguros.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "tb_tramitacao")
public class Tramitacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="etapa_processo",columnDefinition="varchar(30)", nullable=false)
	@NotNull
	@Pattern(regexp = "[A-zÀ-ú ]", message = "Somente letras e espaços")
	@Max(30)
	private String etapaProcesso;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_hora", nullable=false)
	private Date dataHora;
	
	@Column(name="situacao_inicial",columnDefinition="varchar(50)", nullable=false)
	@NotNull
	@Pattern(regexp = "[A-zÀ-ú ]", message = "Somente letras e espaços")
	@Max(50)
	private String situacaoInicial;
	
	@Column(name="situacao_final",columnDefinition="varchar(50)", nullable=false)
	@Pattern(regexp = "[A-zÀ-ú ]", message = "Somente letras e espaços")
	@NotNull
	@Max(50)
	private String situacaoFinal;
	
	@Column(name="tipo_decisao",columnDefinition="varchar(100)", nullable=false)
	@NotNull
	@Max(100)
	@Pattern(regexp = "[A-zÀ-ú ]", message = "Somente letras e espaços")
	private String tipoDecisao;
	
	@Column(name="comentario",columnDefinition="varchar(4000)", nullable=true)
	@Pattern(regexp = "[A-zÀ-ú ]", message = "Somente letras e espaços")
	@Max(4000)
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

	@Override
	public String toString() {
		return "Tramitacao [id=" + id + ", etapaProcesso=" + etapaProcesso + ", dataHora=" + dataHora
				+ ", situacaoInicial=" + situacaoInicial + ", situacaoFinal=" + situacaoFinal + ", tipoDecisao="
				+ tipoDecisao + ", comentario=" + comentario + ", documento=" + documento + ", propostas=" + proposta
				+ ", setorResponsavel=" + setorResponsavel + ", usuarioDecisao=" + usuarioDecisao + "]";
	}
}