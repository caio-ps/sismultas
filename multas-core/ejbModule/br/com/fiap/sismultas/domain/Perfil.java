package br.com.fiap.sismultas.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.Table;

import br.com.fiap.sismultas.domain.manager.EntityManagerContainer;


/**
 * The persistent class for the perfil database table.
 * 
 */
@Entity
@Table(name="perfil")
@NamedQueries({
	@NamedQuery(name="todosPerfis", query="SELECT p FROM Perfil p")
})
public class Perfil extends EntityManagerContainer implements Serializable {

	private static final long serialVersionUID = -1100082188895348023L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="descricao")
	private String descricao;

	@ManyToMany(mappedBy="perfils")
	private List<Pessoa> pessoas;
	
	//------ Métodos da entidade ------//
	@SuppressWarnings("unchecked")
	public static List<Perfil> buscaTodos() {
		
		Query query = getEntityManager().createNamedQuery("todosPerfis", Perfil.class);
		List<Perfil> perfis = (List<Perfil>) query.getResultList();
		
		return perfis;
		
	}
	//---------------------------------//

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Pessoa> getPessoas() {
		return this.pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

}