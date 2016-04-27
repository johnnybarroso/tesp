package br.unibh.seguros.entidades;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	
	public Usuario(){}
	
	public Usuario(String nome, String login, String senha, String perfil, String cargo, String email,
			Date dataCadastro, Setor setor) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
		this.cargo = cargo;
		this.email = email;
		this.dataCadastro = dataCadastro;
		this.setor = setor;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nome",columnDefinition="varchar(100)", nullable=false)
	@NotNull
	@Size(min = 5, max = 100)
	@Pattern(regexp = "[A-zÀ-ú ]*", message = "Deve conter apenas letras e espaços")
	private String nome;
	
	@Column(name="login",columnDefinition="char(11)", nullable=false, unique=true)
	@Size(min = 8, max = 15)
	@NotNull
	@Pattern(regexp = "[A-z0-9]*", message = "Deve conter apenas letras e não é permitido caracteres especiais")
	private String login;
	
	@Column(name="senha",columnDefinition="char(14)", nullable=true)
	@Size(min = 8, max = 15)
	@NotBlank
	private String senha;
	
	@Column(name="perfil",columnDefinition="char(14)", nullable=false)
	@NotNull
	@Size(min = 5, max = 100)
	@Pattern(regexp = "[A-zÀ-ú ]*", message = "Deve conter apenas letras e espaços")
	private String perfil;
	
	@Column(name="cargo",columnDefinition="char(14)", nullable=true)
	@NotNull
	@Size(min = 5, max = 100)
	@Pattern(regexp = "[A-zÀ-ú ]*", message = "Deve conter apenas letras e espaços")
	private String cargo;
	
	@Column(name="email",columnDefinition="varchar(100)", nullable=true)
	@Email
	@Size(max = 100)
	private String email;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_cadastro", nullable=false)
	private Date dataCadastro;
	
	@ManyToOne(fetch=FetchType.EAGER)
	private Setor setor;
	
	@OneToMany(mappedBy="usuarioDecisao", fetch=FetchType.LAZY)
	private Collection<Tramitacao> tramitacoes;
	
	
	
	
	
	public Collection<Tramitacao> getTramitacoes() {
		return tramitacoes;
	}

	public void setTramitacoes(Collection<Tramitacao> tramitacoes) {
		this.tramitacoes = tramitacoes;
	}

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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}


	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", login=" + login + ", senha=" + senha + ", perfil=" + perfil
				+ ", cargo=" + cargo + ", email=" + email + ", dataCadastro=" + dataCadastro + ", setor=" + setor
				+ ", tramitacoes=" + tramitacoes + "]";
	}
}