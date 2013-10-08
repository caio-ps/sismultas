package br.com.fiap.sismultas.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NoResultException;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;

import br.com.fiap.sismultas.domain.manager.EntityManagerContainer;


/**
 * The persistent class for the pessoa database table.
 * 
 */
@Entity
@Table(name="pessoa")
@NamedQueries({
	@NamedQuery(name="pessoaPorUsuario", query="SELECT p FROM Pessoa p WHERE p.usuario = ?1")
})
public class Pessoa extends EntityManagerContainer implements Serializable {

	private static final long serialVersionUID = 8521583045184939558L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="cnh")
	private String cnh;

	@Column(name="cpf")
	private String cpf;

	@Column(name="email")
	private String email;

	@Column(name="nome")
	private String nome;

	@Column(name="senha")
	private String senha;

	@Column(name="sobrenome")
	private String sobrenome;

	@Column(name="telefone")
	private String telefone;

	@Column(name="usuario")
	private String usuario;

	@OneToMany(mappedBy="pessoa")
	private List<Infracao> infracaos;

	@ManyToMany
	@JoinTable(
		name="pessoa_perfil"
		, joinColumns={
			@JoinColumn(name="id_pessoa")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_perfil")
			}
		)
	private List<Perfil> perfils;

	@OneToMany(mappedBy="pessoa")
	private List<Veiculo> veiculos;
	
	//------ Métodos da entidade ------//

	/**
	 * Busca uma pessoa por id
	 * 
	 * @param id
	 * @return
	 */
	public static Pessoa buscaPorId(Long id) {
		
		return getEntityManager().find(Pessoa.class, id);
		
	}
	
	/**
	 * Busca pessoa pelo nome de usuário
	 * 
	 * @param usuario
	 * @return
	 */
	public static Pessoa buscaPorUsuario(String usuario) {
		
		try {
		
			Query query = getEntityManager().createNamedQuery("pessoaPorUsuario", Pessoa.class);
			query.setParameter(1, usuario);
			Pessoa pessoa = (Pessoa) query.getSingleResult();
			
			return pessoa;
		
		} catch (NoResultException nre) {
			return null;
		}
		
	}
	
	//---------------------------------//
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCnh() {
		return this.cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSobrenome() {
		return this.sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Infracao> getInfracaos() {
		return this.infracaos;
	}

	public void setInfracaos(List<Infracao> infracaos) {
		this.infracaos = infracaos;
	}

	public List<Perfil> getPerfils() {
		return this.perfils;
	}

	public void setPerfils(List<Perfil> perfils) {
		this.perfils = perfils;
	}

	public List<Veiculo> getVeiculos() {
		return this.veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

}