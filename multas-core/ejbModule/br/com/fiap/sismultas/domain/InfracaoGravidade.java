package br.com.fiap.sismultas.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;

import br.com.fiap.sismultas.domain.manager.EntityManagerContainer;


/**
 * The persistent class for the infracao_gravidade database table.
 * 
 */
@Entity
@Table(name="infracao_gravidade")
@NamedQueries({
	@NamedQuery(name="todasGravidades", query="SELECT ig FROM InfracaoGravidade ig")
})
public class InfracaoGravidade extends EntityManagerContainer implements Serializable {

	private static final long serialVersionUID = 512041461543956556L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="descricao")
	private String descricao;

	@Column(name="pontos")
	private Integer pontos;

	@OneToMany(mappedBy="infracaoGravidade")
	private List<ItemCtb> itemCtbs;
	
	//------ Métodos da entidade ------//
	/**
	 * Busca todas as gravidades cadastradas
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<InfracaoGravidade> buscaTodos() {
		
		Query query = getEntityManager().createNamedQuery("todasGravidades", InfracaoGravidade.class);
		List<InfracaoGravidade> gravidades = (List<InfracaoGravidade>) query.getResultList();
		
		return gravidades;
		
	}
	
	/**
	 * Busca pelo id
	 * 
	 * @param chassi
	 * @return
	 */
	public static InfracaoGravidade find(Long id) {
		
		return getEntityManager().find(InfracaoGravidade.class, id);
		
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

	public Integer getPontos() {
		return this.pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

	public List<ItemCtb> getItemCtbs() {
		return this.itemCtbs;
	}

	public void setItemCtbs(List<ItemCtb> itemCtbs) {
		this.itemCtbs = itemCtbs;
	}

}